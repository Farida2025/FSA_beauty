package fsabeauty.observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements ProductSubject {
    private String productId;
    private String name;
    private String brand;
    private double price;
    private int stock;
    private boolean onSale;
    private double discountPercentage;
    private List<CustomerObserver> observers;

    // Constructor - initializes product with basic information
    public Product(String productId, String name, String brand, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.observers = new ArrayList<>();
        this.onSale = false;
        this.discountPercentage = 0.0;
    }

    // Update stock and notify observers about inventory changes
    public void setStock(int newStock) {
        int oldStock = this.stock;
        this.stock = newStock;

        // Notify when product comes back in stock
        if (oldStock == 0 && newStock > 0) {
            notifyObservers("🎉 Product '" + name + "' is back in stock! Only " + newStock + " items available.");
        }

        // Notify when stock is low
        if (newStock > 0 && newStock <= 3) {
            notifyObservers("  Low stock alert! '" + name + "' has only " + newStock + " items left.");
        }

        // Notify when out of stock
        if (oldStock > 0 && newStock == 0) {
            notifyObservers(" Sorry! '" + name + "' is now out of stock. We'll notify you when it's back.");
        }
    }

    // Update price and notify observers about price changes
    public void setPrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;

        // Notify about price drop
        if (newPrice < oldPrice) {
            double discount = ((oldPrice - newPrice) / oldPrice) * 100;
            this.discountPercentage = discount;
            notifyObservers(String.format("💰 Price drop! '%s' is now $%.2f (%.1f%% off)!",
                    name, newPrice, discount));
        }

        // Notify about price increase
        if (newPrice > oldPrice) {
            notifyObservers(String.format("📈 Price update: '%s' is now $%.2f", name, newPrice));
        }
    }

    // Set sale status and notify about special offers
    public void setOnSale(boolean onSale, double discountPercentage) {
        this.onSale = onSale;
        this.discountPercentage = discountPercentage;

        if (onSale) {
            double salePrice = price * (1 - discountPercentage / 100);
            notifyObservers(String.format("🔥 SALE! '%s' is now $%.2f (%.1f%% off)!",
                    name, salePrice, discountPercentage));
        }
    }

    // Announce new product features to observers
    public void addNewFeature(String feature) {
        notifyObservers("✨ New feature! '" + name + "' now includes: " + feature);
    }

    // Announce new product shades to observers
    public void restockWithNewShade(String shade) {
        notifyObservers("🎨 New shade available! '" + name + "' now comes in " + shade);
    }

    // Subject interface implementation - observer management
    @Override
    public void registerObserver(CustomerObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("👤 " + observer.getName() + " started watching " + name);
        }
    }

    @Override
    public void removeObserver(CustomerObserver observer) {
        observers.remove(observer);
        System.out.println( observer.getName() + " stopped watching " + name);
    }

    @Override
    public void notifyObservers(String message) {
        if (observers.isEmpty()) {
            return;
        }

        System.out.println("\n🔔 Notifying " + observers.size() + " observer(s) about: " + name);
        for (CustomerObserver observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public String getProductInfo() {
        return String.format("Product[ID: %s, Name: %s, Brand: %s, Price: $%.2f, Stock: %d, OnSale: %s]",
                productId, name, brand, price, stock, onSale);
    }

    // Getters for product properties
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public boolean isOnSale() { return onSale; }
    public double getDiscountPercentage() { return discountPercentage; }
    public int getObserverCount() { return observers.size(); }
    public List<CustomerObserver> getObservers() { return new ArrayList<>(observers); }

    // Display all customers watching this product
    public void displayObserverList() {
        if (observers.isEmpty()) {
            System.out.println("No observers watching " + name);
            return;
        }

        System.out.println("\n Observers watching " + name + ":");
        for (CustomerObserver observer : observers) {
            System.out.println("   • " + observer.getCustomerInfo());
        }
    }

    // Remove all observers from this product
    public void clearAllObservers() {
        System.out.println("🧹 Clearing all observers from " + name);
        observers.clear();
    }
}