package campus_cafe.model;

import java.math.BigDecimal;

public class Food extends Product{
	private Addon addon;
	
	public Food(String id, String name, BigDecimal basePrice) {
		super(id, name, basePrice);
	}
	
	//Overriding Method
	public BigDecimal price() {
		BigDecimal price = this.getBasePrice().add(addon.getSurcharge());
		
		return price.multiply(BigDecimal.valueOf(getQuantity()));
	}
	
	public void setAddon(Addon addon) {
		this.addon = addon;
	}
}
