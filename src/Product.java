import java.util.UUID;

/**
 * Represents a product in the inventory system.
 * Includes basic fields such as productId, name, price, stockLevel, and reorderThreshold.
 */
public class Product {
    private UUID productId;
    private String name;
    private double price;
    private int stockLevel;
    private int reorderThreshold;

    public Product(String name, double price, int stockLevel, int reorderThreshold) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId.toString() + "\n"
                + "Name: " + name + "\n"
                + "Price: $" + price + "\n"
                + "Stock Level: " + stockLevel + "\n"
                + "Reorder Threshold: " + reorderThreshold + "\n";
    }
}
