package campus_cafe.model;

import java.math.BigDecimal;

public enum Addon {
	cheese(new BigDecimal("0.010")), 
	nocheese(new BigDecimal("0.00"));
	
	private BigDecimal amount;

	Addon(BigDecimal bigDecimal) {
		this.amount = amount;
	}

	BigDecimal getSurcharge() {
		// TODO Auto-generated method stub
		return amount;
	}

}
