package eu.sblendorio.exercise;

import eu.sblendorio.exercise.Invoice.InvoiceRow;
import org.junit.Test;

import java.math.BigDecimal;

import static eu.sblendorio.exercise.Category.*;
import static java.math.BigDecimal.ZERO;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class InvoiceTest {

    @Test
    public void shouldReturn1_50asSalesTaxAnd29_83asTotal() {
        Invoice invoice = new Invoice();

        invoice.add(new Item("book", new BigDecimal("12.49"), BOOK, false));
        invoice.add(new Item("music CD", new BigDecimal("14.99"), GENERIC, false));
        invoice.add(new Item("chocolate bar", new BigDecimal("0.85"), FOOD, false));

        assertEquals(
            asList(
                new InvoiceRow(1, "book", new BigDecimal("12.49")),
                new InvoiceRow(1, "music CD", new BigDecimal("16.49")),
                new InvoiceRow(1, "chocolate bar", new BigDecimal("0.85"))
            ),
            invoice.getRows()
        );
        assertEquals(new BigDecimal("1.50"), invoice.getSalesTax());
        assertEquals(new BigDecimal("29.83"), invoice.getTotal());
    }

    @Test
    public void shouldReturn7_65asSalesTaxAnd65_15asTotal() {
        Invoice invoice = new Invoice();

        invoice.add(new Item("imported box of chocolate", new BigDecimal("10.00"), FOOD, true));
        invoice.add(new Item("imported bottle of perfume", new BigDecimal("47.50"), GENERIC, true));

        assertEquals(
            asList(
                new InvoiceRow(1, "imported box of chocolate", new BigDecimal("10.50")),
                new InvoiceRow(1, "imported bottle of perfume", new BigDecimal("54.65"))
            ),
            invoice.getRows()
        );
        assertEquals(new BigDecimal("7.65"), invoice.getSalesTax());
        assertEquals(new BigDecimal("65.15"), invoice.getTotal());
    }

    @Test
    public void shouldReturn6_70asSalesTaxAnd74_68asTotal() {
        Invoice invoice = new Invoice();

        invoice.add(new Item("imported bottle of perfume", new BigDecimal("27.99"), GENERIC, true));
        invoice.add(new Item("bottle of perfume", new BigDecimal("18.99"), GENERIC, false));
        invoice.add(new Item("packet of headache pills", new BigDecimal("9.75"), MEDICAL, false));
        invoice.add(new Item("imported box of chocolates", new BigDecimal("11.25"), FOOD, true));

        assertEquals(
            asList(
                new InvoiceRow(1, "imported bottle of perfume", new BigDecimal("32.19")),
                new InvoiceRow(1, "bottle of perfume", new BigDecimal("20.89")),
                new InvoiceRow(1, "packet of headache pills", new BigDecimal("9.75")),
                new InvoiceRow(1, "imported box of chocolates", new BigDecimal("11.85"))
            ),
            invoice.getRows()
        );
        assertEquals(new BigDecimal("6.70"), invoice.getSalesTax());
        assertEquals(new BigDecimal("74.68"), invoice.getTotal());
    }

    @Test
    public void shouldReturn0TotalsForEmptyInvoice() {
        Invoice invoice = new Invoice();

        assertEquals(ZERO, invoice.getSalesTax());
        assertEquals(ZERO, invoice.getTotal());
    }

    @Test
    public void shouldReturn3asSalesTaxAnd33asTotal() {
        Invoice invoice = new Invoice();

        invoice.add(new Item("lamp", new BigDecimal("10"), GENERIC, false));
        invoice.add(new Item("lamp", new BigDecimal("10"), GENERIC, false));
        invoice.add(new Item("pencil", new BigDecimal("10"), GENERIC, false));

        assertEquals(
            asList(
                new InvoiceRow(2, "lamp", new BigDecimal("22.00")),
                new InvoiceRow(1, "pencil", new BigDecimal("11.00"))),
            invoice.getRows()
        );
        assertEquals(new BigDecimal("3.00"), invoice.getSalesTax());
        assertEquals(new BigDecimal("33.00"), invoice.getTotal());
    }

    @Test
    public void shouldConvertInvoiceRowToString() {
        assertEquals(
                "5 big lamp: 75.00",
                new InvoiceRow(5, "big lamp", new BigDecimal("75.00")).toString()
        );
    }

    @Test
    public void shouldConvertInvoiceToString() {
        Invoice invoice = new Invoice();

        invoice.add(new Item("lamp", new BigDecimal("10"), GENERIC, false));
        invoice.add(new Item("lamp", new BigDecimal("10"), GENERIC, false));
        invoice.add(new Item("pencil", new BigDecimal("10"), GENERIC, false));

        assertEquals(
                "2 lamp: 22.00\n"+
                "1 pencil: 11.00\n" +
                "Sales Taxes: 3.00\n" +
                "Total: 33.00",
                invoice.toString()
                );
    }
}
