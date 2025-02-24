// DealerInstalledOptions.java
public class DealerInstalledOptions {
    private String optionCode;
    private String description;
    private String price;

    public DealerInstalledOptions(String optionCode, String description, String price) {
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Option Code: " + optionCode);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
    }
}
