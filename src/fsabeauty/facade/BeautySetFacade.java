package fsabeauty.facade;

import fsabeauty.builder.*;

/**
 * Facade class that provides a simplified interface for creating and managing beauty sets.
 * This class hides the complexity of the Builder pattern implementation and provides
 * easy-to-use methods for clients to create different types of beauty sets without
 * needing to understand the underlying construction process.
 */
public class BeautySetFacade {

    /**
     * The director that coordinates the beauty set construction process
     * This component manages the builder instances and controls the construction steps
     */
    private BeautySetDirector beautySetDirector;

    /**
     * Constructs a new BeautySetFacade with initialized BeautySetDirector
     * The facade creates and manages its own director instance to handle set construction
     */
    public BeautySetFacade() {
        this.beautySetDirector = new BeautySetDirector();
    }

    /**
     * Creates and displays a complete beauty set based on the specified type
     * This method handles the entire process of selecting the appropriate builder,
     * constructing the set through the director, and displaying the final result
     *
     * @param setType the type of beauty set to create ("beginner", "professional", or "gift")
     */
    public void createAndDisplayBeautySet(String setType) {
        System.out.println("\n🎁 CREATING BEAUTY SET: " + setType.toUpperCase());
        System.out.println("===============================");

        BeautySetBuilder builder;

        switch (setType.toLowerCase()) {
            case "beginner":
                builder = new BeginnerMakeupSetBuilder();
                break;
            case "professional":
                builder = new ProfessionalMakeupSetBuilder();
                break;
            case "gift":
                builder = new GiftSetBuilder();
                break;
            default:
                System.out.println("❌ Unknown set type: " + setType);
                return;
        }

        beautySetDirector.setBuilder(builder);
        BeautySet beautySet = beautySetDirector.constructBeautySet();

        System.out.println("\n✅ Beauty Set Created Successfully!");
        System.out.println(beautySet.getSetDescription());
    }

    /**
     * Demonstrates the creation of all available beauty set types
     * This method provides a comprehensive showcase of the Builder pattern
     * by creating and displaying beginner, professional, and gift sets,
     * followed by a demonstration of quick set construction
     */
    public void demonstrateAllBeautySets() {
        System.out.println("\n🏗️ BUILDER PATTERN - ALL BEAUTY SETS:");
        System.out.println("===================================");

        createAndDisplayBeautySet("beginner");
        createAndDisplayBeautySet("professional");
        createAndDisplayBeautySet("gift");
        demonstrateQuickSet();
    }

    /**
     * Demonstrates quick construction of a beauty set with minimal components
     * This method shows how the Builder pattern can be used to create simplified sets
     * by using the constructQuickBeautySet method that builds only essential components
     */
    private void demonstrateQuickSet() {
        System.out.println("\n⚡ QUICK SET CONSTRUCTION:");
        System.out.println("========================");

        BeautySetBuilder builder = new BeginnerMakeupSetBuilder();
        beautySetDirector.setBuilder(builder);
        BeautySet quickSet = beautySetDirector.constructQuickBeautySet();

        System.out.println("✅ Quick Set Created!");
        System.out.println(quickSet.getSetDescription());
    }

    /**
     * Creates a custom beauty set with specified parameters
     * This method demonstrates how the facade can be extended to handle custom configurations
     * while still leveraging the underlying Builder pattern infrastructure
     *
     * @param setName the custom name for the beauty set
     * @param products array of product names to include in the set
     * @param giftWrap whether to include gift wrapping service
     * @param personalCard whether to include a personal card with the set
     */
    public void createCustomBeautySet(String setName, String[] products, boolean giftWrap, boolean personalCard) {
        System.out.println("\n🎨 CREATING CUSTOM BEAUTY SET: " + setName);
        System.out.println("=================================");

        BeautySetBuilder builder = new GiftSetBuilder();
        beautySetDirector.setBuilder(builder);
        BeautySet customSet = beautySetDirector.constructBeautySet();

        System.out.println("✅ Custom Beauty Set Created!");
        System.out.println("Set Name: " + setName);
        System.out.println("Products: " + String.join(", ", products));
        System.out.println("Gift Wrap: " + (giftWrap ? "Yes" : "No"));
        System.out.println("Personal Card: " + (personalCard ? "Yes" : "No"));
        System.out.println(customSet.getSetDescription());
    }
}