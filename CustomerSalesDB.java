import java.util.ArrayList;
import java.util.List;

public class CustomerSalesDB {
    private List<Customer> customers;

    public CustomerSalesDB() {
        customers = new ArrayList<>();
    }

    public int getNoOfCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public List<Sale> getSales(int index) {
        return customers.get(index).getSales();
    }

    public double getTotalSales(int index) {
        double total = 0;
        for (Sale sale : getSales(index)) {
            total += sale.getPrice();
        }
        return total;
    }

    public double getAverageAge(int index) {
        int sum = 0;
        int count = 0;
        for (Sale sale : getSales(index)) {
            sum += sale.getModelYear();
            count++;
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public void newSale(int index, Sale sale) {
        customers.get(index).addSale(sale);
    }

    public void newCustomer(Customer customer) {
        customers.add(customer);
    }
}
