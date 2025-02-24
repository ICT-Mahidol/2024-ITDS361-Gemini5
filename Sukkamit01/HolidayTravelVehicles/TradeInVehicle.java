package minicase3_036.HolidayTravelVehicles;

public class TradeInVehicle {
    private String serialNumber;
    private String make;
    private String model;
    private int year;
    private double tradeInAllowance;

    public TradeInVehicle(String serialNumber, String make, String model, int year, double tradeInAllowance) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeInAllowance = tradeInAllowance;
    }

    public String getSerialNumber() { return serialNumber; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getTradeInAllowance() { return tradeInAllowance; }
}
