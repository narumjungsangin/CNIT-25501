public class Pastry extends Product {
    private String flavor;
    private boolean isVegan;

    public Pastry(String name, double price, String flavor, boolean isVegan) {
        super(name, price);
        this.flavor = flavor;
        this.isVegan = isVegan;
    }

    // Additional getters and setters
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public String getDescription() {
        return getName() + " - " + getFlavor() + " - " + (isVegan ? "Vegan" : "Non-Vegan");
    }
}
