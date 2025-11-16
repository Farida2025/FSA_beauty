package fsabeauty.observer;

import java.util.ArrayList;
import java.util.List;

public class Customer implements CustomerObserver {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private List<String> notificationHistory;
    private boolean wantsEmailNotifications;
    private boolean wantsSMSNotifications;

    // Constructor with required fields
    public Customer(String customerId, String name, String email) {
        this(customerId, name, email, "Not provided");
    }

    // Full constructor with all customer details
    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.notificationHistory = new ArrayList<>();
        this.wantsEmailNotifications = true;
        this.wantsSMSNotifications = false;
    }

    @Override
    public void update(String message) {
        // Add notification to history
        notificationHistory.add(message);

        // Send notifications based on customer preferences
        if (wantsEmailNotifications) {
            sendEmailNotification(message);
        }

        if (wantsSMSNotifications && !phone.equals("Not provided")) {
            sendSMSNotification(message);
        }

        // Always display notification in console for demo purposes
        System.out.println("     [" + name + "] " + message);
    }

    private void sendEmailNotification(String message) {
        // Simulate email notification sending
        System.out.println("        Email to " + email + ": " + message);
    }

    private void sendSMSNotification(String message) {
        // Simulate SMS notification sending
        System.out.println("      SMS to " + phone + ": " + message);
    }

    @Override
    public String getCustomerInfo() {
        return String.format("%s (%s) - %s", name, email, phone);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    // Manage customer notification preferences
    public void setNotificationPreferences(boolean email, boolean sms) {
        this.wantsEmailNotifications = email;
        this.wantsSMSNotifications = sms;
        System.out.println( name + " notification preferences updated: Email=" + email + ", SMS=" + sms);
    }

    // Display all received notifications
    public void displayNotificationHistory() {
        System.out.println("\n📋 Notification History for " + name + ":");
        if (notificationHistory.isEmpty()) {
            System.out.println("   No notifications yet");
            return;
        }

        for (int i = 0; i < notificationHistory.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + notificationHistory.get(i));
        }
    }

    // Clear notification history
    public void clearNotificationHistory() {
        notificationHistory.clear();
        System.out.println("🗑️  Notification history cleared for " + name);
    }

    // Get total number of notifications received
    public int getNotificationCount() {
        return notificationHistory.size();
    }

    // Getters and setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isWantsEmailNotifications() {
        return wantsEmailNotifications;
    }

    public boolean isWantsSMSNotifications() {
        return wantsSMSNotifications;
    }

    public String getCustomerId() {
        return customerId;
    }
}