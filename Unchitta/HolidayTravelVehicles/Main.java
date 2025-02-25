public class Main {
    public static void main(String[] args) {
        // สร้าง Vehicle object
        Vehicle myCar = new Vehicle("V12345", "Toyota Camry", "XLE", 2023, "Toyota", 30000.00);

        // เรียกใช้ฟังก์ชัน displayVehicleInfo() เพื่อแสดงข้อมูลของรถที่มี serialNumber ตรงกับที่ค้นหา
        myCar.displayVehicleInfo("V12345"); // ค้นหาเจอ
        myCar.displayVehicleInfo("V99999"); // ไม่พบ
    }
}
