public class Main {
    public static void main(String[] args) {
        VehicleInventory vehicle1 = new VehicleInventory("12345", "Tesla Model Y Long Range", "Model Y", 2024, "Tesla", 1769000.0);
        VehicleInventory vehicle2 = new VehicleInventory("67890", "Toyota Corolla Altis", "Corolla Altis", 2023, "Toyota", 894000.0);
        
        vehicle1.displayVehicleInfo();
        vehicle2.displayVehicleInfo();
    }
}
