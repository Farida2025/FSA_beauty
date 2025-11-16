package fsabeauty.factory;

public class MascaraFactory extends CosmeticFactory {

    @Override
    public CosmeticProduct createProduct(String type) {
        System.out.println(" Creating Mascara with type: " + type);

        // Create mascara product based on requested type
        switch (type.toLowerCase()) {
            case "waterproof":
                return new Mascara("Waterproof");
            case "regular":
                return new Mascara("Regular");
            default:
                return new Mascara("Regular"); // Default type if no match
        }
    }

    // Factory-specific methods for mascara products
    public void testMascaraBrush(Mascara mascara) {
        System.out.println(" Testing " + mascara.getType() + " mascara brush... OK!");
    }

    @Override
    public String getFactoryType() {
        return "FSA Mascara Factory";
    }
}