package com.chaicode.records;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Records - ChaiPay Money")
class MoneyTest {

    @Nested
    @DisplayName("Compact constructor")
    class CompactConstructor {

        @Test
        void currencyIsNormalisedToUppercase() {
            Money money = new Money(1250, "inr");
            assertEquals(1250, money.paise());
            assertEquals("INR", money.currency());
            assertEquals("USD", new Money(99, "Usd").currency());
        }

        @Test
        void rejectsNegativePaise() {
            assertThrows(IllegalArgumentException.class, () -> new Money(-1, "INR"));
        }

        @Test
        void rejectsBadCurrencyCodes() {
            assertThrows(IllegalArgumentException.class, () -> new Money(100, null));
            assertThrows(IllegalArgumentException.class, () -> new Money(100, "RS"));
            assertThrows(IllegalArgumentException.class, () -> new Money(100, "RUPEE"));
            assertThrows(IllegalArgumentException.class, () -> new Money(100, "U5D"));
        }
    }

    @Nested
    @DisplayName("Factory & custom methods")
    class CustomMethods {

        @Test
        void ofRupeesConvertsToPaise() {
            assertEquals(new Money(1250, "INR"), Money.ofRupees(12.5));
            assertEquals(1999, Money.ofRupees(19.99).paise());
            assertEquals(30, Money.ofRupees(0.1 + 0.2).paise());
        }

        @Test
        void plusReturnsNewMoney() {
            Money chai = new Money(2000, "INR");
            Money samosa = new Money(1550, "inr");
            Money total = chai.plus(samosa);
            assertEquals(new Money(3550, "INR"), total);
            assertNotSame(chai, total);
            assertEquals(2000, chai.paise());
        }

        @Test
        void plusRejectsMismatchAndNull() {
            Money rupees = new Money(100, "INR");
            assertThrows(IllegalArgumentException.class, () -> rupees.plus(new Money(100, "USD")));
            assertThrows(IllegalArgumentException.class, () -> rupees.plus(null));
        }

        @Test
        void formatUsesSymbolForInrAndCodeOtherwise() {
            assertEquals("₹12.50", new Money(1250, "INR").format());
            assertEquals("₹0.05", new Money(5, "inr").format());
            assertEquals("₹1234.56", new Money(123456, "INR").format());
            assertEquals("USD 12.05", new Money(1205, "usd").format());
        }
    }

    @Test
    void generatedEqualsHashCodeAndToString() {
        Money a = new Money(1250, "inr");
        Money b = new Money(1250, "INR");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertEquals("Money[paise=1250, currency=INR]", a.toString());
    }
}
