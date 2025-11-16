package fsabeauty.decorator;

/**
 * Decorator class that adds express delivery service to cosmetic products or services.
 * Enhances the base service with fast delivery options and associated costs.
 */
public class ExpressDeliveryDecorator extends CosmeticServiceDecorator {
    private int deliveryDays;

    /**
     * Constructs an express delivery decorator with specified delivery timeframe.
     * @param service the cosmetic service to be enhanced with delivery
     * @param deliveryDays number of days for delivery (1 for next-day, 2 for 2-day, etc.)
     */
    public ExpressDeliveryDecorator(CosmeticService service, int deliveryDays) {
        super(service);
        this.deliveryDays = deliveryDays;
    }

    /**
     * Constructs an express delivery decorator with default next-day delivery.
     * @param service the cosmetic service to be enhanced with delivery
     */
    public ExpressDeliveryDecorator(CosmeticService service) {
        this(service, 1);
    }

    /**
     * Returns the service description including express delivery details.
     * Appends delivery information to the base service description.
     * @return complete description with delivery timeframe
     */
    @Override
    public String getDescription() {
        String dayText = deliveryDays == 1 ? "day" : "days";
        return decoratedService.getDescription() + " + Express Delivery (" + deliveryDays + " " + dayText + ")";
    }

    /**
     * Calculates the total cost including base service and delivery fees.
     * Delivery cost is determined by the speed of delivery requested.
     * @return total cost of service plus delivery charges
     */
    @Override
    public double getCost() {
        return decoratedService.getCost() + getDeliveryCost();
    }

    /**
     * Generates detailed service breakdown including delivery specifics.
     * Provides line-item details for both base service and delivery add-on.
     * @return formatted string with complete service and delivery breakdown
     */
    @Override
    public String getServiceDetails() {
        return decoratedService.getServiceDetails() +
                String.format("\n   + Express Delivery (%d days): $%.2f", deliveryDays, getDeliveryCost());
    }

    /**
     * Calculates the delivery cost based on delivery speed.
     * Uses tiered pricing: same-day ($19.99), next-day ($15.99), 2-day ($9.99).
     * @return calculated delivery cost based on selected speed
     */
    private double getDeliveryCost() {
        if (deliveryDays == 1) return 15.99;  // Next-day delivery
        if (deliveryDays == 2) return 9.99;   // 2-day delivery
        return 19.99; // Same-day delivery (deliveryDays = 0 or other values)
    }

    /**
     * Returns the delivery timeframe in days.
     * @return number of days for delivery (1 for next-day, 2 for 2-day, etc.)
     */
    public int getDeliveryDays() {
        return deliveryDays;
    }
}