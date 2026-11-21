package com.chaicode.encapsulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Encapsulation - ChaiPay Wallet")
class DigitalWalletTest {

    @Nested
    @DisplayName("Data hiding")
    class DataHiding {

        @Test
        void fieldsArePrivate() throws NoSuchFieldException {
            for (String name : new String[]{"ownerName", "balance", "transactionCount"}) {
                int mods = DigitalWallet.class.getDeclaredField(name).getModifiers();
                assertTrue(Modifier.isPrivate(mods), name + " must be private");
            }
        }

        @Test
        void noSetterForBalanceOrCount() {
            boolean hasSetter = Arrays.stream(DigitalWallet.class.getDeclaredMethods())
                    .map(Method::getName)
                    .anyMatch(n -> n.equals("setBalance") || n.equals("setTransactionCount"));
            assertFalse(hasSetter, "balance must only change via deposit/withdraw");
        }
    }

    @Test
    void newWalletIsEmpty() {
        DigitalWallet wallet = new DigitalWallet("Riya");
        assertEquals("Riya", wallet.getOwnerName());
        assertEquals(0.0, wallet.getBalance(), 0.001);
        assertEquals(0, wallet.getTransactionCount());
    }

    @Nested
    @DisplayName("deposit()")
    class Deposit {

        @Test
        void addsMoney() {
            DigitalWallet wallet = new DigitalWallet("Riya");
            wallet.deposit(500);
            wallet.deposit(10000);
            assertEquals(10500.0, wallet.getBalance(), 0.001);
        }

        @Test
        void rejectsInvalidAmounts() {
            DigitalWallet wallet = new DigitalWallet("Riya");
            wallet.deposit(200);
            assertThrows(IllegalArgumentException.class, () -> wallet.deposit(0));
            assertThrows(IllegalArgumentException.class, () -> wallet.deposit(-50));
            assertThrows(IllegalArgumentException.class, () -> wallet.deposit(10000.01));
            assertEquals(200.0, wallet.getBalance(), 0.001);
            assertEquals(1, wallet.getTransactionCount());
        }
    }

    @Nested
    @DisplayName("withdraw()")
    class Withdraw {

        @Test
        void succeedsWithEnoughBalance() {
            DigitalWallet wallet = new DigitalWallet("Riya");
            wallet.deposit(1000);
            assertTrue(wallet.withdraw(350));
            assertEquals(650.0, wallet.getBalance(), 0.001);
            assertTrue(wallet.withdraw(650));
            assertEquals(0.0, wallet.getBalance(), 0.001);
        }

        @Test
        void insufficientBalanceReturnsFalse() {
            DigitalWallet wallet = new DigitalWallet("Riya");
            wallet.deposit(100);
            assertFalse(wallet.withdraw(100.5));
            assertEquals(100.0, wallet.getBalance(), 0.001);
            assertEquals(1, wallet.getTransactionCount());
        }

        @Test
        void rejectsNonPositiveAmount() {
            DigitalWallet wallet = new DigitalWallet("Riya");
            wallet.deposit(100);
            assertThrows(IllegalArgumentException.class, () -> wallet.withdraw(0));
            assertThrows(IllegalArgumentException.class, () -> wallet.withdraw(-10));
            assertEquals(100.0, wallet.getBalance(), 0.001);
        }
    }

    @Test
    void countsOnlySuccessfulTransactions() {
        DigitalWallet wallet = new DigitalWallet("Riya");
        wallet.deposit(300);
        wallet.withdraw(100);
        wallet.withdraw(5000);
        wallet.deposit(50);
        assertEquals(3, wallet.getTransactionCount());
        assertEquals(250.0, wallet.getBalance(), 0.001);
    }
}
