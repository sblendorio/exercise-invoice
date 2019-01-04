package eu.sblendorio.exercise;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private static final BigDecimal FIVE = valueOf(5);

    @Test
    public void shouldReturn0forBookCategoryBasicSalesTaxRate() {
        assertEquals(ZERO, Category.BOOK.getBasicSalesTaxRate());
    }

    @Test
    public void shouldReturn0forFoodCategoryBasicSalesTaxRate() {
        assertEquals(ZERO, Category.FOOD.getBasicSalesTaxRate());
    }

    @Test
    public void shouldReturn0forMedicalCategoryBasicSalesTaxRate() {
        assertEquals(ZERO, Category.MEDICAL.getBasicSalesTaxRate());
    }

    @Test
    public void shouldReturn10forGenericCategoryBasicSalesTaxRate() {
        assertEquals(TEN, Category.GENERIC.getBasicSalesTaxRate());
    }
    @Test

    public void shouldReturn5forBookCategoryImportDutysTaxRate() {
        assertEquals(FIVE, Category.BOOK.getImportDutyRate());
    }

    @Test
    public void shouldReturn5forFoodCategoryImportDutysTaxRate() {
        assertEquals(FIVE, Category.FOOD.getImportDutyRate());
    }

    @Test
    public void shouldReturn5forMedicalCategoryImportDutysTaxRate() {
        assertEquals(FIVE, Category.MEDICAL.getImportDutyRate());
    }

    @Test
    public void shouldReturn5forGenericCategoryImportDutysTaxRate() {
        assertEquals(FIVE, Category.GENERIC.getImportDutyRate());
    }
}
