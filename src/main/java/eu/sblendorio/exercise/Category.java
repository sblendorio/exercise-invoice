package eu.sblendorio.exercise;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.TEN;

public enum Category {
    BOOK {
        public BigDecimal getBasicSalesTaxRate() { return ZERO; }
    },

    FOOD {
        public BigDecimal getBasicSalesTaxRate() { return ZERO; }
    },

    MEDICAL {
        public BigDecimal getBasicSalesTaxRate() { return ZERO; }
    },

    GENERIC {
        public BigDecimal getBasicSalesTaxRate() { return TEN; }
    }
    ;

    public abstract BigDecimal getBasicSalesTaxRate();
    public BigDecimal getImportDutyRate() { return BigDecimal.valueOf(5); }

}
