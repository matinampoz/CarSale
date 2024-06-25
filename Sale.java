/**
 * Abstract class representing a generic sale.
 */

abstract public class Sale implements ICarSale{

    private final String date;
    private final String manufacturer;
    private final double price;

    /**
     * Abstract Builder class for building Sale objects.
     *
     * @param <T> the type of the Builder (for method chaining).
     */
    public static abstract class Builder<T extends Builder<T>> {
        private String date;
        private String manufacturer;
        private double price;

        public T manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return self();
        }

        public T price(double price) {
            this.price = price;
            return self();
        }

        public T date(String date) {
            this.date = date;
            return self();
        }

        protected abstract T self();

        public abstract Sale build();

    }

    public Sale(Builder builder) {
        this.date = builder.date;
        this.manufacturer = builder.manufacturer;
        this.price = builder.price;
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

    @Override
    public String toString() {
        return "Sale{" +
                "date='" + date + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
