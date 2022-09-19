package com.itemis.code.challenge.generic.functionalities;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import com.itemis.code.challenge.dto.ItemDetailsDTO;
import com.itemis.code.challenge.dto.ReceiptDTO;

public class GenericMethods {

		public static Double calculateImportTax(Double price) {
			Double importTax = (double) Math.round(Constants.IMPORT_TAX * price) / 100.00;
			return Math.ceil(importTax / Constants.ROUNDING_FACTOR)*Constants.ROUNDING_FACTOR;
		}
		
		public static Double calculateBasicTax(Double price) {
			Double salesTax = (double) Math.round(Constants.BASIC_SALES_TAX * price)/100.00;
			return Math.ceil(salesTax / Constants.ROUNDING_FACTOR)*Constants.ROUNDING_FACTOR;
		}
		
		public static boolean isNotEmpty(String itemName) {
			return itemName != null && itemName != "";
		}
		
		public static boolean isExemptedCategory(String line) {
			int itemIndex = -1;
			for(Map.Entry<String, String> entry : Constants.ITEM_CATEGORY_MAP.entrySet()) {
				if(line.contains(entry.getKey()) && Constants.EXEMPTED_CATEGORY_LIST.contains(entry.getValue())) {
					itemIndex = line.indexOf(entry.getKey());
				}
			}
			boolean isExempted = (itemIndex != -1) ? true : false;
			return isExempted;
		}
		
		public static void printReceiptOutput(List<ItemDetailsDTO> itemDetailsList) {
			// calculate total taxes and total amount
			Double totalAmount = itemDetailsList.stream().map(item -> item.getCostWithTaxes()).mapToDouble(cost -> cost).sum();
			Double totalTaxes = itemDetailsList.stream().map(item -> item.getTotalTax()).mapToDouble(tax -> tax).sum();
			
			ReceiptDTO receipt = new ReceiptDTO();
			receipt.setItemDetails(itemDetailsList);
			receipt.setSalesTax(totalTaxes);
			receipt.setTotal(totalAmount);
			System.out.println("==========================");
			System.out.println("Bill Details");
			if(!receipt.getItemDetails().isEmpty()) {
				for(ItemDetailsDTO itemDetail: receipt.getItemDetails()) {
					System.out.print(itemDetail.getQuantity()+ " " + itemDetail.getItemName() +": " + itemDetail.getCostWithTaxes());
					System.out.println();
				}
				System.out.println("Sales Tax: " + receipt.getSalesTax());
				System.out.println("Total: " + receipt.getTotal());
			}
		}
		
		public static final Double formatTo2Decimals(Double amount) {
			DecimalFormat df = new DecimalFormat(".##");
			return Double.parseDouble(df.format(amount));
		}
		
		public static Integer getQuantity(String[] wordList) {
			return Integer.parseInt(wordList[0]);
		}
		public static Double getPrice(String[] wordList) {
			String cost = wordList[wordList.length-1];
			Double price = Double.parseDouble(cost);
			return price;
		}

		public static String getItemName(String line) {		
			int itemIndexOfAt = line.lastIndexOf(Constants.AT);
			String itemName = "";
			if(itemIndexOfAt != -1) {
				itemName = line.substring(1, itemIndexOfAt).trim();
			}
			return itemName;					
		}
		
		public static ItemDetailsDTO buildItemDetailsDTO(String input) {
			String[] wordList = input.split(Constants.DE_LIMITER);
			Integer quantity = GenericMethods.getQuantity(wordList);				
			String itemName = GenericMethods.getItemName(input);				
			Double price = GenericMethods.getPrice(wordList);				
			boolean isImported = input.toLowerCase().contains(Constants.IMPORTED);
			boolean isExempted = GenericMethods.isExemptedCategory(input);
			Double importTax = isImported ? GenericMethods.formatTo2Decimals(GenericMethods.calculateImportTax(price)) : 0.00;
			Double basicSalesTax = isExempted ? 0.00 : GenericMethods.formatTo2Decimals(GenericMethods.calculateBasicTax(price));
			Double totalTaxes = GenericMethods.formatTo2Decimals(importTax + basicSalesTax);
			Double costWithTaxes = GenericMethods.formatTo2Decimals(price + totalTaxes);				
			ItemDetailsDTO itemDetails = new ItemDetailsDTO(quantity, itemName, price, basicSalesTax, importTax, costWithTaxes, totalTaxes);
			return itemDetails;		
		}
		
		/*
		public static boolean isExempted(String line) {
			List<String> exemptedList = Constants.EXEMPTED_LIST;
			int itemIndex = -1;
			for(String item: exemptedList) {
				if(line.contains(item)) {
					itemIndex = line.indexOf(item);				
				}
			}
			boolean isExempted = (itemIndex != -1) ? true : false;
			return isExempted;
		}*/
		

}
