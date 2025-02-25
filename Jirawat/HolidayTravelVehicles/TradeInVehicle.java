package Jirawat.HolidayTravelVehicles;
import java.util.ArrayList;

public class TradeInVehicle {
    private String tradeInSerialNumber;
    private String make;
    private String model;
    private int year;
    private double tradeInAllowance;

    // สร้าง constructor
    public TradeInVehicle(String tradeInSerialNumber, String make, String model, int year, double tradeInAllowance) {
        this.tradeInSerialNumber = tradeInSerialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeInAllowance = tradeInAllowance;
    }

    // ฟังก์ชันดึงข้อมูลของ TradeInVehicle
    public void getTradeInVehicleDetails() {
        System.out.println("Trade-in Serial Number: " + this.tradeInSerialNumber);
        System.out.println("Make: " + this.make);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Trade-in Allowance: " + this.tradeInAllowance);
    }

    // ฟังก์ชันคำนวณ Trade-in Allowance ตามปีหรือเงื่อนไขอื่นๆ
    public double calculateAllowance() {
        // สมมติว่าให้ส่วนลดตามปีรถ
        int currentYear = 2025;
        int vehicleAge = currentYear - this.year;
        double allowanceDiscount = 0;

        if (vehicleAge > 10) {
            allowanceDiscount = 0.1 * this.tradeInAllowance; // ลด 10% ถ้าอายุมากกว่า 10 ปี
        }

        double finalAllowance = this.tradeInAllowance - allowanceDiscount;
        System.out.println("Calculated Allowance (after discount if applicable): " + finalAllowance);
        return finalAllowance;
    }

    // ฟังก์ชันเพิ่ม TradeInVehicle ลงในรายการ (สมมติว่าเป็น List ของรถยนต์ที่นำมาขายคืน)
    public static void addTradeInVehicle(ArrayList<TradeInVehicle> tradeInVehicles, TradeInVehicle vehicle) {
        tradeInVehicles.add(vehicle);
        System.out.println("Vehicle with Serial Number: " + vehicle.tradeInSerialNumber + " added successfully.");
    }

}
