package campus_cafe.model;

import java.math.BigDecimal;

public class Beverage extends Product {
	private BeverageSize beverageSize;
	
	public Beverage(String id, String name, BigDecimal basePrice) {
		super(id, name, basePrice);
	}
	
	//Overriding Method
	public BigDecimal price() {
		BigDecimal price = this.getBasePrice().add(beverageSize.getSurcharge());
		
		return price.multiply(BigDecimal.valueOf(getQuantity()));
	}
	
	public void setBeverageSize(BeverageSize beverageSize) {
		this.beverageSize = beverageSize;
	}
}
