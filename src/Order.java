import java.util.UUID;

/**
 * Represents a single order in the system, with fields for:
 *  - orderId
 *  - customerName
 *  - productId
 *  - quantity
 *  - orderStatus
 */
public class Order {
    private UUID orderId;
    private String customerName;
    private UUID productId;
    private int quantity;
    private OrderStatus orderStatus;

    public Order(String customerName, UUID productId, int quantity) {
        this.orderId = UUID.randomUUID();
        this.customerName = customerName;
        this.productId = productId;
        this.quantity = quantity;
        this.orderStatus = OrderStatus.PENDING;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId.toString() + "\n"
                + "Customer: " + customerName + "\n"
                + "Product ID: " + productId + "\n"
                + "Quantity: " + quantity + "\n"
                + "Order Status: " + orderStatus + "\n";
    }
}
