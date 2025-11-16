
package fsabeauty.strategy;

/**
 * Concrete implementation of PaymentStrategy for QR code-based payments.
 * Handles payment processing through QR code scanning and mobile payment applications.
 * This class simulates the QR payment flow including code scanning and confirmation waiting.
 */
public class QRPayment implements PaymentStrategy {

    /**
     * The unique QR code string that represents the payment transaction
     * Contains encrypted payment information that can be scanned by payment apps
     */
    private String qrCode;

    /**
     * The specific mobile payment application used for processing the QR payment
     * Examples: Kaspi Bank, Apple Pay, Google Pay, Alipay, etc.
     */
    private String paymentApp;

    /**
     * Constructs a new QRPayment instance with QR code and payment app details
     *
     * @param qrCode the unique QR code string for the payment transaction
     * @param paymentApp the mobile payment application used to process the payment
     */
    public QRPayment(String qrCode, String paymentApp) {
        this.qrCode = qrCode;
        this.paymentApp = paymentApp;
    }

    /**
     * Processes a QR code payment transaction
     * Simulates the complete QR payment workflow including code scanning,
     * app processing, and confirmation waiting period
     * Includes longer processing delay to simulate real-world QR payment confirmation time
     *
     * @param amount the monetary amount to be processed through QR payment
     * @return boolean indicating payment success (true) or failure (false)
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.printf(" Processing QR payment of $%.2f via %s%n", amount, paymentApp);
        System.out.println(" Scanning QR code: " + qrCode);

        try {
            System.out.println("Waiting for QR confirmation...");
            Thread.sleep(1500);
            System.out.println(" QR payment confirmed!");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * Returns the human-readable name of this QR payment method
     * Used throughout the system to identify this specific payment strategy type
     *
     * @return String constant "QR Payment" representing this payment method
     */
    @Override
    public String getPaymentMethod() {
        return "QR Payment";
    }

    /**
     * Provides detailed information about the QR payment configuration
     * Includes the payment application name and a partial QR code for reference
     * Useful for payment verification and transaction tracking while maintaining security
     *
     * @return String containing formatted QR payment details
     */
    @Override
    public String getPaymentDetails() {
        return String.format("QR Payment via %s (Code: %s...)", paymentApp, qrCode.substring(0, 10));
    }
}
