package fsabeauty.factory;

public class LipstickFactory extends CosmeticFactory {

    @Override
    public CosmeticProduct createProduct(String color) {
        System.out.println("  Creating Lipstick with color: " + color);

        // Create lipstick product with specified color and matte finish
        switch (color.toLowerCase()) {
            case "red":
                return new Lipstick("Red", "Matte");
            case "brown":
                return new Lipstick("Brown", "Matte");
            case "pink":
                return new Lipstick("Pink", "Matte");
            default:
                return new Lipstick("Red", "Matte"); // Default color if no match
        }
    }

    // Factory-specific methods for lipstick products
    public void testLipstickQuality(Lipstick lipstick) {
        System.out.println("  Testing " + lipstick.getColor() + " lipstick quality... OK!");
    }

    @Override
    public String getFactoryType() {
        return "FSA Lipstick Factory";
    }
}