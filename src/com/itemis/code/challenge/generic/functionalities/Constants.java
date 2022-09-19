package com.itemis.code.challenge.generic.functionalities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Constants {

	public static List<String> CHECKOUT_VALUES = Arrays.asList("yes", "no");

	public static final Double BASIC_SALES_TAX = 10.00d;

	public static final Double IMPORT_TAX = 5.00d;

	public static List<String> EXEMPTED_CATEGORY_LIST = Arrays.asList("book", "food", "medical");

	public static final String IMPORTED = "imported";

	public static final Double ROUNDING_FACTOR = 0.05;

	public static final String AT = "at";

	public static final String DE_LIMITER = " ";

	public static final String YES = "yes";

	public static final String NO = "no";

	public static final HashMap<String, String> ITEM_CATEGORY_MAP = new HashMap<String, String>();
	static {
		ITEM_CATEGORY_MAP.put("book", "book");
		ITEM_CATEGORY_MAP.put("books", "book");
		ITEM_CATEGORY_MAP.put("chocolate", "food");
		ITEM_CATEGORY_MAP.put("chocolates", "food");
		ITEM_CATEGORY_MAP.put("pill", "medical");
		ITEM_CATEGORY_MAP.put("pills", "medical");
		ITEM_CATEGORY_MAP.put("cd", "music");
		ITEM_CATEGORY_MAP.put("cds", "music");
	}

//	public static List<String> EXEMPTED_LIST = Arrays.asList("book", "books", "food", "medical", "chocolate", "chocolates", "pill", "pills");


}
