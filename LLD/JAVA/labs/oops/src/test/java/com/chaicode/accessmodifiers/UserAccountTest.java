package com.chaicode.accessmodifiers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Access Modifiers - ChaiCode Login")
class UserAccountTest {

    private static UserAccount riya() {
        return new UserAccount("riya", "riya@chaicode.com", "chai1234");
    }

    @Nested
    @DisplayName("Modifiers (reflection)")
    class Modifiers {

        @Test
        void allInstanceFieldsArePrivate() throws Exception {
            for (String name : new String[] {"username", "email", "password", "failedAttempts"}) {
                Field field = UserAccount.class.getDeclaredField(name);
                assertTrue(Modifier.isPrivate(field.getModifiers()), name + " must be private");
            }
            for (Field field : UserAccount.class.getDeclaredFields()) {
                if (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) continue;
                assertTrue(Modifier.isPrivate(field.getModifiers()), field.getName() + " must be private");
            }
        }

        @Test
        void passwordIsPrivateWithNoGetter() throws Exception {
            assertTrue(Modifier.isPrivate(UserAccount.class.getDeclaredField("password").getModifiers()));
            for (Method method : UserAccount.class.getDeclaredMethods()) {
                assertNotEquals("getPassword", method.getName(), "password must not have a getter");
            }
        }

        @Test
        void helperIsPrivateAndApiIsPublic() throws Exception {
            Method helper = UserAccount.class.getDeclaredMethod("isStrong", String.class);
            assertTrue(Modifier.isPrivate(helper.getModifiers()), "isStrong must be private");
            assertTrue(Modifier.isPublic(UserAccount.class.getMethod("getUsername").getModifiers()));
            assertTrue(Modifier.isPublic(UserAccount.class.getMethod("checkPassword", String.class).getModifiers()));
        }
    }

    @Nested
    @DisplayName("Constructor and getters")
    class ConstructorAndGetters {

        @Test
        void gettersExposeSafeState() {
            UserAccount account = new UserAccount("  riya ", "riya@chaicode.com", "chai1234");
            assertEquals("riya", account.getUsername());
            assertEquals("riya@chaicode.com", account.getEmail());
            assertEquals(0, account.getFailedAttempts());
            assertFalse(account.isLocked());
        }

        @Test
        void rejectsInvalidInput() {
            assertThrows(IllegalArgumentException.class, () -> new UserAccount(" ", "riya@chaicode.com", "chai1234"));
            assertThrows(IllegalArgumentException.class, () -> new UserAccount("riya", "riya.chaicode.com", "chai1234"));
            assertThrows(IllegalArgumentException.class, () -> new UserAccount("riya", "riya@chaicode.com", "chai12"));
            assertThrows(IllegalArgumentException.class, () -> new UserAccount("riya", "riya@chaicode.com", "chaichai"));
            assertThrows(IllegalArgumentException.class, () -> new UserAccount("riya", "riya@chaicode.com", null));
        }
    }

    @Nested
    @DisplayName("checkPassword() and changePassword()")
    class Passwords {

        @Test
        void wrongAttemptsCountAndCorrectOneResets() {
            UserAccount account = riya();
            assertFalse(account.checkPassword("wrong"));
            assertFalse(account.checkPassword(null));
            assertEquals(2, account.getFailedAttempts());
            assertTrue(account.checkPassword("chai1234"));
            assertEquals(0, account.getFailedAttempts());
        }

        @Test
        void locksAfterThreeFailures() {
            UserAccount account = riya();
            account.checkPassword("a");
            account.checkPassword("b");
            account.checkPassword("c");
            assertTrue(account.isLocked());
            assertFalse(account.checkPassword("chai1234"));
            assertEquals(3, account.getFailedAttempts());
        }

        @Test
        void changePasswordNeedsOldPasswordAndStrongNewOne() {
            UserAccount account = riya();
            assertFalse(account.changePassword("wrong", "masala99chai"));
            assertEquals(1, account.getFailedAttempts());
            assertFalse(account.changePassword("chai1234", "weak"));
            assertTrue(account.checkPassword("chai1234"));
            assertTrue(account.changePassword("chai1234", "masala99chai"));
            assertFalse(account.checkPassword("chai1234"));
            assertTrue(account.checkPassword("masala99chai"));
        }
    }
}
