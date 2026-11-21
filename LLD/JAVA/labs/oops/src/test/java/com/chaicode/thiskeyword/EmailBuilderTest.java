package com.chaicode.thiskeyword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("this Keyword - ChaiMail")
class EmailBuilderTest {

    @Nested
    @DisplayName("Methods return this")
    class ReturnThis {

        @Test
        void toReturnsSameInstance() {
            EmailBuilder builder = new EmailBuilder();
            assertSame(builder, builder.to("riya@chaicode.com"));
        }

        @Test
        void everySetterReturnsSameInstance() {
            EmailBuilder builder = new EmailBuilder();
            assertSame(builder, builder.cc("aman@chaicode.com"));
            assertSame(builder, builder.subject("Hi"));
            assertSame(builder, builder.body("Hello"));
        }

        @Test
        void chainStaysOnOneObject() {
            EmailBuilder builder = new EmailBuilder();
            EmailBuilder end = builder.to("riya@chaicode.com").subject("Hi").cc("aman@chaicode.com").body("Yo");
            assertSame(builder, end);
        }
    }

    @Nested
    @DisplayName("build()")
    class Build {

        @Test
        void fullEmailWithCc() {
            String mail = new EmailBuilder()
                    .to("riya@chaicode.com")
                    .cc("aman@chaicode.com")
                    .subject("Cohort starts Monday")
                    .cc("neha@chaicode.com")
                    .body("See you at 9 PM!")
                    .build();
            assertEquals("To: riya@chaicode.com\n"
                    + "Cc: aman@chaicode.com, neha@chaicode.com\n"
                    + "Subject: Cohort starts Monday\n"
                    + "\n"
                    + "See you at 9 PM!", mail);
        }

        @Test
        void noCcOmitsCcLine() {
            String mail = new EmailBuilder().to("riya@chaicode.com").subject("Chai?").body("4 PM tapri").build();
            assertEquals("To: riya@chaicode.com\nSubject: Chai?\n\n4 PM tapri", mail);
        }

        @Test
        void defaultsForMissingSubjectAndBody() {
            assertEquals("To: riya@chaicode.com\nSubject: (no subject)\n\n",
                    new EmailBuilder().to("riya@chaicode.com").build());
            assertEquals("To: riya@chaicode.com\nSubject: (no subject)\n\nHi",
                    new EmailBuilder().to("riya@chaicode.com").subject("   ").body("Hi").build());
        }

        @Test
        void lastToWins() {
            String mail = new EmailBuilder().to("old@chaicode.com").to("new@chaicode.com").subject("S").body("B").build();
            assertEquals("To: new@chaicode.com\nSubject: S\n\nB", mail);
        }

        @Test
        void buildWithoutRecipientThrows() {
            assertThrows(IllegalStateException.class, () -> new EmailBuilder().subject("Hi").body("Yo").build());
        }
    }

    @Test
    void invalidAddressesThrow() {
        EmailBuilder builder = new EmailBuilder();
        assertThrows(IllegalArgumentException.class, () -> builder.to("riya.chaicode.com"));
        assertThrows(IllegalArgumentException.class, () -> builder.to(null));
        assertThrows(IllegalArgumentException.class, () -> builder.cc("aman"));
        assertThrows(IllegalArgumentException.class, () -> builder.cc(null));
    }
}
