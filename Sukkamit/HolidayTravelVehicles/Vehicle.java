package minicase3_036.HolidayTravelVehicles;

public class Vehicle {
    private String serialNumber;
    private String name;
    private String model;
    private String year;
    private String manufacturer;
    private double baseCost;

    public Vehicle(String serialNumber, String name, String model, String year, String manufacturer, double baseCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public String getSerialNumber() { return serialNumber; }
    public String getName() { return name; }
    public String getModel() { return model; }
    public String getYear() { return year; }
    public String getManufacturer() { return manufacturer; }
    public double getBaseCost() { return baseCost; }
}
