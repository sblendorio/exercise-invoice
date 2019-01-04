package eu.sblendorio.exercise;

import org.junit.Test;

import java.math.BigDecimal;

import static eu.sblendorio.exercise.Category.BOOK;
import static eu.sblendorio.exercise.Category.FOOD;
import static eu.sblendorio.exercise.Category.MEDICAL;
import static eu.sblendorio.exercise.Category.GENERIC;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void shouldReturn0ForNotImportedBookSalesTax() {
        Item item = new Item("Book of the city", new BigDecimal("12.49"), BOOK, false);
        assertEquals(new BigDecimal("0.00"), item.getSalesTax());
    }

    @Test
    public void shouldReturn1_50ForNotImportedCDSalesTax() {
        Item item = new Item("music CD", new BigDecimal("14.99"), GENERIC, false);
        assertEquals(new BigDecimal("1.50"), item.getSalesTax());
    }

    @Test
    public void shouldReturn0forNotImportedChocolateSalesTax() {
        Item item = new Item("Chocolate bar", new BigDecimal("0.85"), FOOD, false);
        assertEquals(new BigDecimal("0.00"), item.getSalesTax());
    }

    @Test
    public void shouldReturn5_05ForImportedBookSalesTax() {
        Item item = new Item("Book of the jungle", new BigDecimal("101"), BOOK, true);
        assertEquals(new BigDecimal("5.05"), item.getSalesTax());
    }

    @Test
    public void shouldReturn0_50forImportedChocolateSalesTax() {
        Item item = new Item("Imported box of chocolate", new BigDecimal("10"), FOOD, true);
        assertEquals(new BigDecimal("0.50"), item.getSalesTax());
    }

    @Test
    public void shouldReturn7_15forImportedPerfumeSalesTax() {
        Item item = new Item("Imported bottle of perfume", new BigDecimal("47.50"), GENERIC, true);
        assertEquals(new BigDecimal("7.15"), item.getSalesTax());
    }

    @Test
    public void shouldReturn4_20forImportedPerfumeSalesTax() {
        Item item = new Item("Imported bottle of perfume", new BigDecimal("27.99"), GENERIC, true);
        assertEquals(new BigDecimal("4.20"), item.getSalesTax());
    }

    @Test
    public void shoudlReturn1_90forNotImportedPerfumeSalesTax() {
        Item item = new Item("Bottle of perfume", new BigDecimal("18.99"), GENERIC, false);
        assertEquals(new BigDecimal("1.90"), item.getSalesTax());
    }

    @Test
    public void shouldReturn0forNotImportedPillsSalesTax() {
        Item item = new Item("Packet of headache pills", new BigDecimal("9.75"), MEDICAL, false);
        assertEquals(new BigDecimal("0.00"), item.getSalesTax());
    }

    @Test
    public void shouldReturn0_60forImportedChocolateSalesTax() {
        Item item = new Item("Box of imported chocolate bar", new BigDecimal("11.25"), FOOD, true);
        assertEquals(new BigDecimal("0.60"), item.getSalesTax());
    }

    @Test
    public void shouldReturn12_49ForNotImportedBookTotalPrice() {
        Item item = new Item("Book of the city", new BigDecimal("12.49"), BOOK, false);
        assertEquals(new BigDecimal("12.49"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn16_49ForNotImportedCDTotalPrice() {
        Item item = new Item("music CD", new BigDecimal("14.99"), GENERIC, false);
        assertEquals(new BigDecimal("16.49"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn0_85forNotImportedChocolateTotalPrice() {
        Item item = new Item("Chocolate bar", new BigDecimal("0.85"), FOOD, false);
        assertEquals(new BigDecimal("0.85"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn106_05ForImportedBookTotalPrice() {
        Item item = new Item("Book of the jungle", new BigDecimal("101"), BOOK, true);
        assertEquals(new BigDecimal("106.05"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn10_50forImportedChocolateTotalPrice() {
        Item item = new Item("Imported box of chocolate", new BigDecimal("10"), FOOD, true);
        assertEquals(new BigDecimal("10.50"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn54_65forImportedPerfumeTotalprice() {
        Item item = new Item("Imported bottle of perfume", new BigDecimal("47.50"), GENERIC, true);
        assertEquals(new BigDecimal("54.65"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn32_19forImportedPerfumeTotalprice() {
        Item item = new Item("Imported bottle of perfume", new BigDecimal("27.99"), GENERIC, true);
        assertEquals(new BigDecimal("32.19"), item.getFinalPrice());
    }

    @Test
    public void shoudlReturn20_89forNotImportedPerfumeTotalprice() {
        Item item = new Item("Bottle of perfume", new BigDecimal("18.99"), GENERIC, false);
        assertEquals(new BigDecimal("20.89"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn9_75forNotImportedPillsTotalPrice() {
        Item item = new Item("Packet of headache pills", new BigDecimal("9.75"), MEDICAL, false);
        assertEquals(new BigDecimal("9.75"), item.getFinalPrice());
    }

    @Test
    public void shouldReturn11_85forImportedChocolateTotalPrice() {
        Item item = new Item("Box of imported chocolate bar", new BigDecimal("11.25"), FOOD, true);
        assertEquals(new BigDecimal("11.85"), item.getFinalPrice());
    }

}
