package fsabeauty.facade;

import fsabeauty.factory.*;
import fsabeauty.observer.*;
import java.util.*;

/**
 * Facade class for product management operations that provides a simplified interface
 * for catalog management, product creation, and observer notifications.
 * This class integrates Factory pattern for product creation and Observer pattern
 * for product change notifications in a unified interface.
 */
public class ProductManagementFacade {
    private Map<String, Product> productCatalog;
    private LipstickFactory lipstickFactory;
    private MascaraFactory mascaraFactory;
    private BlushFactory blushFactory;
    private List<Customer> customers;

    public ProductManagementFacade() {
        this.productCatalog = new HashMap<>();
        this.lipstickFactory = new LipstickFactory();
        this.mascaraFactory = new MascaraFactory();
        this.blushFactory = new BlushFactory();
        this.customers = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        CosmeticProduct redLipstick = lipstickFactory.createProduct("red");
        CosmeticProduct brownLipstick = lipstickFactory.createProduct("brown");
        CosmeticProduct pinkLipstick = lipstickFactory.createProduct("pink");

        CosmeticProduct waterproofMascara = mascaraFactory.createProduct("waterproof");
        CosmeticProduct regularMascara = mascaraFactory.createProduct("regular");

        CosmeticProduct redBlush = blushFactory.createProduct("red");
        CosmeticProduct peachBlush = blushFactory.createProduct("peach");
        CosmeticProduct pinkBlush = blushFactory.createProduct("pink");

        Product obsRedLipstick = new Product(
                "LIP001",
                "Luxury Lipstick (Red)",
                "FSA_Beauty",
                redLipstick.getPrice(),
                10
        );

        Product obsBrownLipstick = new Product("LIP002", "Luxury Lipstick (Red)", "FSA_Beauty", brownLipstick.getPrice(), 8);
        Product obsPinkLipstick = new Product(
                "LIP002",
                "Luxury Lipstick (Pink)",
                "FSA_Beauty",
                pinkLipstick.getPrice(),
                7
        );

        Product obsWaterproofMascara = new Product("MASC001", waterproofMascara.getName(), "FSA_Beauty", waterproofMascara.getPrice(), 15);
        Product obsRegularMascara = new Product("MASC002", regularMascara.getName(), "FSA_Beauty", regularMascara.getPrice(), 12);

        Product obsRedBlush = new Product("BLUSH001", redBlush.getName(), "FSA_Beauty", redBlush.getPrice(), 7);
        Product obsPeachBlush = new Product("BLUSH002", peachBlush.getName(), "FSA_Beauty", peachBlush.getPrice(), 6);
        Product obsPinkBlush = new Product("BLUSH003", pinkBlush.getName(), "FSA_Beauty", pinkBlush.getPrice(), 9);

        productCatalog.put("LIP001", obsRedLipstick);
        productCatalog.put("LIP002", obsBrownLipstick);
        productCatalog.put("LIP003", obsPinkLipstick);
        productCatalog.put("MASC001", obsWaterproofMascara);
        productCatalog.put("MASC002", obsRegularMascara);
        productCatalog.put("BLUSH001", obsRedBlush);
        productCatalog.put("BLUSH002", obsPeachBlush);
        productCatalog.put("BLUSH003", obsPinkBlush);

        customers.add(new Customer("CUST001", "Alice", "alice@email.com"));
        customers.add(new Customer("CUST002", "Bob", "bob@email.com"));
        customers.add(new Customer("CUST003", "Carol", "carol@email.com"));
    }

    /**
     * Displays the complete product catalog with formatted information
     * Shows product ID, name, price, and current stock levels
     */
    public void displayCatalog() {
        System.out.println("\n🌈 FSA_BEAUTY PRODUCT CATALOG:");
        System.out.println("=============================");
        productCatalog.forEach((id, product) -> {
            System.out.printf("🆔 %s | 💄 %s | 💰 $%.2f | 📦 Stock: %d%n",
                    id, product.getName(), product.getPrice(), product.getStock());
        });
    }

    /**
     * Retrieves a product from the catalog by its unique identifier
     *
     * @param productId the unique identifier of the product
     * @return the Product object or null if not found
     */
    public Product getProduct(String productId) {
        return productCatalog.get(productId);
    }

    /**
     * Creates a CosmeticProduct from a Product using appropriate factory
     *
     * @param product the base product to convert
     * @return the corresponding CosmeticProduct instance
     */
    public CosmeticProduct createCosmeticProduct(Product product) {
        String name = product.getName();
        if (name.contains("Lipstick")) {
            if (name.contains("Red")) return lipstickFactory.createProduct("red");
            if (name.contains("Brown")) return lipstickFactory.createProduct("brown");
            if (name.contains("Pink")) return lipstickFactory.createProduct("pink");
        } else if (name.contains("Mascara")) {
            if (name.contains("Waterproof")) return mascaraFactory.createProduct("waterproof");
            if (name.contains("Regular")) return mascaraFactory.createProduct("regular");
        } else if (name.contains("Blush")) {
            if (name.contains("Red")) return blushFactory.createProduct("red");
            if (name.contains("Peach")) return blushFactory.createProduct("peach");
            if (name.contains("Pink")) return blushFactory.createProduct("pink");
        }
        return lipstickFactory.createProduct("red");
    }

    /**
     * Sets up product change notifications for a specific customer
     *
     * @param productId the product to monitor for changes
     * @param customerName the customer to receive notifications
     */
    public void setupProductNotification(String productId, String customerName) {
        Product product = productCatalog.get(productId);
        Customer customer = findCustomerByName(customerName);

        if (product != null && customer != null) {
            product.registerObserver(customer);
            System.out.println("✅ " + customerName + " will be notified about " + product.getName());
        } else {
            System.out.println("❌ Product or customer not found");
        }
    }

    /**
     * Updates the stock quantity for a specific product
     * Triggers observer notifications if stock levels change significantly
     *
     * @param productId the product to update
     * @param newStock the new stock quantity
     */
    public void updateProductStock(String productId, int newStock) {
        Product product = productCatalog.get(productId);
        if (product != null) {
            System.out.println("📦 Updating stock for " + product.getName() + " to " + newStock);
            product.setStock(newStock);
        } else {
            System.out.println("❌ Product not found: " + productId);
        }
    }

    /**
     * Updates the price for a specific product
     * Triggers observer notifications for price changes
     *
     * @param productId the product to update
     * @param newPrice the new price value
     */
    public void updateProductPrice(String productId, double newPrice) {
        Product product = productCatalog.get(productId);
        if (product != null) {
            System.out.println("💰 Updating price for " + product.getName() + " to $" + newPrice);
            product.setPrice(newPrice);
        } else {
            System.out.println("❌ Product not found: " + productId);
        }
    }

    /**
     * Demonstrates the Factory Method pattern by creating different cosmetic products
     * Shows how factories create specific product types with their characteristics
     */
    public void demonstrateFactoryMethods() {
        System.out.println("\n🏭 FACTORY METHODS DEMONSTRATION:");
        System.out.println("================================");

        CosmeticProduct lipstick = lipstickFactory.createProduct("red");
        lipstickFactory.displayProductInfo(lipstick);

        CosmeticProduct mascara = mascaraFactory.createProduct("waterproof");
        mascaraFactory.displayProductInfo(mascara);

        CosmeticProduct blush = blushFactory.createProduct("peach");
        blushFactory.displayProductInfo(blush);
    }

    /**
     * Demonstrates the Observer pattern by simulating product changes and notifications
     * Shows how customers automatically receive updates about product modifications
     */
    public void demonstrateObserverNotifications() {
        System.out.println("\n🔔 OBSERVER NOTIFICATIONS DEMONSTRATION:");
        System.out.println("=====================================");

        setupProductNotification("LIP001", "Alice");
        setupProductNotification("MASC001", "Bob");
        setupProductNotification("BLUSH002", "Carol");

        updateProductStock("LIP001", 0);
        updateProductStock("LIP001", 5);
        updateProductPrice("MASC001", 15.99);
        updateProductStock("BLUSH002", 2);
    }

    /**
     * Finds a customer by name in the customer list
     *
     * @param name the name of the customer to find
     * @return the Customer object or null if not found
     */
    private Customer findCustomerByName(String name) {
        return customers.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets a list of all available product IDs in the catalog
     *
     * @return list of product identifiers
     */
    public List<String> getAvailableProductIds() {
        return new ArrayList<>(productCatalog.keySet());
    }

    /**
     * Checks if a product is available for purchase
     *
     * @param productId the product to check
     * @return true if product exists and has stock, false otherwise
     */
    public boolean isProductAvailable(String productId) {
        Product product = productCatalog.get(productId);
        return product != null && product.getStock() > 0;
    }

    /**
     * Gets the total number of products in the catalog
     *
     * @return the count of products in the catalog
     */
    public int getProductCount() {
        return productCatalog.size();
    }
}