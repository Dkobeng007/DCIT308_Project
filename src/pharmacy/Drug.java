package pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private String drugCode;
    private String name;
    private List<Supplier> suppliers;
    private List<Purchase> purchaseHistory;

    public Drug(String drugCode, String name) {
        this.drugCode = drugCode;
        this.name = name;
        this.suppliers = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }
}
