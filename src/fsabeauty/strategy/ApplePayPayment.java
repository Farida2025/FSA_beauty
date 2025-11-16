
package fsabeauty.strategy;

/**
 * Concrete implementation of PaymentStrategy for Apple Pay payments.
 * Handles the specific logic required for processing payments through Apple Pay.
 * This class encapsulates all Apple Pay related operations including token management
 * and device-specific payment processing.
 */
public class ApplePayPayment implements PaymentStrategy {

    /**
     * Secure token provided by Apple Pay system for payment authorization
     * This token represents the encrypted payment credentials
     */
    private String applePayToken;

    /**
     * The specific Apple device used for making the payment
     * Examples: iPhone, iPad, Apple Watch, etc.
     */
    private String device;

    /**
     * Constructs a new ApplePayPayment instance with required payment credentials
     *
     * @param applePayToken the secure payment token from Apple Pay system
     * @param device the Apple device used for the payment transaction
     */
    public ApplePayPayment(String applePayToken, String device) {
        this.applePayToken = applePayToken;
        this.device = device;
    }

    /**
     * Processes an Apple Pay payment transaction
     * Simulates the entire payment flow including token validation and transaction processing
     * Includes artificial delay to simulate real-world payment processing time
     *
     * @param amount the monetary amount to be processed in the payment
     * @return boolean indicating payment success (true) or failure (false)
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing Apple Pay payment of $%.2f from %s%n", amount, device);
        System.out.println("Using secure token: " + applePayToken.substring(0, 8) + "...");

        try {
            Thread.sleep(800);
            System.out.println("Apple Pay payment successful!");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * Returns the human-readable name of this payment method
     * Used for displaying payment option to users and in transaction logs
     *
     * @return String representing the payment method name
     */
    @Override
    public String getPaymentMethod() {
        return "Apple Pay";
    }

    /**
     * Provides detailed information about the current payment configuration
     * Includes device information and partial token for security purposes
     * Useful for payment verification and transaction tracking
     *
     * @return String containing formatted payment details
     */
    @Override
    public String getPaymentDetails() {
        return String.format("Apple Pay on %s (Token: %s...)", device, applePayToken.substring(0, 8));
    }
}
