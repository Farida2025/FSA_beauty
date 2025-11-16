package fsabeauty.builder;

import fsabeauty.factory.CosmeticProduct;

/**
 * Builder interface for constructing BeautySet objects step by step.
 * Defines the contract for creating different types of beauty sets
 * while allowing flexible customization of components.
 */
public interface BeautySetBuilder {
    /**
     * Builds and sets the name for the beauty set.
     * Implementation should define naming logic based on set type.
     */
    void buildSetName();

    /**
     * Builds and adds cosmetic products to the beauty set.
     * Implementation should define product selection and composition logic.
     */
    void buildProducts();

    /**
     * Configures gift wrap options for the beauty set.
     * Implementation should define default gift wrap preferences.
     */
    void buildGiftWrap();

    /**
     * Configures personal card inclusion for the beauty set.
     * Implementation should define personal card default settings.
     */
    void buildPersonalCard();

    /**
     * Builds and sets the box type for packaging.
     * Implementation should define appropriate packaging based on set type.
     */
    void buildBoxType();

    /**
     * Sets the occasion theme for the beauty set.
     * Implementation should define occasion-appropriate configurations.
     */
    void buildOccasion();

    /**
     * Sets the difficulty level based on target user skill.
     * Implementation should define complexity appropriate for intended audience.
     */
    void buildDifficultyLevel();

    /**
     * Returns the fully constructed BeautySet instance.
     * Should only be called after all build methods have been executed.
     * @return completed BeautySet instance with all configured components
     */
    BeautySet getBeautySet();
}