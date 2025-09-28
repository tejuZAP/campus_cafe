package campus_cafe.model;

import java.math.BigDecimal;

public enum BeverageSize {
	MEDIUM(new BigDecimal("0.025")), 
	LARGE(new BigDecimal("0.050")), 
	SMALL(new BigDecimal("0.00"));
	
	private BigDecimal amount;

	BeverageSize(BigDecimal bigDecimal) {
		this.amount = amount;// TODO Auto-generated constructor stub
	}

	BigDecimal getSurcharge() {
		return this.amount;
	}

}
