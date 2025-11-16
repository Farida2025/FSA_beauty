package fsabeauty.factory;

public class Blush implements CosmeticProduct {
    private String color;

    // Constructor - sets the blush color
    public Blush(String color) {
        this.color = color;
    }

    // Interface implementation methods
    @Override public String getName() { return "Soft Blush"; }
    @Override public String getBrand() { return "FSA_Beauty"; }
    @Override public double getPrice() { return 22.99; }
    @Override public String getCategory() { return "Blush"; }
    @Override public String getColor() { return color; }
    @Override public String getType() { return "Powder"; }

    @Override
    public String getDescription() {
        // Generate product description with color information
        return String.format("FSA_Beauty Soft Blush - Color: %s", color);
    }
}