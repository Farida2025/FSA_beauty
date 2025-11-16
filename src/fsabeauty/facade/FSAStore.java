
package fsabeauty.facade;

import fsabeauty.factory.*;
import fsabeauty.strategy.*;
import fsabeauty.builder.*;
import fsabeauty.decorator.*;
import fsabeauty.observer.*;
import java.util.*;

/**
 * Main facade class for FSA Beauty store that provides a simplified interface to the complex system.
 * This class coordinates all design patterns and provides both simple client methods 
 * and comprehensive demonstration capabilities for the entire beauty store ecosystem.
 */
public class FSAStore {
    private ProductManagementFacade productFacade;
    private OrderProcessingFacade orderFacade;
    private BeautySetFacade beautySetFacade;

    public FSAStore() {
        this.productFacade = new ProductManagementFacade();
        this.orderFacade = new OrderProcessingFacade();
        this.beautySetFacade = new BeautySetFacade();
    }

    // === SIMPLE CLIENT METHODS ===

    /**
     * Displays all available products in the store catalog
     */
    public void browseProducts() {
        productFacade.displayCatalog();
    }

    /**
     * Adds a product to the shopping cart using its unique identifier
     *
     * @param productId the unique ID of the product to add to cart
     */
    public void addToCart(String productId) {
        orderFacade.addToCartById(productId, productFacade);
    }

    /**
     * Displays the current contents of the shopping cart with prices and total
     */
    public void showCart() {
        orderFacade.displayCart();
    }

    /**
     * Sets the payment method for the current order transaction
     *
     * @param paymentType the type of payment method to use
     * @param details variable arguments containing payment-specific information
     */
    public void setPaymentMethod(String paymentType, String... details) {
        orderFacade.setPaymentMethod(paymentType, details);
    }

    /**
     * Processes the final checkout and payment for items in the cart
     */
    public void checkout() {
        boolean success = orderFacade.processOrder();
        if (success) {
            System.out.println("\n Thank you for shopping at FSA_Beauty!");
        }
    }

    // === COMPLETE PATTERN DEMONSTRATION IN ONE PLACE ===

    /**
     * Demonstrates all six design patterns implemented in the FSA Beauty system
     * Provides a comprehensive showcase of how each pattern works individually
     */
    public void demonstrateAllPatterns() {
        System.out.println("\n FSA_BEAUTY - ALL 6 DESIGN PATTERNS DEMONSTRATION");
        System.out.println("===================================================");

        demonstrateFactoryPattern();
        demonstrateObserverPattern();
        demonstrateBuilderPattern();
        demonstrateStrategyPattern();
        demonstrateDecoratorPattern();
        demonstrateFacadePattern();

        System.out.println("\n ALL 6 DESIGN PATTERNS SUCCESSFULLY DEMONSTRATED!");
    }

    /**
     * Demonstrates Factory Method pattern for creating cosmetic products
     * Shows how different product types are created through specialized factories
     */
    private void demonstrateFactoryPattern() {
        System.out.println("\n1.  FACTORY METHOD PATTERN");
        System.out.println("   ========================");
        System.out.println("   Purpose: Create different cosmetic products without exposing instantiation logic");

        LipstickFactory lipstickFactory = new LipstickFactory();
        MascaraFactory mascaraFactory = new MascaraFactory();
        BlushFactory blushFactory = new BlushFactory();

        System.out.println("\n   Creating products through factories:");
        CosmeticProduct lipstick = lipstickFactory.createProduct("red");
        CosmeticProduct mascara = mascaraFactory.createProduct("waterproof");
        CosmeticProduct blush = blushFactory.createProduct("peach");

        lipstickFactory.displayProductInfo(lipstick);
        mascaraFactory.displayProductInfo(mascara);
        blushFactory.displayProductInfo(blush);

        System.out.println("    Factory Method: Different factories create different product types");
    }

    /**
     * Demonstrates Observer pattern for product change notifications
     * Shows how customers automatically receive updates about product changes
     */
    private void demonstrateObserverPattern() {
        System.out.println("\n2.  OBSERVER PATTERN");
        System.out.println("   ==================");
        System.out.println("   Purpose: Notify customers about product changes automatically");

        Product lipstick = new Product("LIP_DEMO", "Demo Lipstick", "FSA_Beauty", 24.99, 5);
        Product mascara = new Product("MASC_DEMO", "Demo Mascara", "FSA_Beauty", 19.99, 10);

        Customer alice = new Customer("OBS001", "Alice", "alice@email.com");
        Customer bob = new Customer("OBS002", "Bob", "bob@email.com");

        System.out.println("\n   Registering customers to products:");
        lipstick.registerObserver(alice);
        lipstick.registerObserver(bob);
        mascara.registerObserver(alice);

        System.out.println("\n   Simulating product changes:");
        lipstick.setStock(2);
        lipstick.setPrice(19.99);
        mascara.setStock(0);

        System.out.println("    Observer: Customers automatically notified about changes");
    }

    /**
     * Demonstrates Builder pattern for constructing complex beauty sets
     * Shows step-by-step construction of different types of beauty sets
     */
    private void demonstrateBuilderPattern() {
        System.out.println("\n3. BUILDER PATTERN");
        System.out.println("   =================");
        System.out.println("   Purpose: Construct complex beauty sets step by step");

        BeautySetDirector director = new BeautySetDirector();

        System.out.println("\n   Building Beginner Set:");
        BeautySetBuilder beginnerBuilder = new BeginnerMakeupSetBuilder();
        director.setBuilder(beginnerBuilder);
        BeautySet beginnerSet = director.constructBeautySet();
        System.out.println(beginnerSet.getSetDescription());

        System.out.println("\n   Building Professional Set:");
        BeautySetBuilder professionalBuilder = new ProfessionalMakeupSetBuilder();
        director.setBuilder(professionalBuilder);
        BeautySet professionalSet = director.constructBeautySet();
        System.out.println(professionalSet.getSetDescription());

        System.out.println("    Builder: Complex objects created step by step with different variations");
    }

    /**
     * Demonstrates Strategy pattern for interchangeable payment methods
     * Shows how different payment algorithms can be swapped at runtime
     */
    private void demonstrateStrategyPattern() {
        System.out.println("\n4.  STRATEGY PATTERN");
        System.out.println("   ==================");
        System.out.println("   Purpose: Interchangeable payment methods");

        PaymentContext paymentContext = new PaymentContext();
        double testAmount = 50.0;

        System.out.println("\n   Testing Apple Pay:");
        paymentContext.setPaymentStrategy(new ApplePayPayment("token123", "iPhone"));
        paymentContext.executePayment(testAmount);

        System.out.println("\n   Testing Credit Card:");
        paymentContext.setPaymentStrategy(new CreditCardPayment("4111111111111111", "John Doe", "12/25", "123"));
        paymentContext.executePayment(testAmount);

        System.out.println("\n   Testing QR Payment:");
        paymentContext.setPaymentStrategy(new QRPayment("QRCODE123", "Kaspi Bank"));
        paymentContext.executePayment(testAmount);

        System.out.println("   Strategy: Different payment algorithms interchangeable at runtime");
    }

    /**
     * Demonstrates Decorator pattern for adding services to products
     * Shows how additional features can be dynamically added to base products
     */
    private void demonstrateDecoratorPattern() {
        System.out.println("\n5.  DECORATOR PATTERN");
        System.out.println("   ====================");
        System.out.println("   Purpose: Dynamically add services to products");

        LipstickFactory factory = new LipstickFactory();
        CosmeticProduct baseProduct = factory.createProduct("red");

        System.out.println("\n   Base product:");
        CosmeticService service = new BasicCosmeticProduct(baseProduct);
        System.out.println(service.getServiceDetails());

        System.out.println("\n   Adding gift wrap:");
        service = new GiftWrapDecorator(service, "Premium");
        System.out.println(service.getServiceDetails());

        System.out.println("\n   Adding express delivery:");
        service = new ExpressDeliveryDecorator(service, 1);
        System.out.println(service.getServiceDetails());

        System.out.println("\n   Adding personalization:");
        service = new PersonalizationDecorator(service, "Happy Birthday!", "Elegant");
        System.out.println(service.getServiceDetails());

        System.out.println("    Decorator: Services added dynamically without modifying base product");
    }

    /**
     * Demonstrates Facade pattern by showing simplified interfaces to complex subsystems
     * Shows how complex operations are hidden behind simple method calls
     */
    private void demonstrateFacadePattern() {
        System.out.println("\n6.  FACADE PATTERN");
        System.out.println("   ================");
        System.out.println("   Purpose: Simple interface to complex subsystem");

        System.out.println("\n   Using facade for complete shopping experience:");

        System.out.println("   • Browsing products through ProductManagementFacade");
        productFacade.displayCatalog();

        System.out.println("\n   • Adding to cart through OrderProcessingFacade");
        orderFacade.addToCartById("LIP001", productFacade);
        orderFacade.addToCartById("MASC001", productFacade);
        orderFacade.displayCart();

        System.out.println("\n   • Setting payment through facade");
        orderFacade.setPaymentMethod("creditcard", "4111222233334444", "Demo User", "12/26", "123");

        System.out.println("\n   • Creating beauty set through BeautySetFacade");
        beautySetFacade.createAndDisplayBeautySet("gift");

        System.out.println("    Facade: Complex subsystem hidden behind simple interface");
    }

    // === INTEGRATED DEMO SCENARIO ===

    /**
     * Runs a complete shopping scenario demonstrating all patterns working together
     * Shows a realistic flow from product browsing to checkout with all patterns integrated
     */
    public void runCompleteDemoScenario() {
        System.out.println("\nCOMPLETE FSA_BEAUTY SHOPPING SCENARIO");
        System.out.println("=======================================");

        System.out.println("\n1.  Creating products...");
        browseProducts();

        System.out.println("\n2.  Setting up notifications...");
        productFacade.setupProductNotification("LIP001", "Alice");
        productFacade.setupProductNotification("MASC001", "Bob");

        System.out.println("\n3.  Creating beauty set...");
        beautySetFacade.createAndDisplayBeautySet("beginner");

        System.out.println("\n4.  Shopping experience...");
        addToCart("LIP001");
        addToCart("MASC001");
        addToCart("BLUSH002");
        showCart();

        System.out.println("\n5.  Processing payment...");
        setPaymentMethod("applepay", "ap1_demo_token", "iPhone 15");

        System.out.println("\n6.  Adding premium services...");
        LipstickFactory factory = new LipstickFactory();
        CosmeticProduct product = factory.createProduct("red");
        CosmeticService decoratedService = new BeautyConsultationDecorator(
                new SampleKitDecorator(
                        new GiftWrapDecorator(
                                new BasicCosmeticProduct(product), "Luxury"
                        )
                ), 30
        );
        System.out.println("Premium service package:");
        System.out.println(decoratedService.getServiceDetails());

        System.out.println("\n7.  Final checkout...");
        checkout();

        System.out.println("\n8.  Observer notifications in action...");
        productFacade.updateProductStock("LIP001", 0);
        productFacade.updateProductPrice("MASC001", 17.99);

        System.out.println("\n COMPLETE DEMO SCENARIO FINISHED!");
    }

    /**
     * Displays store information including product count, payment methods, and services
     */
    public void showStoreInfo() {
        System.out.println("\n FSA_BEAUTY STORE INFORMATION");
        System.out.println("==============================");
        System.out.println("Total products: " + productFacade.getProductCount());
        System.out.println("Available payment methods: Apple Pay, Credit Card, QR");
        System.out.println("Services: Gift Wrap, Express Delivery, Personalization");
        System.out.println("Beauty sets: Beginner, Professional, Gift");
        System.out.println("Store motto: Beauty powered by Design Patterns! ✨");
    }

    // Additional helper methods

    /**
     * Sets up product change notifications for a specific customer
     *
     * @param productId the product to monitor for changes
     * @param customerName the customer to receive notifications
     */
    public void setupProductNotification(String productId, String customerName) {
        productFacade.setupProductNotification(productId, customerName);
    }

    /**
     * Updates the stock quantity for a specific product
     *
     * @param productId the product to update
     * @param newStock the new stock quantity
     */
    public void updateProductStock(String productId, int newStock) {
        productFacade.updateProductStock(productId, newStock);
    }

    /**
     * Updates the price for a specific product
     *
     * @param productId the product to update
     * @param newPrice the new price value
     */
    public void updateProductPrice(String productId, double newPrice) {
        productFacade.updateProductPrice(productId, newPrice);
    }
}
