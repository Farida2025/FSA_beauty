
package fsabeauty.strategy;

/**
 * Context class for the Strategy pattern that manages payment strategies.
 * This class serves as the central coordinator for payment processing,
 * allowing clients to switch between different payment methods at runtime.
 * It maintains a reference to the current payment strategy and delegates
 * payment operations to the selected strategy.
 */
public class PaymentContext {

    /**
     * The currently selected payment strategy instance.
     * This can be any concrete implementation of the PaymentStrategy interface.
     * The context delegates all payment operations to this strategy.
     */
    private PaymentStrategy paymentStrategy;

    /**
     * Default constructor for PaymentContext.
     * Initializes without a default payment strategy, requiring explicit strategy setting
     * before payment processing can occur.
     */
    public PaymentContext() {
    }

    /**
     * Sets or changes the current payment strategy at runtime.
     * This method enables dynamic switching between different payment methods
     * without modifying the client code that uses the PaymentContext.
     *
     * @param paymentStrategy the concrete payment strategy implementation to use
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("Payment strategy set to: " + paymentStrategy.getPaymentMethod());
    }

    /**
     * Executes a payment transaction using the currently set payment strategy.
     * This method coordinates the payment flow by displaying transaction details
     * and delegating the actual processing to the current strategy implementation.
     * Includes validation to ensure a payment strategy is selected before processing.
     *
     * @param amount the monetary amount to be processed in the payment transaction
     * @return boolean indicating the success (true) or failure (false) of the payment
     * @throws IllegalStateException if no payment strategy has been set prior to execution
     */
    public boolean executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy set");
            return false;
        }

        System.out.println("\n PROCESSING PAYMENT:");
        System.out.println("=====================");
        System.out.printf("Amount: $%.2f%n", amount);
        System.out.println("Method: " + paymentStrategy.getPaymentMethod());
        System.out.println("Details: " + paymentStrategy.getPaymentDetails());

        return paymentStrategy.processPayment(amount);
    }

    /**
     * Retrieves comprehensive information about the currently active payment strategy.
     * Provides a formatted string containing both the payment method name and specific details,
     * useful for display purposes and transaction logging.
     *
     * @return String containing formatted information about the current payment strategy,
     *         or a default message if no strategy is selected
     */
    public String getCurrentStrategyInfo() {
        if (paymentStrategy == null) {
            return "No payment strategy selected";
        }
        return paymentStrategy.getPaymentMethod() + " - " + paymentStrategy.getPaymentDetails();
    }

    /**
     * Provides direct access to the current payment strategy instance.
     * This getter method allows external components to inspect the currently
     * selected strategy without being able to modify it directly.
     *
     * @return the current PaymentStrategy instance, or null if no strategy is set
     */
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
}
