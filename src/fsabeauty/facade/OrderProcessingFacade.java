package fsabeauty.facade;

import fsabeauty.strategy.*;
import fsabeauty.factory.*;
import fsabeauty.decorator.*;
import fsabeauty.observer.*;
import java.util.*;

/**
 * Facade class for order processing operations that provides a simplified interface
 * for shopping cart management, payment processing, and order fulfillment.
 * This class coordinates between Strategy pattern for payments and integrates
 * with other system components through facades.
 */
public class OrderProcessingFacade {
    private List<CosmeticProduct> shoppingCart;
    private PaymentContext paymentContext;

    public OrderProcessingFacade() {
        this.shoppingCart = new ArrayList<>();
        this.paymentContext = new PaymentContext();
    }

    public void addToCart(CosmeticProduct product) {
        shoppingCart.add(product);
        System.out.println(" Added to cart: " + product.getDescription());
    }

    public void displayCart() {
        System.out.println("\n SHOPPING CART:");
        System.out.println("================");
        if (shoppingCart.isEmpty()) {
            System.out.println("Cart is empty 🫙");
            return;
        }

        for (int i = 0; i < shoppingCart.size(); i++) {
            CosmeticProduct product = shoppingCart.get(i);
            System.out.printf("%d. %s - $%.2f%n",
                    i + 1, product.getDescription(), product.getPrice());
        }

        double total = calculateTotal();
        System.out.printf(" Subtotal: $%.2f%n", total);

        if (paymentContext.getPaymentStrategy() != null) {
            System.out.println(" Payment Method: " + paymentContext.getCurrentStrategyInfo());
        }
    }

    private double calculateTotal() {
        return shoppingCart.stream().mapToDouble(CosmeticProduct::getPrice).sum();
    }

    public void addToCartById(String productId, ProductManagementFacade productFacade) {
        Product product = productFacade.getProduct(productId);
        if (product != null && product.getStock() > 0) {
            CosmeticProduct cosmeticProduct = createCosmeticProductFromProduct(product);
            shoppingCart.add(cosmeticProduct);
            System.out.println(" Added to cart: " + product.getName());
        } else {
            System.out.println(" Product not available: " + productId);
        }
    }

    private CosmeticProduct createCosmeticProductFromProduct(Product product) {
        LipstickFactory lipstickFactory = new LipstickFactory();
        MascaraFactory mascaraFactory = new MascaraFactory();
        BlushFactory blushFactory = new BlushFactory();

        String name = product.getName().toLowerCase();
        if (name.contains("lipstick")) {
            if (name.contains("red")) return lipstickFactory.createProduct("red");
            if (name.contains("brown")) return lipstickFactory.createProduct("brown");
            if (name.contains("pink")) return lipstickFactory.createProduct("pink");
            return lipstickFactory.createProduct("red");
        } else if (name.contains("mascara")) {
            if (name.contains("waterproof")) return mascaraFactory.createProduct("waterproof");
            return mascaraFactory.createProduct("regular");
        } else if (name.contains("blush")) {
            if (name.contains("red")) return blushFactory.createProduct("red");
            if (name.contains("peach")) return blushFactory.createProduct("peach");
            if (name.contains("pink")) return blushFactory.createProduct("pink");
            return blushFactory.createProduct("pink");
        }
        return lipstickFactory.createProduct("red"); // fallback
    }

    public void setPaymentMethod(String paymentType, String... details) {
        PaymentStrategy strategy;

        switch (paymentType.toLowerCase()) {
            case "applepay":
                if (details.length < 2) {
                    System.out.println("Apple Pay requires token and device");
                    return;
                }
                strategy = new ApplePayPayment(details[0], details[1]);
                break;
            case "creditcard":
                if (details.length < 4) {
                    System.out.println(" Credit Card requires number, holder, expiry, and CVV");
                    return;
                }
                strategy = new CreditCardPayment(details[0], details[1], details[2], details[3]);
                break;
            case "qr":
                if (details.length < 2) {
                    System.out.println(" QR payment requires code and app name");
                    return;
                }
                strategy = new QRPayment(details[0], details[1]);
                break;
            default:
                System.out.println(" Unknown payment type. Available: applepay, creditcard, qr");
                return;
        }

        paymentContext.setPaymentStrategy(strategy);
        System.out.println(" Payment method set: " + strategy.getPaymentMethod());
    }

    public boolean processOrder() {
        if (shoppingCart.isEmpty()) {
            System.out.println(" Cart is empty!");
            return false;
        }

        if (paymentContext.getPaymentStrategy() == null) {
            System.out.println(" Payment method not set!");
            return false;
        }

        double total = calculateTotal();
        System.out.println("\n PROCESSING ORDER...");
        System.out.println("=====================");
        System.out.printf("Total Amount: $%.2f%n", total);
        System.out.println("Payment Method: " + paymentContext.getCurrentStrategyInfo());

        boolean success = paymentContext.executePayment(total);

        if (success) {
            System.out.println("\n ORDER PROCESSED SUCCESSFULLY!");
            System.out.println("Items purchased:");
            for (CosmeticProduct product : shoppingCart) {
                System.out.println("   • " + product.getDescription());
            }
            System.out.printf("Total: $%.2f%n", total);
            shoppingCart.clear();
            return true;
        } else {
            System.out.println(" ORDER PROCESSING FAILED!");
            return false;
        }
    }

    public void demonstratePaymentStrategies() {
        System.out.println("\n PAYMENT STRATEGIES DEMONSTRATION:");
        System.out.println("===================================");

        LipstickFactory lipstickFactory = new LipstickFactory();
        CosmeticProduct testProduct = lipstickFactory.createProduct("red");
        shoppingCart.add(testProduct);

        double testAmount = 24.99;

        System.out.println("\n--- Apple Pay ---");
        setPaymentMethod("applepay", "ap1_token123", "iPhone 15");
        paymentContext.executePayment(testAmount);

        System.out.println("\n--- Credit Card ---");
        setPaymentMethod("creditcard", "4111111111111111", "John Doe", "12/25", "123");
        paymentContext.executePayment(testAmount);

        System.out.println("\n--- QR Payment ---");
        setPaymentMethod("qr", "QR1234567890", "Kaspi Bank");
        paymentContext.executePayment(testAmount);

        shoppingCart.clear();
        paymentContext.setPaymentStrategy(null);
    }

    public void demonstrateDecoratorServices() {
        System.out.println("\n DECORATOR SERVICES DEMONSTRATION:");
        System.out.println("===================================");

        LipstickFactory lipstickFactory = new LipstickFactory();
        CosmeticProduct baseProduct = lipstickFactory.createProduct("red");

        CosmeticService service = new BasicCosmeticProduct(baseProduct);
        System.out.println("1. Base Product:");
        System.out.println(service.getServiceDetails());
        System.out.printf("Cost: $%.2f%n", service.getCost());

        service = new GiftWrapDecorator(service, "Premium");
        System.out.println("\n2. With Premium Gift Wrap:");
        System.out.println(service.getServiceDetails());
        System.out.printf("Cost: $%.2f%n", service.getCost());

        service = new ExpressDeliveryDecorator(service, 1);
        System.out.println("\n3. With Express Delivery:");
        System.out.println(service.getServiceDetails());
        System.out.printf("Cost: $%.2f%n", service.getCost());

        service = new PersonalizationDecorator(service, "Happy Birthday!", "Elegant");
        System.out.println("\n4. With Personalization:");
        System.out.println(service.getServiceDetails());
        System.out.printf("Cost: $%.2f%n", service.getCost());

        service = new SampleKitDecorator(service, "Luxury Sampler");
        service = new BeautyConsultationDecorator(service, 30);
        System.out.println("\n5. Full Premium Package:");
        System.out.println(service.getServiceDetails());
        System.out.printf("Final Cost: $%.2f%n", service.getCost());
    }

    public int getCartSize() {
        return shoppingCart.size();
    }

    public double getCartTotal() {
        return calculateTotal();
    }

    public boolean isCartEmpty() {
        return shoppingCart.isEmpty();
    }

    public String getPaymentInfo() {
        if (paymentContext.getPaymentStrategy() == null) {
            return "No payment method selected";
        }
        return paymentContext.getCurrentStrategyInfo();
    }
}