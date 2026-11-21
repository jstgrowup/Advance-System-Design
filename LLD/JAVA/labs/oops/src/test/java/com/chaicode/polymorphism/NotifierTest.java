package com.chaicode.polymorphism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Polymorphism - PingMe Notifications")
class NotifierTest {

    @Nested
    @DisplayName("Compile-time polymorphism (overloaded send)")
    class Overloading {

        @Test
        void sendMessageOnly() {
            Notifier app = new Notifier();
            assertEquals("APP", app.channel());
            assertEquals("[APP] Hello", app.send("Hello"));
        }

        @Test
        void sendWithPriority() {
            Notifier app = new Notifier();
            assertEquals("[APP] Server down [P5]", app.send("Server down", 5));
            assertEquals("[APP] Lunch is here [P1]", app.send("Lunch is here", 1));
            assertThrows(IllegalArgumentException.class, () -> app.send("Hi", 0));
            assertThrows(IllegalArgumentException.class, () -> app.send("Hi", 6));
        }

        @Test
        void sendToRecipients() {
            Notifier app = new Notifier();
            assertEquals(List.of("ravi <- [APP] Hi", "asha <- [APP] Hi"),
                    app.send("Hi", List.of("ravi", "asha")));
            assertEquals(List.of(), app.send("Hi", List.of()));
        }

        @Test
        void rejectsBlankMessages() {
            Notifier app = new Notifier();
            assertThrows(IllegalArgumentException.class, () -> app.send(null));
            assertThrows(IllegalArgumentException.class, () -> app.send("   "));
            assertThrows(IllegalArgumentException.class, () -> app.send("", 3));
            assertThrows(IllegalArgumentException.class, () -> app.send(" ", List.of()));
        }
    }

    @Nested
    @DisplayName("Runtime polymorphism (overridden format)")
    class Overriding {

        @Test
        void smsTruncatesLongMessages() {
            Notifier sms = new SmsNotifier();
            assertEquals("SMS", sms.channel());
            assertEquals("[SMS] Hi there", sms.send("Hi there"));
            assertEquals("[SMS] Your OTP is 48291...", sms.send("Your OTP is 482913 valid 5 min"));
            assertEquals("[SMS] 12345678901234567890", sms.send("12345678901234567890"));
        }

        @Test
        void emailIncludesSender() {
            Notifier email = new EmailNotifier("noreply@pingme.in");
            assertEquals("EMAIL", email.channel());
            assertEquals("[EMAIL] From: noreply@pingme.in | Welcome", email.send("Welcome"));
        }

        @Test
        void overloadsDispatchToChildFormat() {
            List<Notifier> channels = List.of(
                    new Notifier(), new SmsNotifier(), new EmailNotifier("ops@pingme.in"));
            List<String> out = new ArrayList<>();
            for (Notifier n : channels) {
                out.add(n.send("Order shipped", 2));
            }
            assertEquals(List.of(
                    "[APP] Order shipped [P2]",
                    "[SMS] Order shipped [P2]",
                    "[EMAIL] From: ops@pingme.in | Order shipped [P2]"), out);
            assertEquals(List.of("neha <- [SMS] Order shipped"),
                    new SmsNotifier().send("Order shipped", List.of("neha")));
        }
    }
}
