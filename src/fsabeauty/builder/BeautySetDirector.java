package fsabeauty.builder;

/**
 * Director class that controls the construction process of BeautySet objects.
 * Orchestrates the building steps using a BeautySetBuilder implementation
 * to create different variations of beauty sets.
 */
public class BeautySetDirector {
    private BeautySetBuilder builder;

    /**
     * Constructs a new BeautySetDirector without an initial builder.
     * Builder must be set using setBuilder() before construction.
     */
    public BeautySetDirector() {
        // Builder will be set later via setBuilder method
    }

    /**
     * Sets the builder implementation to use for constructing beauty sets.
     * @param builder the builder instance to use for set construction
     */
    public void setBuilder(BeautySetBuilder builder) {
        this.builder = builder;
    }

    /**
     * Constructs a complete beauty set with all available features.
     * Follows the standard construction sequence for full customization.
     * @return fully configured BeautySet with all components
     * @throws IllegalStateException if builder is not set before calling
     */
    public BeautySet constructBeautySet() {
        if (builder == null) {
            throw new IllegalStateException("Builder not set");
        }

        builder.buildSetName();
        builder.buildProducts();
        builder.buildGiftWrap();
        builder.buildPersonalCard();
        builder.buildBoxType();
        builder.buildOccasion();
        builder.buildDifficultyLevel();

        return builder.getBeautySet();
    }

    /**
     * Constructs a minimal beauty set with only essential components.
     * Suitable for quick setup or basic configurations.
     * @return BeautySet with core components (name, products, box type)
     * @throws IllegalStateException if builder is not set before calling
     */
    public BeautySet constructQuickBeautySet() {
        if (builder == null) {
            throw new IllegalStateException("Builder not set");
        }

        // Quick construction with only essential components
        builder.buildSetName();
        builder.buildProducts();
        builder.buildBoxType();

        return builder.getBeautySet();
    }

    /**
     * Constructs a customizable beauty set with selective gift features.
     * Allows fine-grained control over gift packaging options.
     * @param includeGiftWrap true to include gift wrap packaging
     * @param includePersonalCard true to include personalized card
     * @return customized BeautySet with selected gift features
     * @throws IllegalStateException if builder is not set before calling
     */
    public BeautySet constructCustomBeautySet(boolean includeGiftWrap, boolean includePersonalCard) {
        if (builder == null) {
            throw new IllegalStateException("Builder not set");
        }

        builder.buildSetName();
        builder.buildProducts();

        // Conditionally include gift features based on parameters
        if (includeGiftWrap) {
            builder.buildGiftWrap();
        }

        if (includePersonalCard) {
            builder.buildPersonalCard();
        }

        builder.buildBoxType();
        builder.buildOccasion();
        builder.buildDifficultyLevel();

        return builder.getBeautySet();
    }
}