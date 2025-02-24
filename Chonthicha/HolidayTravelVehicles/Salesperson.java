// Salesperson.java
public class Salesperson {
    private String salespersonID;
    private String name;
    private String experience;

    public Salesperson(String salespersonID, String name, String experience) {
        this.salespersonID = salespersonID;
        this.name = name;
        this.experience = experience;
    }

    public void displayInfo() {
        System.out.println("Salesperson ID: " + salespersonID);
        System.out.println("Name: " + name);
        System.out.println("Experience: " + experience + " years");
    }
}