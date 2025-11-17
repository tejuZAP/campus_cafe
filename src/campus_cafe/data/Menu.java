package campus_cafe.data;

import campus_cafe.model.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.ArrayList;

public class Menu {
	private List<Product> items = new ArrayList<>();
			
	public Menu() {
		BuildMenu();
	}
	
	private void BuildMenu() {
		Beverage bev = new Beverage("B01", "Coffee", BigDecimal.valueOf(2.50));
		items.add(bev);
		
		bev = new Beverage("B02", "Tea", BigDecimal.valueOf(3.50));
		items.add(bev);
	
		Food food = new Food("F01", "Breakfast Sandwich", BigDecimal.valueOf(4.25));
		items.add(food);
		
		food = new Food("F02", "Bagel", BigDecimal.valueOf(1.75));
		items.add(food);
	}

	public void DisplayMenu() {
		System.out.println("\nWelcome to the Campus Cafe\n");
		System.out.println("Please select from the following . . .");
		
		for(Product item : items ) {
			System.out.println(String.format("%s -- %s: $%2f", 
					item.getId(), item.getName(), item.getBasePrice()));
		}
	}
	
	public Product getMenuItem(String id) {
		for(Product item : items) {
			if(item.getId().equalsIgnoreCase(id)) {
				return item;
			}
	}
	
	return null;
	}
}
