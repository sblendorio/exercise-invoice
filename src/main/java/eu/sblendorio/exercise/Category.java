package eu.sblendorio.exercise;

import java.math.BigDecimal;

public enum Category {
    BOOK {
        public BigDecimal getBasicSalesTaxRate() { return BigDecimal.valueOf(0); }
    },

    FOOD {
        public BigDecimal getBasicSalesTaxRate() { return BigDecimal.valueOf(0); }
    },

    MEDICAL {
        public BigDecimal getBasicSalesTaxRate() { return BigDecimal.valueOf(0); }
    },

    GENERIC {
        public BigDecimal getBasicSalesTaxRate() { return BigDecimal.valueOf(10); }
    }
    ;

    public abstract BigDecimal getBasicSalesTaxRate();
    public BigDecimal getImportDutyRate() { return BigDecimal.valueOf(5); }

}
