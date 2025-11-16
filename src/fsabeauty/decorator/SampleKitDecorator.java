package fsabeauty.decorator;

public class SampleKitDecorator extends CosmeticServiceDecorator {
    private String kitType;

    public SampleKitDecorator(CosmeticService service, String kitType) {
        super(service);
        this.kitType = kitType;
    }

    public SampleKitDecorator(CosmeticService service) {
        this(service, "Beauty Sampler");
    }

    @Override
    public String getDescription() {
        return decoratedService.getDescription() + " + " + kitType;
    }

    @Override
    public double getCost() {
        return decoratedService.getCost() + getKitCost();
    }

    @Override
    public String getServiceDetails() {
        return decoratedService.getServiceDetails() +
                String.format("\n   + %s: $%.2f", kitType, getKitCost());
    }

    private double getKitCost() {
        switch (kitType.toLowerCase()) {
            case "premium sampler": return 8.99;
            case "luxury trial kit": return 12.99;
            default: return 4.99;
        }
    }

    public String getKitType() {
        return kitType;
    }
}