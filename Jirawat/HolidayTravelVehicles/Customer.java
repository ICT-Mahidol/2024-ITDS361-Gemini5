package Jirawat.HolidayTravelVehicles;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(String customerID, String name, String address, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void getCustomerDetails() {
        System.out.println("Customer ID: " + customerID + ", Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber);
    }

    public void updateCustomerDetails(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static void addNewCustomer() {
        System.out.println("New customer added.");
    }
}