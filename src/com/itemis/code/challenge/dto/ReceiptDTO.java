package com.itemis.code.challenge.dto;

import java.util.List;

import com.itemis.code.challenge.generic.functionalities.GenericMethods;

public class ReceiptDTO {
	
	public List<ItemDetailsDTO> itemDetails;
	public Double salesTax;
	public Double total;
	
	public List<ItemDetailsDTO> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(List<ItemDetailsDTO> itemDetails) {
		this.itemDetails = itemDetails;
	}
	public Double getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = GenericMethods.formatTo2Decimals(total);
	}
	
}
