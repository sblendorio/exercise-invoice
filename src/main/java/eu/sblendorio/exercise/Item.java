package eu.sblendorio.exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static java.math.BigDecimal.*;

public class Item {

    private final String description;
    private final BigDecimal price;
    private final Category category;
    private final boolean imported;

    public Item(String description, BigDecimal price, Category category, boolean imported) {
        this.description = description;
        this.price = price;
        this.category = category;
        this.imported = imported;
    }

    public BigDecimal getSalesTax() {
        final BigDecimal salesTaxRate = category.getBasicSalesTaxRate().add(imported ? category.getImportDutyRate() : ZERO);
        final BigDecimal salesTax = price.multiply(salesTaxRate.divide(valueOf(100)));

        return salesTax
                .multiply(valueOf(20))
                .setScale(0, RoundingMode.CEILING)
                .divide(valueOf(20))
                .setScale(2, RoundingMode.UNNECESSARY);
    }

    public BigDecimal getFinalPrice() {
        return price.add(getSalesTax());
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return imported == item.imported &&
                Objects.equals(description, item.description) &&
                Objects.equals(price, item.price) &&
                category == item.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, category, imported);
    }
}
