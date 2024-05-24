abstract public class Sale {
    private String date;
    private String manufacturer;
    private double price;

    public Sale(String date, String manufacturer, double price) {
        this.date = date;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public abstract int getModelYear();
}
