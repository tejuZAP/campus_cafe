package campus_cafe.model;

import java.util.*;
import java.math.BigDecimal;

public class Order {
	List<LineItem> lineItems = new ArrayList<>();
	
	public Order () {
		
	}
	
	public void addLineItem(String name, int quantity, BigDecimal cost) {
		LineItem item = new LineItem(name, quantity, cost);
		
		lineItems.add(item);
	}
	
	// Overloaded Method
	public void addLineItem(Product product) {
		addLineItem(product.getName(), product.getQuantity(), product.getBasePrice());
	}
	
	public BigDecimal calculateTotalSalesTax() {
		BigDecimal salesTax = BigDecimal.valueOf(0);
		
		for(LineItem lineItem : lineItems) {
			salesTax = salesTax.add(lineItem.getCost()
					.multiply(BigDecimal.valueOf(.085)
							.multiply(BigDecimal.valueOf(lineItem.getQuantity()))));
		}
		
		return salesTax;
	}
	
	public BigDecimal calculateTotalOrder() {
		BigDecimal grandTotal = BigDecimal.valueOf(0);
		
		for(LineItem lineItem : lineItems) {
			grandTotal = grandTotal.add(lineItem.getCost());
		}
		
		grandTotal = grandTotal.add(calculateSalesTax());
		
		return grandTotal;
	}
	
	private BigDecimal calculateSalesTax() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getFormattedLineItems() {
		List<String> formattedItems = new ArrayList<>();
		for(LineItem lineItem: lineItems) {
			 formattedItems.add(String.format("(%d %s -- $%.2f", 
					lineItem.getQuantity(),lineItem.getName(), lineItem.getCost()));
		}
		
		return formattedItems;
	}
}
