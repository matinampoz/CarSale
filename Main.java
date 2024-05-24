public class Main {
    public static void main(String[] args) {
        CustomerSalesDB db = new CustomerSalesDB();

        Customer individualCustomer = new Customer("Γεωργίου Νίκος", "Πλαστήρα 15", "2310467589");
        CorporateCustomer corporateCustomer = new CorporateCustomer("ideX A.S.", "Εγνατία 123", "2310290567", "Νικολάου Νίκος", "6972345674");

        db.newCustomer(individualCustomer);
        db.newCustomer(corporateCustomer);

        Sale newCarSale1 = new NewCarSale("10/08/2010", "Opel Astra 1.6", 19000.0);
        Sale usedCarSale1 = new UsedCarSale("15/05/2009", "Alfa Romeo 156 1.8 TS", 12000.0, 2000, "34.500 km., ηλεκτρικά παράθυρα, συναγερμός, κλιματισμός, CD");
        db.newSale(0, newCarSale1);
        db.newSale(0, usedCarSale1);

        Sale usedCarSale2 = new UsedCarSale("12/07/2011", "Jaguar Six 3.2 Sport", 43900.0, 1986, "44.830 km., κλιματισμός, αερόσακοι, ηλεκτρικά παράθυρα, συμπληρωμένο βιβλίο service.");
        Sale newCarSale2 = new NewCarSale("05/11/2010", "Audi A6 1.9TDi Avant", 25000.0);
        db.newSale(1, usedCarSale2);
        db.newSale(1, newCarSale2);

        // Εμφάνιση των στοιχείων των πελατών και των πωλήσεών τους
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
            for (Sale sale : db.getSales(i)) {
                System.out.println(sale.getDate() + " " + sale.getManufacturer() + ", " + sale.getPrice() + " Euro.");
                if (sale instanceof UsedCarSale) {
                    UsedCarSale usedCar = (UsedCarSale) sale;
                    System.out.println(usedCar.getConditionDescription());
                }
            }
            System.out.println("Συνολικό ποσό: " + db.getTotalSales(i));
            System.out.println("Μέσο έτος μοντέλου: " + db.getAverageAge(i));
        }
    }
}
