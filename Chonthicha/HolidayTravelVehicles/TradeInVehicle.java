// TradeInVehicle.java
public class TradeInVehicle {
    private String serialNumber;
    private String make;
    private String model;
    private String year;

    public TradeInVehicle(String serialNumber, String make, String model, String year) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Trade-In Vehicle Serial Number: " + serialNumber);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}