import java.util.*;

/**
 * Demonstrates usage of the Inventory Management System.
 * In a real application, you might have a more sophisticated UI or a web service layer.
 */
public class Main {
    public static void main(String[] args) {
        // Create some sample products
        Product laptop = new Product("Laptop", 1200.0, 20, 5);
        Product smartphone = new Product("Smartphone", 800.0, 10, 3);

        // Create product map for easy lookup
        Map<UUID, Product> productMap = new HashMap<>();
        productMap.put(laptop.getProductId(), laptop);
        productMap.put(smartphone.getProductId(), smartphone);

        // Display Products
        System.out.println(laptop);
        System.out.println("----------------------------");
        System.out.println(smartphone);
        System.out.println("----------------------------");

        // Gather user input for average daily sales
        // (For a simple demo, you might hard-code or just pass values.)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter average daily sales for " + laptop.getName() + ": ");
        int laptopSales = scanner.nextInt();

        System.out.print("Enter average daily sales for " + smartphone.getName() + ": ");
        int smartphoneSales = scanner.nextInt();

        // Predict stock depletion
        StockPredictor predictor = new StockPredictor();

        // For demonstration, build a map with product -> average daily sales
        Map<Product, Integer> salesMap = new HashMap<>();
        salesMap.put(laptop, laptopSales);
        salesMap.put(smartphone, smartphoneSales);

        // Generate predictions
        Map<Product, String> predictions = predictor.generatePredictions(salesMap);
        for (String predictionReport : predictions.values()) {
            System.out.println(predictionReport);
        }

        // Create OrderManager
        OrderManager orderManager = new OrderManager(productMap);

        // Place an order (multithreaded processing)
        try {
            System.out.println("Placing an order for 2 Laptops...");
            orderManager.placeOrder("John Doe", laptop.getProductId(), 2);
        } catch (Exception e) {
            System.err.println("Error placing order: " + e.getMessage());
        }

        // Place another order
        try {
            System.out.println("Placing an order for 1 Smartphone...");
            orderManager.placeOrder("Jane Smith", smartphone.getProductId(), 1);
        } catch (Exception e) {
            System.err.println("Error placing order: " + e.getMessage());
        }

        // In a real application, we'd keep the application alive until all orders are processed.
        // For the demo, wait a few seconds so threads can finish.
        try {
            Thread.sleep(5000); // Wait for background processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final shutdown
        orderManager.shutdown();
        scanner.close();

        System.out.println("=== All Orders ===");
        for (Order o : orderManager.getAllOrders()) {
            System.out.println(o);
            System.out.println("-------------------------");
        }
    }
}
