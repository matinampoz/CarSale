public class CorporateCustomer extends Customer {
    private String contactName;
    private String contactPhone;

    public CorporateCustomer(String name, String address, String phone, String contactName, String contactPhone) {
        super(name, address, phone);
        this.contactName = contactName;
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}
