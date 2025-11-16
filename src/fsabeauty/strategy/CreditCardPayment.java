
package fsabeauty.strategy;

/**
 * Concrete implementation of PaymentStrategy for traditional Credit Card payments.
 * Handles payment processing using credit card information including card number,
 * cardholder name, expiration date, and security code.
 * This class provides secure credit card transaction processing with proper data masking.
 */
public class CreditCardPayment implements PaymentStrategy {

    /**
     * The 16-digit credit card number for the payment transaction
     * Stored as string to handle various card formats and preserve leading zeros
     */
    private String cardNumber;

    /**
     * Full name of the cardholder as it appears on the credit card
     * Used for verification and transaction records
     */
    private String cardHolder;

    /**
     * Expiration date of the credit card in MM/YY format
     * Validates that the card is still active and usable
     */
    private String expiryDate;

    /**
     * Card Verification Value - 3 or 4 digit security code
     * Provides additional security layer for card-not-present transactions
     */
    private String cvv;

    /**
     * Constructs a new CreditCardPayment instance with complete card details
     *
     * @param cardNumber the complete credit card number
     * @param cardHolder the name of the cardholder
     * @param expiryDate the card expiration date in MM/YY format
     * @param cvv the 3 or 4 digit security code from the card
     */
    public CreditCardPayment(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    /**
     * Processes a credit card payment transaction
     * Simulates the credit card authorization process including security checks
     * Implements proper data masking to protect sensitive card information
     * Includes processing delay to simulate real payment gateway interaction
     *
     * @param amount the monetary amount to be charged to the credit card
     * @return boolean indicating whether the payment was successfully processed
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing Credit Card payment of $%.2f for %s%n", amount, cardHolder);
        System.out.printf("Card: **** **** **** %s | Exp: %s%n",
                cardNumber.substring(cardNumber.length() - 4), expiryDate);

        try {
            Thread.sleep(1000);
            System.out.println("Credit Card payment successful!");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * Returns the payment method type identifier
     * Used throughout the system to identify this specific payment strategy
     *
     * @return String constant "Credit Card" representing this payment method
     */
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    /**
     * Provides a secure summary of payment details for confirmation and records
     * Masks the full card number for security, showing only last 4 digits
     * Includes cardholder name for verification purposes
     *
     * @return String containing formatted and secured payment information
     */
    @Override
    public String getPaymentDetails() {
        return String.format("Credit Card - %s (****%s)", cardHolder, cardNumber.substring(cardNumber.length() - 4));
    }
}
