import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerSalesDB db = new CustomerSalesDB();

        Customer individualCustomer = new Customer("Γεωργίου Νίκος", "Πλαστήρα 15", "2310467589");
        CorporateCustomer corporateCustomer = new CorporateCustomer("ideX A.S.", "Εγνατία 123", "2310290567", "Νικολάου Νίκος", "6972345674");

        db.newCustomer(individualCustomer);
        db.newCustomer(corporateCustomer);

        Sale newCarSale1 = new NewCarSale.Builder()
                .date("10/08/2010")
                .manufacturer("Opel Astra 1.6")
                .price(19000.0)
                .build();
        Sale usedCarSale1 = new UsedCarSale.Builder()
                .date("15/05/2009")
                .manufacturer("Alfa Romeo 156 1.8 TS")
                .price(12000.0)
                .modelYear(2000)
                .conditionDescription("34.500 km., ηλεκτρικά παράθυρα, συναγερμός, κλιματισμός, CD")
                .build();
        db.newSale(0, newCarSale1);
        db.newSale(0, usedCarSale1);

        Sale usedCarSale2 = new UsedCarSale.Builder()
                .date("12/07/2011")
                .manufacturer("Jaguar Six 3.2 Sport")
                .price(43900.0)
                .modelYear(1986)
                .conditionDescription("44.830 km., κλιματισμός, αερόσακοι, ηλεκτρικά παράθυρα, συμπληρωμένο βιβλίο service.")
                .build();
        Sale newCarSale2 = new NewCarSale.Builder()
                .date("05/11/2010")
                .manufacturer("Audi A6 1.9TDi Avant")
                .price(25000.0)
                .build();
        db.newSale(1, usedCarSale2);
        db.newSale(1, newCarSale2);

        // Display customer and sales details
        for (int i = 0; i < db.getNoOfCustomers(); i++) {
            Customer customer = db.getCustomer(i);
            System.out.println(customer.getName());
            System.out.println(customer.getAddress());
            System.out.println(customer.getPhone());
            if (customer instanceof CorporateCustomer) {
                CorporateCustomer corpCust = (CorporateCustomer) customer;
                System.out.println(corpCust.getContactName());
                System.out.println(corpCust.getContactPhone());
            }
            List<Sale> sales = db.getSales(i);
            for (Sale sale : sales) {
                System.out.println(sale.getDate() + " " + sale.getManufacturer() + ", " + sale.getPrice() + " Euro.");
                if (sale instanceof UsedCarSale usedCar) {
                    System.out.println(usedCar.getConditionDescription());
                }
            }
            System.out.println("Συνολικό ποσό: " + db.getTotalSales(i));
            System.out.println("Μέσο έτος μοντέλου: " + db.getAverageAge(i));
        }
    }
}
