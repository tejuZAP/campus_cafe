package campus_cafe;

import campus_cafe.data.*;
import campus_cafe.model.*;

import java.util.*;
import java.math.BigDecimal;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Order order = new Order();
		
		Menu menu = new Menu();
		String menuOption = getMenuOption(menu);
		while (!menuOption.equalsIgnoreCase("end")) {		
			Product item = menu.getMenuItem(menuOption);
			if(item == null) {
				System.out.println("Youre selection is invalid");
				continue;
			}
			
			//Get the quantity from the user.
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			item.setQuantity(quantity);
			
			if(item instanceof Beverage) {
				BeverageSize beverageSize = getBeverageSize();
				((Beverage) item) .setBeverageSize(beverageSize);
			}
			
			if(item instanceof Food) {
				Addon addon = getAddon();
				((Food) item) .setAddon(addon);
			}
			
			//order.addLineItem(item.getName(), quantity, item.price());
			order.addLineItem(item);
			
			System.out.println(String.format("\nYou selected: %s -- %s -- %.2f -- total price, %.2f",
					item.getId(), item.getName(), item.getBasePrice(), item.price()));
			
			menuOption = getMenuOption(menu);
		} 
		
		System.out.println("\n--- End of Order ---\n");
		
		//Print Line Items from order
		
		List<String> lineItems = order.getFormattedLineItems();
		for(String lineItem : lineItems) {
			System.out.println(lineItem);
		}
		
		BigDecimal tax = order.calculateTotalSalesTax();
		System.out.println(String.format("\nSales Tax: %.2f", tax));
	}
	
	private static BeverageSize getBeverageSize() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Addon getAddon() {
		// TODO Auto-generated method stub
		return null;
	}

	private static String getMenuOption(Menu menu) {
		menu.DisplayMenu();
		System.out.print("\nPlease make selection: ");
		
		return sc.nextLine();
	}
	
	private static BeverageSize getBeverageSize() {
		System.out.print("Please select (S)mall, (M)edium, or (L)arge: ");
		String sizeOption = sc.nextLine();
		sizeOption = sizeOption.trim().toUpperCase();
		if(sizeOption.equals("M") | sizeOption.startsWith("MEDIUM"))
			return BeverageSize.MEDIUM;
		else if(sizeOption.equals("L") | sizeOption.startsWith("LARGE"))
			return BeverageSize.LARGE;
		else
			return BeverageSize.SMALL;
	}
	
	private static Addon getAddon() {
		System.out.print("Extra Cheese? (y) / (N): ");
		String addonOption = sc.nextLine();
		addonOption = addonOption.trim().toUpperCase();
		if(addonOption.equals("y") | addonOption.startsWith("cheese"))
			return Addon.cheese;
		else if(addonOption.equals("L") | addonOption.startsWith("nocheese"))
			return Addon.nocheese;
		return null;
	}
}
