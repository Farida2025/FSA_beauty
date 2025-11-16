package fsabeauty.factory;

public class Lipstick implements CosmeticProduct {
    private String color;
    private String finish;

    // Constructor - sets both color and finish type
    public Lipstick(String color, String finish) {
        this.color = color;
        this.finish = finish;
    }

    // Interface implementation methods
    @Override public String getName() { return "Luxury Lipstick"; }
    @Override public String getBrand() { return "FSA_Beauty"; }
    @Override public double getPrice() { return 24.99; }
    @Override public String getCategory() { return "Lipstick"; }
    @Override public String getColor() { return color; }
    @Override public String getType() { return finish; } // Returns finish type

    @Override
    public String getDescription() {
        // Generate detailed product description with color and finish
        return String.format("FSA_Beauty Luxury Lipstick - Color: %s, Finish: %s", color, finish);
    }
}