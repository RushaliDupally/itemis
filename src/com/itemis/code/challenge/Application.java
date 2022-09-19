package com.itemis.code.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itemis.code.challenge.dto.ItemDetailsDTO;
import com.itemis.code.challenge.generic.functionalities.Constants;
import com.itemis.code.challenge.generic.functionalities.GenericMethods;

public class Application {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);	
		boolean isCheckout = false;
		List<String> inputList = new ArrayList<String>();
		List<ItemDetailsDTO> itemDetailsList = new ArrayList<ItemDetailsDTO>();		
		
		// Reading the input data from console
		while(!isCheckout) {
			System.out.println("Please enter the item details in the following format: '(Quantity) (item) at (price).'[e.g: 1 imported box of chocolates at 10.00] ");
			String itemValue = scanner.nextLine();
			while(itemValue == null || itemValue.trim() == "" || !itemValue.contains(Constants.AT) || itemValue.split(" ").length < 4) {
				System.out.println("The entered value is invalid. PLease enter the item details in the valid format: '(Quantity) (item) at (price).'[e.g: 1 imported box of chocolates at 10.00] ");
				itemValue = scanner.nextLine();
			}
			if(itemValue != null && itemValue.trim() != "") {
				boolean isInValid = true;
				while(isInValid) {
					String[] wordList = itemValue.trim().split(Constants.DE_LIMITER);
					if(wordList.length > 0) {
						Integer quantity = GenericMethods.getQuantity(wordList);
						isInValid = quantity <0;
						if(!isInValid) {
							Double price = GenericMethods.getPrice(wordList);
							isInValid = price <0;
						}
					}
					if(isInValid) {
						System.out.println("Quantity and price cannot contain negative values. Please enter a valid Input.");
						itemValue = scanner.nextLine();
					}
				}

			}
			inputList.add(itemValue.toLowerCase());
			System.out.println("Do you want to check out? Enter yes or no");
			String checkoutDecision = scanner.nextLine();
			while(!Constants.CHECKOUT_VALUES.contains(checkoutDecision)) {
				System.out.println("Please enter a validValue, The Valid values for checkout are Yes or No");
				checkoutDecision = scanner.nextLine();
			}
			isCheckout = checkoutDecision != null && checkoutDecision != "" && checkoutDecision.toLowerCase().equals(Constants.YES);
		}
		
		if(isCheckout) {
			if(!inputList.isEmpty()) {
				for(String input : inputList) {				
					ItemDetailsDTO itemDetails = GenericMethods.buildItemDetailsDTO(input);
					itemDetailsList.add(itemDetails);
				}
			}
			GenericMethods.printReceiptOutput(itemDetailsList);
		}
		
		/*
		 * To Read from a file
		 * 
		if(isCheckout) {
			File file = new File("C:/workspace/itemis/Itemis/src/com/itemis/code/challenge/testCase2.txt");
			Scanner input = new Scanner(file);
			List<ItemDetailsDTO> itemDetailsList = new ArrayList<ItemDetailsDTO>();
			while (input.hasNextLine()) {
				String line = input.nextLine().toLowerCase(); // take the line
				if(line != null && line != "") {
					String[] wordList = line.split(Constants.DE_LIMITER);
					Integer quantity = GenericMethods.getQuantity(wordList);				
					String itemName = GenericMethods.getItemName(line);				
					Double price = GenericMethods.getPrice(wordList);				
					boolean isImported = line.toLowerCase().contains(Constants.IMPORTED);
					boolean isExempted = GenericMethods.isExempted(line);
					Double importTax = isImported ? GenericMethods.formatTo2Decimals(GenericMethods.calculateImportTax(price)) : 0.00;
					Double basicSalesTax = isExempted ? 0.00 : GenericMethods.formatTo2Decimals(GenericMethods.calculateBasicTax(price));
					Double totalTaxes = GenericMethods.formatTo2Decimals(importTax + basicSalesTax);
					Double costWithTaxes = GenericMethods.formatTo2Decimals(price + totalTaxes);				
					ItemDetailsDTO itemDetails = new ItemDetailsDTO(quantity, itemName, price, basicSalesTax, importTax, costWithTaxes, totalTaxes);
					itemDetailsList.add(itemDetails);
				}
			}
			// Printing the Output
			GenericMethods.printReceiptOutput(itemDetailsList);
		}*/
	}
	

}
