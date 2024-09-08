public class Drink extends Product {
    private String size; // e.g., small, medium, large
    private boolean isHot;

    public Drink(String name, double price, String size, boolean isHot) {
        super(name, price);
        this.size = size;
        this.isHot = isHot;
    }

    // Additional getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    @Override
    public String getDescription() {
        return getName() + " - " + getSize() + " - " + (isHot ? "Hot" : "Cold");
    }
}
