package fsabeauty.strategy;

/**
 * Interface defining the contract for all payment strategy implementations.
 * This interface follows the Strategy pattern by declaring the common operations
 * that all payment methods must support, allowing interchangeable payment algorithms.
 * Concrete implementations will provide specific logic for different payment providers.
 */
public interface PaymentStrategy {

    /**
     * Processes a payment transaction for the specified amount.
     * Each concrete strategy implements this method with provider-specific logic
     * including authentication, authorization, and transaction completion.
     *
     * @param amount the monetary value to be processed in the payment transaction
     * @return boolean indicating whether the payment was successfully completed (true)
     *         or failed (false)
     */
    boolean processPayment(double amount);

    /**
     * Returns the human-readable name of the payment method.
     * This identifier is used for displaying the payment option to users
     * and in system logs and reports.
     *
     * @return String representing the name of this payment method
     *         (e.g., "Credit Card", "Apple Pay", "QR Payment")
     */
    String getPaymentMethod();

    /**
     * Provides detailed information about the payment configuration.
     * This method returns payment-specific details formatted for display
     * and verification purposes, typically including masked sensitive data.
     *
     * @return String containing formatted payment details appropriate for user display
     *         and system records
     */
    String getPaymentDetails();
}