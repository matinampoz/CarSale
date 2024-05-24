public class NewCarSale extends Sale{
    public NewCarSale(String date, String manufacturer, double price) {
        super(date, manufacturer, price);
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
}
