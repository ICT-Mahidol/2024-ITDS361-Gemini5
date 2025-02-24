package minicase3_036.HolidayTravelVehicles;

import java.util.ArrayList;
import java.util.List;

public class SalesInvoice {
    private String invoiceID;
    private double finalPrice;
    private double tax;
    private double registrationFee;
    private String customerID;
    private String salespersonID;
    private Vehicle vehicle;
    private TradeInVehicle tradeInVehicle;
    private List<DealerInstalledOption> options;

    public SalesInvoice(String invoiceID, double finalPrice, double tax, double registrationFee, String customerID, String salespersonID, Vehicle vehicle) {
        this.invoiceID = invoiceID;
        this.finalPrice = finalPrice;
        this.tax = tax;
        this.registrationFee = registrationFee;
        this.customerID = customerID;
        this.salespersonID = salespersonID;
        this.vehicle = vehicle;
        this.options = new ArrayList<>();
    }

    public void addOption(DealerInstalledOption option) {
        options.add(option);
    }

    public void setTradeInVehicle(TradeInVehicle tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
    }

    public String getInvoiceID() { return invoiceID; }
    public double getFinalPrice() { return finalPrice; }
    public double getTax() { return tax; }
    public double getRegistrationFee() { return registrationFee; }
    public String getCustomerID() { return customerID; }
    public String getSalespersonID() { return salespersonID; }
    public Vehicle getVehicle() { return vehicle; }
    public TradeInVehicle getTradeInVehicle() { return tradeInVehicle; }
    public List<DealerInstalledOption> getOptions() { return options; }
}
