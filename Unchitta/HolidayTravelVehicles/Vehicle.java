package Unchitta.HolidayTravelVehicles;

public class Vehicle {
    private String serialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private double baseCost;

    public Vehicle(String serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    // public void updateBaseCost(double baseCost) {
    //     this.baseCost = baseCost;
    // }

    // ฟังก์ชันแสดงข้อมูลของ Vehicle โดยใช้ serialNumber
    public void displayVehicleInfo(String serialNumber) {
        if (this.serialNumber.equals(serialNumber)) {
            System.out.println("Vehicle Information:");
            System.out.println("Serial Number: " + this.serialNumber);
            System.out.println("Name: " + this.name);
            System.out.println("Model: " + this.model);
            System.out.println("Year: " + this.year);
            System.out.println("Manufacturer: " + this.manufacturer);
            System.out.println("Base Cost: $" + this.baseCost);
        } else {
            System.out.println("No vehicle found with Serial Number: " + serialNumber);
        }
    }

    // Getters and Setters
    // public String getSerialNumber() { return serialNumber; }
    // public String getName() { return name; }
    // public String getModel() { return model; }
    // public int getYear() { return year; }
    // public String getManufacturer() { return manufacturer; }
    // public double getBaseCost() { return baseCost; }
}

