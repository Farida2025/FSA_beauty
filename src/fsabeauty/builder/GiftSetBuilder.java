package fsabeauty.builder;

import fsabeauty.factory.*;

/**
 * Concrete builder implementation for creating premium gift-oriented makeup sets.
 * Configures products and packaging specifically designed for gifting occasions.
 */
public class GiftSetBuilder implements BeautySetBuilder {
    private BeautySet beautySet;
    private LipstickFactory lipstickFactory;
    private MascaraFactory mascaraFactory;
    private BlushFactory blushFactory;

    /**
     * Constructs a new gift set builder.
     * Initializes the beauty set and required product factories for gift creation.
     */
    public GiftSetBuilder() {
        this.beautySet = new BeautySet();
        this.lipstickFactory = new LipstickFactory();
        this.mascaraFactory = new MascaraFactory();
        this.blushFactory = new BlushFactory();
    }

    /**
     * Sets the name for the gift makeup set.
     * Uses a premium, gift-appropriate name that conveys quality and thoughtfulness.
     */
    @Override
    public void buildSetName() {
        beautySet.setSetName("FSA Perfect Gift Set");
    }

    /**
     * Builds and adds universally appealing cosmetic products to the gift set.
     * Selects classic, flattering colors that work for most skin tones and preferences.
     * Products are chosen for their broad appeal and gift-suitability.
     */
    @Override
    public void buildProducts() {
        System.out.println("🛠️ Building products for gift set...");
        // Red lipstick - classic, universally flattering gift color
        beautySet.addProduct(lipstickFactory.createProduct("red"));
        // Regular mascara - safe choice that works for everyone
        beautySet.addProduct(mascaraFactory.createProduct("regular"));
        // Pink blush - universally flattering shade for most skin tones
        beautySet.addProduct(blushFactory.createProduct("pink"));
    }

    /**
     * Configures gift wrap option for the set.
     * Always enabled for gift sets as premium packaging is essential for gifting.
     */
    @Override
    public void buildGiftWrap() {
        beautySet.setHasGiftWrap(true); // Always included in gift sets
    }

    /**
     * Configures personal card inclusion for the gift set.
     * Always enabled to allow for personalized messages in gift scenarios.
     */
    @Override
    public void buildPersonalCard() {
        beautySet.setHasPersonalCard(true); // Essential for gift presentations
    }

    /**
     * Sets the premium box type specifically designed for gift presentation.
     * Uses high-quality packaging with decorative elements like ribbons.
     */
    @Override
    public void buildBoxType() {
        beautySet.setBoxType("Premium Gift Box with Ribbon");
    }

    /**
     * Sets the occasion context for the gift makeup set.
     * Focuses on common gifting occasions like birthdays and holidays.
     */
    @Override
    public void buildOccasion() {
        beautySet.setOccasion("Birthday & Holidays");
    }

    /**
     * Sets the difficulty level to be inclusive for all skill levels.
     * Gift sets should be accessible to recipients of any experience level.
     */
    @Override
    public void buildDifficultyLevel() {
        beautySet.setDifficultyLevel("All Levels");
    }

    /**
     * Returns the fully constructed gift beauty set.
     * @return completed BeautySet configured for premium gifting
     */
    @Override
    public BeautySet getBeautySet() {
        return beautySet;
    }
}