/**
 * Class representing a sale of a new car.
 */

public class NewCarSale extends Sale{

    public NewCarSale(Builder builder) {

        super(builder);
    }

    @Override
    public int getModelYear() {
        String[] parts = getDate().split("/");
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (month >= 10) {
            year++;
        }
        return year;
    }

    /**
     * Builder class for NewCarSale.
     */
    public static class Builder extends Sale.Builder<Builder> {

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public NewCarSale build() {
            return new NewCarSale(this);
        }
    }
}
