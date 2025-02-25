package Jirawat.HolidayTravelVehicles;
import java.util.ArrayList;
import java.util.List;

class Salesperson {
    private String salespersonID;
    private String name;
    private String email;
    private String phoneNumber;

    public Salesperson(String salespersonID, String name, String email, String phoneNumber) {
        this.salespersonID = salespersonID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // ฟังก์ชันดึงข้อมูลของ Salesperson
    public void getSalespersonDetails() {
        System.out.println("Salesperson ID: " + this.salespersonID);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Phone Number: " + this.phoneNumber);
    }

    // ฟังก์ชันอัปเดตข้อมูลของ Salesperson
    public void updateSalespersonDetails(String name, String email, String phoneNumber) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
        System.out.println("Salesperson details updated successfully.");
    }

    // ฟังก์ชันมอบหมาย Salesperson ไปยังใบแจ้งหนี้ (สมมติว่า invoiceID เป็น parameter)
    public void assignToInvoice(String invoiceID) {
        System.out.println("Salesperson " + this.name + " has been assigned to Invoice ID: " + invoiceID);
    }
}
