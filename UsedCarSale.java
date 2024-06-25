/**
 * Class representing a sale of a used car.
 */

public class UsedCarSale extends Sale {

    private final int modelYear;
    private final String conditionDescription;

    public UsedCarSale(Builder builder) {
        super(builder);
        this.modelYear = builder.modelYear;
        this.conditionDescription = builder.conditionDescription;
    }

    @Override
    public int getModelYear() {
        return modelYear;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    @Override
    public String toString() {
        return "UsedCarSale{" + "date='" + getDate() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", price=" + getPrice() +
                "modelYear=" + modelYear +
                ", conditionDescription='" + conditionDescription + '\'' +
                '}';
    }

    /**
     * Builder class for UsedCarSale.
     */
    public static class Builder extends Sale.Builder<Builder> {
        private int modelYear;
        private String conditionDescription;

        public Builder modelYear(int modelYear) {
            this.modelYear = modelYear;
            return self();
        }

        public Builder conditionDescription(String conditionDescription) {
            this.conditionDescription = conditionDescription;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public UsedCarSale build() {
            return new UsedCarSale(this);
        }
    }
}
