package minicase3_036.HolidayTravelVehicles;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("C001", "John Doe", "123 Main St", "098-1234567");

        Salesperson salesperson = new Salesperson("S001", "Jane Smith");

         
        Vehicle vehicle = new Vehicle("V001", "Toyota Corolla", "Sedan", "2023", "Toyota", 25000.00);

        SalesInvoice invoice = new SalesInvoice("INV001", 27000.00, 1500.00, 500.00, customer.getCustomerID(), salesperson.getEmployeeID(), vehicle);

        customer.addSalesInvoice(invoice);
        salesperson.addSalesInvoice(invoice);


        System.out.println("CustomerName: " + customer.getName());
        System.out.println("VehicleName: " + vehicle.getName() + " " + vehicle.getModel());
        System.out.println("FinalPrice: $" + invoice.getFinalPrice());
        System.out.println("SaleName: " + salesperson.getName());
    }
}

