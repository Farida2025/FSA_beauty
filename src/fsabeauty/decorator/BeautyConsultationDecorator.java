package fsabeauty.decorator;

/**
 * Decorator class that adds beauty consultation service to cosmetic products or services.
 * Extends the base service with professional consultation features and cost.
 */
public class BeautyConsultationDecorator extends CosmeticServiceDecorator {
    private int consultationMinutes;

    /**
     * Constructs a beauty consultation decorator with specified consultation duration.
     * @param service the cosmetic service to be enhanced with consultation
     * @param consultationMinutes duration of consultation in minutes
     */
    public BeautyConsultationDecorator(CosmeticService service, int consultationMinutes) {
        super(service);
        this.consultationMinutes = consultationMinutes;
    }

    /**
     * Constructs a beauty consultation decorator with default 30-minute consultation.
     * @param service the cosmetic service to be enhanced with consultation
     */
    public BeautyConsultationDecorator(CosmeticService service) {
        this(service, 30);
    }

    /**
     * Returns the service description including consultation details.
     * Appends consultation information to the base service description.
     * @return complete description with consultation details
     */
    @Override
    public String getDescription() {
        return decoratedService.getDescription() + " + Beauty Consultation (" + consultationMinutes + "min)";
    }

    /**
     * Calculates the total cost including base service and consultation fees.
     * Consultation cost is calculated based on duration and rate.
     * @return total cost of service plus consultation
     */
    @Override
    public double getCost() {
        return decoratedService.getCost() + getConsultationCost();
    }

    /**
     * Generates detailed service breakdown including consultation specifics.
     * Provides line-item details for both base service and consultation add-on.
     * @return formatted string with complete service and cost breakdown
     */
    @Override
    public String getServiceDetails() {
        return decoratedService.getServiceDetails() +
                String.format("\n   + Beauty Consultation (%d minutes): $%.2f",
                        consultationMinutes, getConsultationCost());
    }

    /**
     * Calculates the consultation cost based on duration and rate.
     * Uses a fixed rate of $0.5 per minute for consultation services.
     * @return calculated consultation cost
     */
    private double getConsultationCost() {
        return consultationMinutes * 0.5; // $0.5 per minute consultation rate
    }

    /**
     * Returns the duration of the consultation service.
     * @return consultation duration in minutes
     */
    public int getConsultationMinutes() {
        return consultationMinutes;
    }
}