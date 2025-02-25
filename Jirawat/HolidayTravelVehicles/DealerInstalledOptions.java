package Jirawat.HolidayTravelVehicles;
import java.util.ArrayList;

public class DealerInstalledOptions {
    private String optionCode;
    private String description;
    private double price;

    // Constructor
    public DealerInstalledOptions(String optionCode, String description, double price) {
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
    }

    // ฟังก์ชันดึงข้อมูลของ DealerInstalledOptions
    public void getOptionDetails() {
        System.out.println("Option Code: " + this.optionCode);
        System.out.println("Description: " + this.description);
        System.out.println("Price: $" + this.price);
    }

    // ฟังก์ชันอัปเดตรายละเอียดของตัวเลือก
    public void updateOptionDetails(String newDescription, double newPrice) {
        if (newDescription != null && !newDescription.isEmpty()) {
            this.description = newDescription;
        }
        if (newPrice > 0) {
            this.price = newPrice;
        }
        System.out.println("Option details updated successfully.");
    }

    // ฟังก์ชันเพิ่มตัวเลือกใหม่ลงในรายการ (สมมติว่าเป็น List ของตัวเลือก)
    public static void addNewOption(ArrayList<DealerInstalledOptions> optionsList, DealerInstalledOptions option) {
        optionsList.add(option);
        System.out.println("New option with code " + option.optionCode + " added successfully.");
    }

    // ฟังก์ชันดึงราคาของตัวเลือก
    public double getOptionPrice() {
        return this.price;
    }
}
