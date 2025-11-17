package campus_cafe.model;

import java.math.BigDecimal;

public class Beverage extends Product {
    private BeverageSize beverageSize = BeverageSize.SMALL; // DEFAULT

    public Beverage(String id, String name, BigDecimal basePrice) {
        super(id, name, basePrice);
    }

    @Override
    public BigDecimal price() {
        // Prevent NPE 
        BeverageSize size = (beverageSize != null) ? beverageSize : BeverageSize.SMALL;

        BigDecimal surcharge = size.getSurcharge();
        if (surcharge == null) surcharge = BigDecimal.ZERO;  // Safety fallback

        BigDecimal price = getBasePrice().add(surcharge);
        return price.multiply(BigDecimal.valueOf(getQuantity()));
    }

    public void setBeverageSize(BeverageSize beverageSize) {
        this.beverageSize = (beverageSize != null) 
            ? beverageSize 
            : BeverageSize.SMALL; // No null allowed
    }
}