package fsabeauty.builder;

import fsabeauty.factory.*;

/**
 * Concrete builder implementation for creating beginner-friendly makeup sets.
 * Configures products and settings appropriate for makeup novices.
 */
public class BeginnerMakeupSetBuilder implements BeautySetBuilder {
    private BeautySet beautySet;
    private LipstickFactory lipstickFactory;
    private MascaraFactory mascaraFactory;
    private BlushFactory blushFactory;

    /**
     * Constructs a new beginner makeup set builder.
     * Initializes the beauty set and required product factories.
     */
    public BeginnerMakeupSetBuilder() {
        this.beautySet = new BeautySet();
        this.lipstickFactory = new LipstickFactory();
        this.mascaraFactory = new MascaraFactory();
        this.blushFactory = new BlushFactory();
    }

    /**
     * Sets the name for the beginner makeup set.
     * Uses a clear, descriptive name indicating it's for beginners.
     */
    @Override
    public void buildSetName() {
        beautySet.setSetName("FSA Beginner Makeup Kit");
    }

    /**
     * Builds and adds beginner-appropriate cosmetic products to the set.
     * Selects easy-to-apply, natural-looking products in forgiving colors.
     * Products are chosen for their simplicity and ease of use for novices.
     */
    @Override
    public void buildProducts() {
        System.out.println("🛠️ Building products for beginner set...");
        // Pink lipstick - easy to wear and forgiving color
        beautySet.addProduct(lipstickFactory.createProduct("pink"));
        // Regular mascara - easy to remove and apply
        beautySet.addProduct(mascaraFactory.createProduct("regular"));
        // Peach blush - provides natural-looking color
        beautySet.addProduct(blushFactory.createProduct("peach"));
    }

    /**
     * Configures gift wrap option for the beginner set.
     * Defaults to true as beginners often appreciate ready-to-gift packaging.
     */
    @Override
    public void buildGiftWrap() {
        beautySet.setHasGiftWrap(true);
    }

    /**
     * Configures personal card inclusion for the beginner set.
     * Defaults to true to allow for personalized messages or instructions.
     */
    @Override
    public void buildPersonalCard() {
        beautySet.setHasPersonalCard(true);
    }

    /**
     * Sets the box type specifically designed for beginner users.
     * Emphasizes user-friendly packaging that's easy to open and use.
     */
    @Override
    public void buildBoxType() {
        beautySet.setBoxType("Beginner Friendly Box");
    }

    /**
     * Sets the occasion context for the beginner makeup set.
     * Focuses on everyday usage rather than special events.
     */
    @Override
    public void buildOccasion() {
        beautySet.setOccasion("Everyday Makeup");
    }

    /**
     * Sets the difficulty level to match the target user skill.
     * Explicitly marks this set as appropriate for beginners.
     */
    @Override
    public void buildDifficultyLevel() {
        beautySet.setDifficultyLevel("Beginner");
    }

    /**
     * Returns the fully constructed beginner beauty set.
     * @return completed BeautySet configured for beginner users
     */
    @Override
    public BeautySet getBeautySet() {
        return beautySet;
    }
}