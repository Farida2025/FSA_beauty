package fsabeauty.observer;

public interface ProductSubject {
    // Register a new observer to receive product updates
    void registerObserver(CustomerObserver observer);

    // Remove an observer from receiving updates
    void removeObserver(CustomerObserver observer);

    // Notify all registered observers with a message
    void notifyObservers(String message);

    // Get formatted product information
    String getProductInfo();
}