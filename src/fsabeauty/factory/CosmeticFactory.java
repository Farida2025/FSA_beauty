package fsabeauty.factory;

public abstract class CosmeticFactory {
    // Factory Method - must be implemented by subclasses
    public abstract CosmeticProduct createProduct(String variant);

    // Common utility methods for all cosmetic factories
    public void displayProductInfo(CosmeticProduct product) {
        System.out.println("   Product Information:");
        System.out.println("   Name: " + product.getName());
        System.out.println("   Brand: " + product.getBrand());
        System.out.println("   Price: $" + product.getPrice());
        System.out.println("   Description: " + product.getDescription());
    }

    // Returns factory type - can be overridden by subclasses
    public String getFactoryType() {
        return "FSA Beauty Factory";
    }
}