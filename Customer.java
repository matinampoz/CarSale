import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private List<Sale> sales;

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.sales = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }
}
