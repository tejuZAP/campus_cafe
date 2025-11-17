package campus_cafe.model;

import java.math.BigDecimal;

public class LineItem {
	private String name;
	private int quantity;
	private BigDecimal cost;
	
	public LineItem(String name, int quantity, BigDecimal cost) {
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public BigDecimal getCost () {
		return this.cost;
	}
	
	public int getQuantity () {
		return this.quantity;
	}
	
	public String getName() {
		return this.name;
	}
}
