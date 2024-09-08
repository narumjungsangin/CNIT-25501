import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Product> menuItems = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    public String listProducts() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            Product product = menuItems.get(i);
            list.append(i + 1).append(". ").append(product.getDescription()).append("\n");
        }
        return list.toString();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(menuItems); // Return a copy of the menu items
    }

    // Add a product to the menu
    public void addProduct(Product product) {
        menuItems.add(product);
        productMap.put(product.getName(), product);
    }

    // Remove a product from the menu
    public void removeProduct(String productName) {
        Product product = productMap.get(productName);
        if (product != null) {
            menuItems.remove(product);
            productMap.remove(productName);
        }
    }

    // Get a product by name
    public Product getProductByName(String name) {
        return productMap.get(name);
    }

    // Get a product by its number in the list
    public Product getProductByNumber(int number) {
        if (number >= 1 && number <= menuItems.size()) {
            return menuItems.get(number - 1); // -1 because list is 0-based index, but we're showing 1-based to the user
        }
        return null; // Or throw an exception, depending on how you want to handle invalid numbers
    }
}
