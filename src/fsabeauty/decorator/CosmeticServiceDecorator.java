package fsabeauty.decorator;

/**
 * Abstract base class for all cosmetic service decorators in the decorator pattern.
 * Provides default implementation that delegates to the wrapped service, allowing
 * concrete decorators to override only the methods they need to modify.
 */
public abstract class CosmeticServiceDecorator implements CosmeticService {
    protected CosmeticService decoratedService;

    /**
     * Constructs a cosmetic service decorator wrapping the specified service.
     * @param service the cosmetic service to be decorated
     */
    public CosmeticServiceDecorator(CosmeticService service) {
        this.decoratedService = service;
    }

    /**
     * Returns the description of the decorated service by default.
     * Concrete decorators should override to append their specific features.
     * @return description from the wrapped service
     */
    @Override
    public String getDescription() {
        return decoratedService.getDescription();
    }

    /**
     * Returns the cost of the decorated service by default.
     * Concrete decorators should override to add their specific costs.
     * @return cost from the wrapped service
     */
    @Override
    public double getCost() {
        return decoratedService.getCost();
    }

    /**
     * Returns the service details of the decorated service by default.
     * Concrete decorators should override to append their specific details.
     * @return service details from the wrapped service
     */
    @Override
    public String getServiceDetails() {
        return decoratedService.getServiceDetails();
    }

    /**
     * Provides access to the base service description without decorator modifications.
     * Useful for decorators that need the original description before appending their own.
     * @return original description from the wrapped service
     */
    protected String getBaseDescription() {
        return decoratedService.getDescription();
    }

    /**
     * Provides access to the base service cost without decorator additions.
     * Useful for decorators that need the original cost before adding their own fees.
     * @return original cost from the wrapped service
     */
    protected double getBaseCost() {
        return decoratedService.getCost();
    }
}