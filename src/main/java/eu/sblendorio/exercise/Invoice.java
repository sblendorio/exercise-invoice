package eu.sblendorio.exercise;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;
import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.toList;

public class Invoice {

    public static class InvoiceRow {
        private final String description;
        private final int count;
        private final BigDecimal price;

        public InvoiceRow(int count, String description, BigDecimal price) {
            this.description = description;
            this.count = count;
            this.price = price;
        }

        @Override
        public String toString() {
            return count + " " + description + ": " + price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InvoiceRow that = (InvoiceRow) o;
            return count == that.count && Objects.equals(description, that.description) && Objects.equals(price, that.price);
        }
    }

    private Map<Item, Integer> invoiceItems = new LinkedHashMap<>();

    public void add(Item item) {
        final int count = invoiceItems.getOrDefault(item, 0);
        invoiceItems.put(item, count + 1);
    }

    public List<InvoiceRow> getRows() {
        return invoiceItems.entrySet().stream()
                .map(x -> new InvoiceRow(
                        x.getValue(),
                        x.getKey().getDescription(),
                        x.getKey().getFinalPrice().multiply(valueOf(x.getValue()))))
                .collect(toList());
    }

    public BigDecimal getSalesTax() {
        return invoiceItems.entrySet().stream()
                .map(x -> x.getKey().getSalesTax().multiply(valueOf(x.getValue())))
                .reduce(BigDecimal::add)
                .orElse(ZERO);
    }

    public BigDecimal getTotal() {
        return invoiceItems.entrySet().stream()
                .map(x -> x.getKey().getFinalPrice().multiply(valueOf(x.getValue())))
                .reduce(BigDecimal::add)
                .orElse(ZERO);
    }

    public String toString() {
        return getRows().stream()
                .map(InvoiceRow::toString)
                .reduce((x,y) -> x + "\n" + y)
                .orElse("")
                + "\n"
                + "Sales Taxes: " + getSalesTax() + "\n"
                + "Total: " + getTotal();
    }
}
