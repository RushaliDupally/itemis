package com.itemis.code.challenge.dto;

import com.itemis.code.challenge.generic.functionalities.GenericMethods;

public class ItemDetailsDTO {
	
	private Integer quantity;
	private String itemName;
	private Double cost;
	private Double basicTax;
	private Double importTax;
	private Double costWithTaxes;
	private Double totalTax;
	
	public ItemDetailsDTO(Integer quantity, String itemName, Double cost, Double basicTax, Double importTax,
			Double costWithTaxes, Double totalTax) {
		super();
		this.quantity = quantity;
		this.itemName = itemName;
		this.cost = cost;
		this.basicTax = basicTax;
		this.importTax = importTax;
		this.costWithTaxes = costWithTaxes;
		this.totalTax = totalTax;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = GenericMethods.formatTo2Decimals(cost);
	}
	public Double getBasicTax() {
		return basicTax;
	}
	public void setBasicTax(Double basicTax) {
		this.basicTax = GenericMethods.formatTo2Decimals(basicTax);
	}
	public Double getImportTax() {
		return importTax;
	}
	public void setImportTax(Double importTax) {
		this.importTax = GenericMethods.formatTo2Decimals(importTax);
	}
	public Double getCostWithTaxes() {
		return costWithTaxes;
	}
	public void setCostWithTaxes(Double costWithTaxes) {
		this.costWithTaxes = GenericMethods.formatTo2Decimals(costWithTaxes);
	}
	public Double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(Double totalTax) {
		this.totalTax = GenericMethods.formatTo2Decimals(totalTax);
	}
	
}
