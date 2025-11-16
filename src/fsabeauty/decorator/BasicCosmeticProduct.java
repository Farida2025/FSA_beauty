package fsabeauty.decorator;

import fsabeauty.factory.CosmeticProduct;

/**
 * Concrete component class that wraps a basic cosmetic product with service functionality.
 * Serves as the foundation for the decorator pattern, providing core product information
 * and cost calculation without additional services.
 */
public class BasicCosmeticProduct implements CosmeticService {
    private CosmeticProduct product;

    /**
     * Constructs a basic cosmetic service wrapper around a cosmetic product.
     * @param product the cosmetic product to be wrapped with service functionality
     */
    public BasicCosmeticProduct(CosmeticProduct product) {
        this.product = product;
    }

    /**
     * Returns the basic description of the wrapped cosmetic product.
     * @return product name as the service description
     */
    @Override
    public String getDescription() {
        return product.getName();
    }

    /**
     * Calculates the base cost of the cosmetic product without additional services.
     * @return the price of the underlying cosmetic product
     */
    @Override
    public double getCost() {
        return product.getPrice();
    }

    /**
     * Generates detailed service information including product description and price.
     * @return formatted string with product details and cost
     */
    @Override
    public String getServiceDetails() {
        return String.format("Basic Product: %s - $%.2f", product.getDescription(), product.getPrice());
    }

    /**
     * Provides access to the underlying cosmetic product instance.
     * Useful for decorators that need to modify or extend product functionality.
     * @return the wrapped CosmeticProduct instance
     */
    public CosmeticProduct getProduct() {
        return product;
    }
}