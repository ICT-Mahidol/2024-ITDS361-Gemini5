package Jirawat.HolidayTravelVehicles;

import Jirawat.HolidayTravelVehicles.Customer;
import Jirawat.HolidayTravelVehicles.Vehicle;
import Jirawat.HolidayTravelVehicles.Salesperson;
import Jirawat.HolidayTravelVehicles.SalesInvoice;
import Jirawat.HolidayTravelVehicles.TradeInVehicle;
import Jirawat.HolidayTravelVehicles.DealerInstalledOptions;

public class Main {
    public static void main(String[] args) {
        // สร้างอ็อบเจ็กต์ต่างๆ
        Customer customer = new Customer("C001", "John Doe", "123 Elm Street", "555-1234");
        Vehicle vehicle = new Vehicle("V001", "Toyota Camry", "SE", 2022, "Toyota", 25000.0);
        Salesperson salesperson = new Salesperson("S001", "Jane Smith", "jane.smith@example.com", "555-5678");
        SalesInvoice invoice = new SalesInvoice("INV001", 24000.0, 1500.0, 200.0);
        TradeInVehicle tradeInVehicle = new TradeInVehicle("T001", "Honda", "Civic", 2018, 5000.0);
        DealerInstalledOptions option = new DealerInstalledOptions("O001", "Leather Seats", 1200.0);
        
        // แสดงข้อความเริ่มต้น
        System.out.println("Car Sales System Initialized with Sample Data");

        // แสดงรายละเอียดของ Customer
        System.out.println("\nCustomer Details:");
        customer.getCustomerDetails();

        // แสดงรายละเอียดของ Vehicle
        System.out.println("\nVehicle Details:");
        vehicle.getVehicleDetails();

        // แสดงรายละเอียดของ Salesperson
        System.out.println("\nSalesperson Details:");
        salesperson.getSalespersonDetails();

        // แสดงรายละเอียดของ SalesInvoice
        System.out.println("\nInvoice Details:");
        invoice.getInvoiceDetails();

        // แสดงรายละเอียดของ TradeInVehicle
        System.out.println("\nTrade-In Vehicle Details:");
        tradeInVehicle.getTradeInVehicleDetails();

        // แสดงรายละเอียดของ DealerInstalledOptions
        System.out.println("\nDealer Installed Option Details:");
        option.getOptionDetails();
    }
}
