package com.chaicode.enums;

/**
 * Zippy Order Tracking — OrderStatus
 *
 * <p>Zippy's food-delivery app tracks every order through a fixed set of states. Using an
 * enum as a small state machine means an order can never end up in a made-up state
 * like "DELIVERD".
 *
 * <p>Constants (already declared, in this order):
 * <pre>
 * PLACED → CONFIRMED → PREPARING → OUT_FOR_DELIVERY → DELIVERED
 *                                                   (and CANCELLED)
 * </pre>
 *
 * <p>Rules:
 * <ol>
 *   <li>{@code isTerminal()}: true only for DELIVERED and CANCELLED.</li>
 *   <li>{@code next()}: the next state on the happy path shown above.
 *     A terminal state returns itself.</li>
 *   <li>{@code canTransitionTo(OrderStatus target)}: true only when
 *     <ul>
 *       <li>{@code target} is exactly {@code next()} of a non-terminal state, or</li>
 *       <li>{@code target} is CANCELLED and this state is PLACED, CONFIRMED or PREPARING
 *         (once the rider has left, the order cannot be cancelled).</li>
 *     </ul>
 *     Everything else is false: skipping ahead, going backwards, staying the same,
 *     leaving a terminal state, or a {@code null} target.</li>
 *   <li>{@code customerMessage()} is <b>abstract</b> — each constant already has its own body;
 *     fill each one in to return exactly:
 *     <pre>
 * PLACED           We have received your order
 * CONFIRMED        Restaurant has accepted your order
 * PREPARING        Your food is being prepared
 * OUT_FOR_DELIVERY Your rider is on the way
 * DELIVERED        Enjoy your meal!
 * CANCELLED        Your order was cancelled
 *     </pre></li>
 *   <li>{@code etaMinutes()}: use a classic {@code switch (this)} statement with
 *     {@code case ...:} labels. PLACED 40, CONFIRMED 35, PREPARING 25,
 *     OUT_FOR_DELIVERY 10, DELIVERED and CANCELLED 0.</li>
 *   <li>{@code trackingLine()}: {@code name() + ": " + customerMessage()}, and when
 *     {@code etaMinutes() > 0} append {@code " (ETA 25 min)"}. Examples:
 *     <pre>
 * PREPARING: Your food is being prepared (ETA 25 min)
 * DELIVERED: Enjoy your meal!
 *     </pre></li>
 * </ol>
 */
public enum OrderStatus {

    PLACED {
        @Override
        public String customerMessage() {
            // Your code here
            return "";
        }
    },
    CONFIRMED {
        @Override
        public String customerMessage() {
            // Your code here
            return "";
        }
    },
    PREPARING {
        @Override
        public String customerMessage() {
            // Your code here
            return "";
        }
    },
    OUT_FOR_DELIVERY {
        @Override
        public String customerMessage() {
            // Your code here
            return "";
        }
    },
    DELIVERED {
        @Override
        public String customerMessage() {
            // Your code here
            return "";
        }
    },
    CANCELLED {
        @Override
        public String customerMessage() {
            // Your code here
            return "";
        }
    };

    public abstract String customerMessage();

    public boolean isTerminal() {
        // Your code here
        return false;
    }

    public OrderStatus next() {
        // Your code here
        return null;
    }

    public boolean canTransitionTo(OrderStatus target) {
        // Your code here
        return false;
    }

    public int etaMinutes() {
        // Your code here
        return 0;
    }

    public String trackingLine() {
        // Your code here
        return "";
    }
}
