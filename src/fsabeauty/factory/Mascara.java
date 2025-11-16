package fsabeauty.factory;

public class Mascara implements CosmeticProduct {
    private String type;

    // Constructor - sets the mascara type (volume, lengthening, etc.)
    public Mascara(String type) {
        this.type = type;
    }

    // Interface implementation methods
    @Override public String getName() { return "Volume Mascara"; }
    @Override public String getBrand() { return "FSA_Beauty"; }
    @Override public double getPrice() { return 19.99; }
    @Override public String getCategory() { return "Mascara"; }
    @Override public String getColor() { return "Black"; } // Fixed color for mascara
    @Override public String getType() { return type; }

    @Override
    public String getDescription() {
        // Generate product description with mascara type
        return String.format("FSA_Beauty Volume Mascara - Type: %s", type);
    }
}