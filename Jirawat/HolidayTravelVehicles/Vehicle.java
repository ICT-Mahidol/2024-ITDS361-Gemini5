package Jirawat.HolidayTravelVehicles;
public class Vehicle {
    private String vehicleSerialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private double baseCost;

    public Vehicle(String vehicleSerialNumber, String name, String model, int year, String manufacturer, double baseCost) {
        this.vehicleSerialNumber = vehicleSerialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle: " + name + " (" + model + ", " + year + ") - Manufacturer: " + manufacturer + ", Cost: " + baseCost);
    }

    public void updateVehicleDetails(String name, String model, int year, String manufacturer, double baseCost) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public boolean isAvailableForSale() {
        return true;
    }

    public static void addNewVehicle() {
        System.out.println("New vehicle added.");
    }
}