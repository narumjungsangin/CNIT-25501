import java.util.List;
import java.util.ArrayList;

public class Order {
    private List<Product> products = new ArrayList<>();

    // Add a product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Calculate total price
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Get a summary of the order
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        for (Product product : products) {
            summary.append(product.getDescription()).append("\n");
        }
        summary.append("Total Price: ").append(getTotalPrice());
        return summary.toString();
    }
}
