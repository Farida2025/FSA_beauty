package fsabeauty.decorator;

/**
 * Decorator class that adds gift wrapping service to cosmetic products or services.
 * Enhances the base service with various gift wrap styles and associated costs.
 */
public class GiftWrapDecorator extends CosmeticServiceDecorator {
    private String wrapStyle;

    /**
     * Constructs a gift wrap decorator with specified wrapping style.
     * @param service the cosmetic service to be enhanced with gift wrapping
     * @param wrapStyle the style of gift wrap (Standard, Premium, Luxury)
     */
    public GiftWrapDecorator(CosmeticService service, String wrapStyle) {
        super(service);
        this.wrapStyle = wrapStyle;
    }

    /**
     * Constructs a gift wrap decorator with default Standard wrapping.
     * @param service the cosmetic service to be enhanced with gift wrapping
     */
    public GiftWrapDecorator(CosmeticService service) {
        this(service, "Standard");
    }

    /**
     * Returns the service description including gift wrap details.
     * Appends wrap style information to the base service description.
     * @return complete description with gift wrap style
     */
    @Override
    public String getDescription() {
        return decoratedService.getDescription() + " + " + wrapStyle + " Gift Wrap";
    }

    /**
     * Calculates the total cost including base service and gift wrap fees.
     * Wrap cost is determined by the selected style and quality level.
     * @return total cost of service plus gift wrap charges
     */
    @Override
    public double getCost() {
        return decoratedService.getCost() + getWrapCost();
    }

    /**
     * Generates detailed service breakdown including gift wrap specifics.
     * Provides line-item details for both base service and gift wrap add-on.
     * @return formatted string with complete service and gift wrap breakdown
     */
    @Override
    public String getServiceDetails() {
        return decoratedService.getServiceDetails() +
                String.format("\n   + %s Gift Wrap: $%.2f", wrapStyle, getWrapCost());
    }

    /**
     * Calculates the gift wrap cost based on selected style.
     * Uses tiered pricing: Standard ($5.99), Premium ($12.99), Luxury ($19.99).
     * Case-insensitive matching for wrap style flexibility.
     * @return calculated gift wrap cost based on selected style
     */
    private double getWrapCost() {
        switch (wrapStyle.toLowerCase()) {
            case "premium": return 12.99;
            case "luxury": return 19.99;
            default: return 5.99; // Standard wrapping
        }
    }

    /**
     * Returns the current gift wrap style.
     * @return the style of gift wrap applied to this service
     */
    public String getWrapStyle() {
        return wrapStyle;
    }
}