# itemis
# Problem 1: SALES TAXES
## Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

### INPUT:
Input 1:
> 1 book at 12.49
> 1 music CD at 14.99
> 1 chocolate bar at 0.85
Input 2:
> 1 imported box of chocolates at 10.00
> 1 imported bottle of perfume at 47.50
Input 3:
> 1 imported bottle of perfume at 27.99
> 1 bottle of perfume at 18.99
> 1 packet of headache pills at 9.75
> 1 box of imported chocolates at 11.25

### OUTPUT
Output 1:
> 1 book: 12.49
> 1 music CD: 16.49
> 1 chocolate bar: 0.85
> Sales Taxes: 1.50
> Total: 29.83
Output 2:
> 1 imported box of chocolates: 10.50
> 1 imported bottle of perfume: 54.65
> Sales Taxes: 7.65
> Total: 65.15
Output 3:
> 1 imported bottle of perfume: 32.19
> 1 bottle of perfume: 20.89
> 1 packet of headache pills: 9.75
> 1 imported box of chocolates: 11.85
> Sales Taxes: 6.70
> Total: 74.68

# How To Run
Compile the project into a jar, or load the .java files into your favorite IDE and run the main method found in the **Application** class.

# Techologies Used
Java 11

# Libraries Used
Math

# Assumptions Made
1. Input will be entered in the following format '(Quantity) (item) at (price).'
2. If any item is imported, it should have the word imported in them.
3. If any category is to be exempted, then that should be added in the EXEMPTED_CATEGORY_LIST list present in constants.java class of com.itemis.code.challenge.generic.functionalities package and the respective entry should be put in the ITEM_CATEGORY_MAP map.

# Validations Handled
1. Entered value is null
2. Entered value is empty
3. Entered value is not in the format mentioned.
4. Quantity is Negative.
5. Price is Negative.

# How the program runs
1. User will be asked to enter the item selected.
2. Validtion to check if the item is valid and in the repective format.
      1. if Not Valid: Tell the user that the entered value is not valid. Please enter again. And Go back to step 2.
      2. if Valid: User will be asked if he wants to checkout.
            1.  if Yes: Display the Output.
            2.  if No: Ask the User to add another item.
3. One the user answers yes for checkout. Calculate the taxes based on if the item is imported(5% on actual cost), exempted(10% on actual cost) and display the output.

# Overview of the Program
1. com.itemis.code.challenge.generic.functionalities package
       1. Constants class -> Has all the constants used in the Application.
       2. GenericMethods class -> has all the Generic Methods used across the Application(e.g: calculateImportTax(), isExemptedCategory(), printReceiptOutput() etc.).
2. com.itemis.code.challenge.dto packge --> Has the models/DTOs used in the Application.
       1. ItemDetailsDTO --> has the item Details(quantity, itemName, cos, basicTax, importTax, totalTax, costWithTaxes).
       2. ReceiptDTO --> Has the details regarding the output to be printed on the screen. (List of items, salesTax, total).
3. com.itemis.code.challenge --> has the main Method
        1. Application.java --> Has the Main Method
              1. Read the data from input using scanner.
              2. validate the input.
              3. get the quantity, item name and cost details.
              4. Check if the item is imported.
              5. Check if the item is exempted.
              6. Based on the type of the item(imported/ exempted), calculate the applicable taxes like Import Tax, Basic Sales Tax etc.
              7. Calculate the total tax.
              8. Calculate the Total amount.
              9. Print on the screen in the Required Format.

# Sample Execution
==========================
Please enter the item details in the following format: '(Quantity) (item) at (price).'[e.g: 1 imported box of chocolates at 10.00]
1 imported bottle of perfume at 27.99
Do you want to check out? Enter yes or no
no
Please enter the item details in the following format: '(Quantity) (item) at (price).'[e.g: 1 imported box of chocolates at 10.00]
1 bottle of perfume at 18.99
Do you want to check out? Enter yes or no
no
Please enter the item details in the following format: '(Quantity) (item) at (price).'[e.g: 1 imported box of chocolates at 10.00]
1 packet of headache pills at 9.75
Do you want to check out? Enter yes or no
no
Please enter the item details in the following format: '(Quantity) (item) at (price).'[e.g: 1 imported box of chocolates at 10.00] 
1 imported box of chocolates at 11.25
Do you want to check out? Enter yes or no 
yes
Bill Details
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Tax: 6.7
Total: 74.68
