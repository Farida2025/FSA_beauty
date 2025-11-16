package fsabeauty.builder;

import fsabeauty.factory.CosmeticProduct;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customizable beauty set containing cosmetic products
 * with optional gift packaging and personalization features.
 * Follows the Builder pattern for flexible object creation.
 */
public class BeautySet {
    // Required properties
    private String setName;
    private List<CosmeticProduct> products;

    // Optional gift features
    private boolean hasGiftWrap;
    private boolean hasPersonalCard;
    private String boxType;

    // Set categorization
    private String occasion;
    private String difficultyLevel;

    /**
     * Constructs a new BeautySet with empty product list.
     */
    public BeautySet() {
        this.products = new ArrayList<>();
    }

    // GETTER METHODS

    /** @return the name of this beauty set */
    public String getSetName() { return setName; }

    /**
     * @return defensive copy of products list to maintain encapsulation
     */
    public List<CosmeticProduct> getProducts() { return new ArrayList<>(products); }

    /** @return true if gift wrap is included */
    public boolean hasGiftWrap() { return hasGiftWrap; }

    /** @return true if personal card is included */
    public boolean hasPersonalCard() { return hasPersonalCard; }

    /** @return type of packaging box */
    public String getBoxType() { return boxType; }

    /** @return occasion this set is designed for */
    public String getOccasion() { return occasion; }

    /** @return skill level required for using this set */
    public String getDifficultyLevel() { return difficultyLevel; }

    // SETTER METHODS

    /** @param setName the name to assign to this beauty set */
    public void setSetName(String setName) { this.setName = setName; }

    /** @param product the cosmetic product to add to this set */
    public void addProduct(CosmeticProduct product) { this.products.add(product); }

    /** @param hasGiftWrap whether to include gift wrap */
    public void setHasGiftWrap(boolean hasGiftWrap) { this.hasGiftWrap = hasGiftWrap; }

    /** @param hasPersonalCard whether to include personal card */
    public void setHasPersonalCard(boolean hasPersonalCard) { this.hasPersonalCard = hasPersonalCard; }

    /** @param boxType the type of packaging box to use */
    public void setBoxType(String boxType) { this.boxType = boxType; }

    /** @param occasion the occasion this set is designed for */
    public void setOccasion(String occasion) { this.occasion = occasion; }

    /** @param difficultyLevel the skill level required for this set */
    public void setDifficultyLevel(String difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    /**
     * Calculates total price by summing prices of all products in the set.
     * @return total price of all products in this beauty set
     */
    public double calculateTotalPrice() {
        return products.stream().mapToDouble(CosmeticProduct::getPrice).sum();
    }

    /**
     * Generates formatted description of the beauty set including all products,
     * packaging options, and total price.
     * @return formatted string description of the complete beauty set
     */
    public String getSetDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("🎁 ").append(setName).append("\n");
        sb.append("Occasion: ").append(occasion).append(" | Level: ").append(difficultyLevel).append("\n");
        sb.append("Products included:\n");
        for (CosmeticProduct product : products) {
            sb.append(" • ").append(product.getDescription()).append("\n");
        }
        sb.append("Box: ").append(boxType).append("\n");
        if (hasGiftWrap) sb.append("🎀 Includes gift wrap\n");
        if (hasPersonalCard) sb.append("💌 Includes personal card\n");
        sb.append(String.format("Total Price: $%.2f", calculateTotalPrice()));
        return sb.toString();
    }
}