package fsabeauty.decorator;

/**
 * Decorator class that adds personalization services to cosmetic products or services.
 * Enhances the base service with custom messages and font styling for gift presentations.
 */
public class PersonalizationDecorator extends CosmeticServiceDecorator {
    private String personalMessage;
    private String fontStyle;

    /**
     * Constructs a personalization decorator with specified message and font style.
     * @param service the cosmetic service to be enhanced with personalization
     * @param personalMessage custom text to be included with the service
     * @param fontStyle the typography style for the personal message
     */
    public PersonalizationDecorator(CosmeticService service, String personalMessage, String fontStyle) {
        super(service);
        this.personalMessage = personalMessage;
        this.fontStyle = fontStyle;
    }

    /**
     * Constructs a personalization decorator with specified message and default Elegant font.
     * @param service the cosmetic service to be enhanced with personalization
     * @param personalMessage custom text to be included with the service
     */
    public PersonalizationDecorator(CosmeticService service, String personalMessage) {
        this(service, personalMessage, "Elegant");
    }

    /**
     * Returns the service description including personalization feature.
     * Appends personalization information to the base service description.
     * @return complete description with personalization indication
     */
    @Override
    public String getDescription() {
        return decoratedService.getDescription() + " + Personalization";
    }

    /**
     * Calculates the total cost including base service and personalization fee.
     * Personalization uses a fixed rate regardless of message length or font style.
     * @return total cost of service plus personalization charge
     */
    @Override
    public double getCost() {
        return decoratedService.getCost() + 3.99; // Fixed personalization fee
    }

    /**
     * Generates detailed service breakdown including personalization specifics.
     * Provides line-item details with actual message content and font style used.
     * @return formatted string with complete service and personalization breakdown
     */
    @Override
    public String getServiceDetails() {
        return decoratedService.getServiceDetails() +
                String.format("\n   + Personal Card (%s font): $3.99\n     Message: \"%s\"",
                        fontStyle, personalMessage);
    }

    /**
     * Returns the personalized message included with this service.
     * @return the custom text message for personalization
     */
    public String getPersonalMessage() {
        return personalMessage;
    }

    /**
     * Returns the font style used for the personalization.
     * @return the typography style applied to the personal message
     */
    public String getFontStyle() {
        return fontStyle;
    }
}