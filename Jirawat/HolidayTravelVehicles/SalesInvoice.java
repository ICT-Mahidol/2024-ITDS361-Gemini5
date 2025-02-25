package Jirawat.HolidayTravelVehicles;
public class SalesInvoice {
    private String invoiceID;
    private double negotiatedPrice;
    private double tax;
    private double registrationFee;
    private double tradeInValue;
    private double dealerOptionsCost;

    public SalesInvoice(String invoiceID, double negotiatedPrice, double tax, double registrationFee) {
        this.invoiceID = invoiceID;
        this.negotiatedPrice = negotiatedPrice;
        this.tax = tax;
        this.registrationFee = registrationFee;
        this.tradeInValue = 0;
        this.dealerOptionsCost = 0;
    }

    public double calculateTotalPrice() {
        return (negotiatedPrice + tax + registrationFee + dealerOptionsCost) - tradeInValue;
    }

    public void generateInvoice() {
        System.out.println("Invoice ID: " + invoiceID);
        System.out.println("Negotiated Price: " + negotiatedPrice);
        System.out.println("Tax: " + tax);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("Trade-In Value: " + tradeInValue);
        System.out.println("Dealer Options Cost: " + dealerOptionsCost);
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    public void addTradeInVehicle(double tradeInValue) {
        this.tradeInValue = tradeInValue;
    }

    public void addDealerOptions(double dealerOptionsCost) {
        this.dealerOptionsCost = dealerOptionsCost;
    }

    public void getInvoiceDetails() {
        System.out.println("Invoice Details: ");
        generateInvoice();
    }
}
