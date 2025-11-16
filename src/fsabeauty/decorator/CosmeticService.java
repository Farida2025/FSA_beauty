package fsabeauty.decorator;

/**
 * Core service interface for cosmetic products and services in the decorator pattern.
 * Defines the contract for all cosmetic service components, including base products
 * and decorators, ensuring consistent behavior across different service types.
 */
public interface CosmeticService {

    /**
     * Returns a concise description of the cosmetic service or product.
     * For composite services, includes all components in the description.
     * @return brief description of the service offering
     */
    String getDescription();

    /**
     * Calculates and returns the total cost of the cosmetic service.
     * For decorated services, includes costs of all nested components.
     * @return total cost of the service in dollars
     */
    double getCost();

    /**
     * Provides detailed breakdown of the service including all components and pricing.
     * Useful for receipts, invoices, and detailed service explanations.
     * @return formatted string with complete service details and cost breakdown
     */
    String getServiceDetails();
}