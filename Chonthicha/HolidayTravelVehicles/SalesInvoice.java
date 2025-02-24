// SalesInvoice.java
public class SalesInvoice {
    private String invoiceID;
    private String totalPrice;
    private String tax;
    private String registrationFee;
    private String finalPrice;

    public SalesInvoice(String invoiceID, String totalPrice, String tax, String registrationFee, String finalPrice) {
        this.invoiceID = invoiceID;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.registrationFee = registrationFee;
        this.finalPrice = finalPrice;
    }

    public void displayInfo() {
        System.out.println("Invoice ID: " + invoiceID);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Tax: " + tax);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("Final Price: " + finalPrice);
    }
}