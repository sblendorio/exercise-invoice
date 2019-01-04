package eu.sblendorio.exercise;

import java.math.BigDecimal;

import static eu.sblendorio.exercise.Category.*;

public class Demo {

    public static void main(String[] args) {
        Invoice invoice1 = new Invoice();
        invoice1.add(new Item("book", new BigDecimal("12.49"), BOOK, false));
        invoice1.add(new Item("music CD", new BigDecimal("14.99"), GENERIC, false));
        invoice1.add(new Item("chocolate bar", new BigDecimal("0.85"), FOOD, false));
        System.out.println(invoice1 + "\n");

        Invoice invoice2 = new Invoice();
        invoice2.add(new Item("imported box of chocolate", new BigDecimal("10.00"), FOOD, true));
        invoice2.add(new Item("imported bottle of perfume", new BigDecimal("47.50"), GENERIC, true));
        System.out.println(invoice2 + "\n");

        Invoice invoice3 = new Invoice();
        invoice3.add(new Item("imported bottle of perfume", new BigDecimal("27.99"), GENERIC, true));
        invoice3.add(new Item("bottle of perfume", new BigDecimal("18.99"), GENERIC, false));
        invoice3.add(new Item("packet of headache pills", new BigDecimal("9.75"), MEDICAL, false));
        invoice3.add(new Item("imported box of chocolates", new BigDecimal("11.25"), FOOD, true));
        System.out.println(invoice3 + "\n");
    }
}
