package minicase3_036.HolidayTravelVehicles;

import java.util.ArrayList;
import java.util.List;

public class Salesperson {
    private String employeeID;
    private String name;
    private List<SalesInvoice> salesInvoices;

    public Salesperson(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
        this.salesInvoices = new ArrayList<>();
    }

    public void addSalesInvoice(SalesInvoice invoice) {
        salesInvoices.add(invoice);
    }

    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public List<SalesInvoice> getSalesInvoices() { return salesInvoices; }
}
