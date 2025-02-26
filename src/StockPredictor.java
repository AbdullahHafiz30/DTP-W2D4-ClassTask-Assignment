import java.util.HashMap;
import java.util.Map;

/**
 * Predicts when stock will run out based on average daily sales.
 * Suggests a restocking strategy.
 */
public class StockPredictor {

    /**
     * Predict how many days until the product's stock is depleted,
     * given an average daily sales number.
     */
    public int daysUntilStockOut(Product product, int averageDailySales) {
        if (averageDailySales <= 0) {
            return Integer.MAX_VALUE; // or throw an exception if invalid
        }
        return product.getStockLevel() / averageDailySales;
    }

    /**
     * Suggest a restocking strategy based on days until stock out.
     * Simple example:
     *  - If days < 3 -> "Urgent"
     *  - If days < 7 -> "Moderate"
     *  - Otherwise   -> "Low priority"
     */
    public String restockSuggestion(int daysUntilStockOut) {
        if (daysUntilStockOut < 3) {
            return "Urgent: Restock immediately.";
        } else if (daysUntilStockOut < 7) {
            return "Moderate: Consider restocking soon.";
        } else {
            return "Low Priority: Sufficient stock for now.";
        }
    }

    /**
     * Convenience method to generate predictions for multiple products.
     */
    public Map<Product, String> generatePredictions(Map<Product, Integer> productSalesMap) {
        Map<Product, String> predictions = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : productSalesMap.entrySet()) {
            Product product = entry.getKey();
            int avgDailySales = entry.getValue();
            int days = daysUntilStockOut(product, avgDailySales);
            String suggestion = restockSuggestion(days);

            String report = "Stock Prediction for " + product.getName() + ":\n"
                    + "Days until stock out: " + days + "\n"
                    + "Restock Suggestion: " + suggestion + "\n";
            predictions.put(product, report);
        }
        return predictions;
    }
}
