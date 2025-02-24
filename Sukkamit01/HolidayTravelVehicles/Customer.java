package minicase3_036.HolidayTravelVehicles;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phoneNumber;
    private List<SalesInvoice> salesInvoices;

    public Customer(String customerID, String name, String address, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salesInvoices = new ArrayList<>();
    }

    public void addSalesInvoice(SalesInvoice invoice) {
        salesInvoices.add(invoice);
    }

    public String getCustomerID() { return customerID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<SalesInvoice> getSalesInvoices() { return salesInvoices; }
}
