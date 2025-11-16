package fsabeauty.builder;

import fsabeauty.factory.*;

/**
 * Concrete builder implementation for creating professional-grade makeup sets.
 * Configures products and settings appropriate for makeup artists and advanced users.
 */
public class ProfessionalMakeupSetBuilder implements BeautySetBuilder {
    private BeautySet beautySet;
    private LipstickFactory lipstickFactory;
    private MascaraFactory mascaraFactory;
    private BlushFactory blushFactory;

    /**
     * Constructs a new professional makeup set builder.
     * Initializes the beauty set and required product factories for professional use.
     */
    public ProfessionalMakeupSetBuilder() {
        this.beautySet = new BeautySet();
        this.lipstickFactory = new LipstickFactory();
        this.mascaraFactory = new MascaraFactory();
        this.blushFactory = new BlushFactory();
    }

    /**
     * Sets the name for the professional makeup set.
     * Uses a sophisticated name reflecting the high-quality, comprehensive nature of the collection.
     */
    @Override
    public void buildSetName() {
        beautySet.setSetName("FSA Professional Makeup Collection");
    }

    /**
     * Builds and adds professional-grade cosmetic products to the set.
     * Includes multiple color options and long-lasting formulas suitable for various clients and occasions.
     * Products are chosen for their versatility, durability, and professional application requirements.
     */
    @Override
    public void buildProducts() {
        System.out.println("🛠️ Building products for professional set...");
        // Red lipstick - bold, classic color for dramatic looks
        beautySet.addProduct(lipstickFactory.createProduct("red"));
        // Brown lipstick - versatile neutral alternative
        beautySet.addProduct(lipstickFactory.createProduct("brown"));
        // Waterproof mascara - long-lasting formula for professional settings
        beautySet.addProduct(mascaraFactory.createProduct("waterproof"));
        // Red blush - provides dramatic contouring and bold looks
        beautySet.addProduct(blushFactory.createProduct("red"));
        // Pink blush - versatile option for natural to medium coverage
        beautySet.addProduct(blushFactory.createProduct("pink"));
    }

    /**
     * Configures gift wrap option for the professional set.
     * Enabled by default as professionals often purchase sets for gifts or client presentations.
     */
    @Override
    public void buildGiftWrap() {
        beautySet.setHasGiftWrap(true);
    }

    /**
     * Configures personal card inclusion for the professional set.
     * Enabled by default for professional gifting and client documentation.
     */
    @Override
    public void buildPersonalCard() {
        beautySet.setHasPersonalCard(true);
    }

    /**
     * Sets the premium box type designed for professional users.
     * Emphasizes luxury and durability suitable for professional kit storage.
     */
    @Override
    public void buildBoxType() {
        beautySet.setBoxType("Professional Luxury Box");
    }

    /**
     * Sets the occasion context for the professional makeup set.
     * Focuses on special events and photography where professional makeup is typically required.
     */
    @Override
    public void buildOccasion() {
        beautySet.setOccasion("Special Events & Photography");
    }

    /**
     * Sets the difficulty level to professional.
     * Indicates this set requires advanced skills and is intended for experienced users.
     */
    @Override
    public void buildDifficultyLevel() {
        beautySet.setDifficultyLevel("Professional");
    }

    /**
     * Returns the fully constructed professional beauty set.
     * @return completed BeautySet configured for professional use with expanded product range
     */
    @Override
    public BeautySet getBeautySet() {
        return beautySet;
    }
}