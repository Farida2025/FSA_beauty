package fsabeauty;

import fsabeauty.facade.FSAStore;

/**
 * Main class for the FSA Beauty Store application.
 * This class serves as the entry point for the application and demonstrates
 * the integration of all 6 design patterns in a cosmetics store context.
 */
public class Main {

    /**
     * Main method that initializes and runs the FSA Beauty Store application.
     */
    public static void main(String[] args) {
        System.out.println("  Welcome to FSA_Beauty!  ");
        System.out.println("Your Premium Cosmetics Brand\n");

        // Create the main store facade that coordinates all subsystems
        FSAStore store = new FSAStore();

        // Display store information and available features
        store.showStoreInfo();

        // Demonstrate each of the 6 design patterns individually with explanations
        store.demonstrateAllPatterns();

        // Run a complete integrated shopping scenario showing all patterns working together
        store.runCompleteDemoScenario();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  Thank you for visiting FSA_Beauty!");
        System.out.println("  Experience the power of design patterns!");
        System.out.println("=".repeat(50));
    }
}