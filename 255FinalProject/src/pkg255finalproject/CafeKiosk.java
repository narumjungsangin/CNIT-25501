//CNIT 25501
//Junsu Yoon    - 0031408452
//Doyun Won   - 0033909003
//Won Chan (Alex) Lee - 0034027556
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CafeKiosk {
    public static void main(String[] args) {
        Menu menu = initializeMenu();
        JOptionPane.showMessageDialog(null, "Welcome to Cafe Kiosk");

        do {
            Order currentOrder = new Order();
            List<Product> allProducts = menu.getAllProducts(); // Assumes this method exists in Menu to return all products

            // Loop through all products for ordering
            for (Product product : allProducts) {
                String input = JOptionPane.showInputDialog(null, "Enter quantity for " + product.getName() + " ($" + product.getPrice() + " each):");
                if (input == null) { // User pressed "Cancel"
                    exitKiosk();
                    return; // Exit the program
                }

                int quantity;
                try {
                    quantity = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number. Skipping " + product.getName() + ".");
                    continue;
                }

                for (int q = 0; q < quantity; q++) {
                    currentOrder.addProduct(product);
                }
            }

            if (currentOrder.getTotalPrice() == 0) {
                JOptionPane.showMessageDialog(null, "No items selected. Exiting.");
                break;
            }

            // Show total and ask for payment method
            JOptionPane.showMessageDialog(null, "Your total is: $" + String.format("%.2f", currentOrder.getTotalPrice()));

            // Validate and process card number
            String cardNumber = getValidCardNumber(); // Get a valid card number from user
            if (cardNumber == null) return; // Exit if the card number input was canceled

            // Show receipt
            JOptionPane.showMessageDialog(null, "Payment successful with card ending in: "
                    + cardNumber.substring(cardNumber.length() - 4)
                    + "\n\nYour order:\n"
                    + currentOrder.getOrderSummary()
                    + "\nTotal: $" + String.format("%.2f", currentOrder.getTotalPrice()));

            // Ask if the user wants to make a new order
        } while (askForNewOrder());

        exitKiosk();
    }


    private static Menu initializeMenu() {
        Menu menu = new Menu();
        // Initialize menu with products...
        menu.addProduct(new Pastry("Croissant", 2.50, "Butter", false));
        menu.addProduct(new Pastry("Danish", 3.00, "Cherry", false));
        menu.addProduct(new Pastry("Muffin", 2.75, "Blueberry", false));
        menu.addProduct(new Pastry("Bagel", 1.50, "Plain", true));
        menu.addProduct(new Pastry("Scone", 2.25, "Chocolate Chip", true));

        // Adding 7 drinks to the menu
        menu.addProduct(new Drink("Espresso", 1.75, "Small", true));
        menu.addProduct(new Drink("Latte", 3.50, "Medium", true));
        menu.addProduct(new Drink("Cappuccino", 3.50, "Medium", true));
        menu.addProduct(new Drink("Iced Coffee", 2.50, "Large", false));
        menu.addProduct(new Drink("Iced Tea", 2.00, "Large", false));
        menu.addProduct(new Drink("Hot Chocolate", 2.75, "Medium", true));
        menu.addProduct(new Drink("Fruit Smoothie", 4.00, "Large", false));
        return menu;
    }

    // Method to validate the card number input
    public static boolean isValidCardNumber(String cardNumber) {
        Pattern pattern = Pattern.compile("\\d{16}");
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }
    private static String getValidCardNumber() {
        String cardNumber;
        while (true) {
            cardNumber = JOptionPane.showInputDialog("Enter your 16-digit card number for payment:");
            if (cardNumber == null || isValidCardNumber(cardNumber)) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Invalid card number. Please enter a 16-digit number.");
        }
        return cardNumber;
    }

    private static boolean askForNewOrder() {
        int reply = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "New Order", JOptionPane.YES_NO_OPTION);
        return reply == JOptionPane.YES_OPTION;
    }

    private static void exitKiosk() {
        JOptionPane.showMessageDialog(null, "Thank you for using Cafe Kiosk. Goodbye!");
    }
}
