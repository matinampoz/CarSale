public class UsedCarSale extends Sale {
    private int modelYear;
    private String conditionDescription;

    public UsedCarSale(String date, String manufacturer, double price, int modelYear, String conditionDescription) {
        super(date, manufacturer, price);
        this.modelYear = modelYear;
        this.conditionDescription = conditionDescription;
    }

    @Override
    public int getModelYear() {
        return modelYear;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }
}
