public class CustomerInventory {
    private String customerID;
    private String name;
    private String address;
    private String phoneNumber;
    private CustomerSearch customerSearch;

    public CustomerInventory(String customerID, String name, String address, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerSearch = new CustomerSearch();
    }
}
