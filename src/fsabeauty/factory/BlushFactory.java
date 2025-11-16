package fsabeauty.factory;

public class BlushFactory extends CosmeticFactory {

    @Override
    public CosmeticProduct createProduct(String color) {
        System.out.println("  Creating Blush with color: " + color);

        // Create blush product based on requested color
        switch (color.toLowerCase()) {
            case "red":
                return new Blush("Red");
            case "peach":
                return new Blush("Peach");
            case "pink":
                return new Blush("Pink");
            default:
                return new Blush("Peach"); // Default color if no match
        }
    }

    // Factory-specific methods for blush products
    public void testBlushPigmentation(Blush blush) {
        System.out.println("  Testing " + blush.getColor() + " blush pigmentation... OK!");
    }

    @Override
    public String getFactoryType() {
        return "FSA Blush Factory";
    }
}