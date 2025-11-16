package fsabeauty.observer;

public interface CustomerObserver {
    // Called when a new notification needs to be sent
    void update(String message);

    // Returns formatted customer information
    String getCustomerInfo();

    // Returns customer name for identification
    String getName();

    // Returns email for communication
    String getEmail();
}