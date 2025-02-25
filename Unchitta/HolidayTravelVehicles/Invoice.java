package Unchitta.HolidayTravelVehicles;

import java.util.List;

public class Invoice {
    private String invoiceID;
    private Customer customer;
    private Salesperson salesperson;
    private Vehicle vehicle;
    private TradeInVehicle tradeInVehicle;
    private double tradeInAllowance;
    private List<DealerInstalledOptions> dealerOptions;
    private double negotiatedPrice;
    private double tax;
    private double totalPrice;

    // public Invoice(String invoiceID, Customer customer, Salesperson salesperson, Vehicle vehicle,
    //                TradeInVehicle tradeInVehicle, double tradeInAllowance, List<DealerInstalledOptions> dealerOptions,
    //                double negotiatedPrice, double tax) {
    //     this.invoiceID = invoiceID;
    //     this.customer = customer;
    //     this.salesperson = salesperson;
    //     this.vehicle = vehicle;
    //     this.tradeInVehicle = tradeInVehicle;
    //     this.tradeInAllowance = tradeInAllowance;
    //     this.dealerOptions = dealerOptions;
    //     this.negotiatedPrice = negotiatedPrice;
    //     this.tax = tax;
    //     calculateTotalPrice();
    // }

    // public void addDealerOption(DealerInstalledOptions option) {
    //     dealerOptions.add(option);
    //     calculateTotalPrice();
    // }

    // public void applyTradeInDiscount() {
    //     this.negotiatedPrice -= tradeInAllowance;
    //     calculateTotalPrice();
    // }

    // public void calculateTotalPrice() {
    //     double optionsTotal = dealerOptions.stream().mapToDouble(DealerInstalledOptions::getPrice).sum();
    //     this.totalPrice = negotiatedPrice + optionsTotal + tax;
    // }

    // public void generateInvoice() {
    //     System.out.println("Invoice generated for: " + customer.getName());
    // }

    // Getters and Setters
}
