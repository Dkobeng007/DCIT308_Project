package pharmacy;

import java.util.*;

public class Pharmacy {
    // Class fields
    private final Map<String, Drug> drugInventory = new HashMap<>();
    private final List<Purchase> salesHistory = new ArrayList<>();

    // Add Drug
    public void addDrug(Drug drug) {
        drugInventory.put(drug.getDrugCode(), drug);
    }

    // Remove Drug
    public void removeDrug(String drugCode) {
        drugInventory.remove(drugCode);
    }

    // Search Drug
    public Drug searchDrug(String drugCode) {
        return drugInventory.get(drugCode);
    }

    // Add Purchase
    public void addPurchase(String drugCode, Purchase purchase) {
        Drug drug = drugInventory.get(drugCode);
        if (drug != null) {
            drug.getPurchaseHistory().add(purchase);
            salesHistory.add(purchase);
        }
    }

    // Sort Purchase History by Date
    public void sortPurchaseHistory(String drugCode) {
        Drug drug = drugInventory.get(drugCode);
        if (drug != null) {
            drug.getPurchaseHistory().sort(Comparator.comparing(Purchase::getDate));
        }
    }

    // Add Supplier
    public void addSupplier(String drugCode, Supplier supplier) {
        Drug drug = drugInventory.get(drugCode);
        if (drug != null) {
            drug.getSuppliers().add(supplier);
        }
    }

    // Generate report for drug inventory
    public String generateDrugInventoryReport() {
        StringBuilder report = new StringBuilder();
        report.append("Drug Inventory Report:\n");
        for (Drug drug : drugInventory.values()) {
            report.append("Drug Code: ").append(drug.getDrugCode())
                    .append(", Name: ").append(drug.getName())
                    .append(", Suppliers: ").append(drug.getSuppliers().size())
                    .append(", Purchase History: ").append(drug.getPurchaseHistory().size())
                    .append("\n");
        }
        return report.toString();
    }

    // Generate report for sales history
    public String generateSalesHistoryReport() {
        StringBuilder report = new StringBuilder();
        report.append("Sales History Report:\n");
        for (Purchase purchase : salesHistory) {
            report.append("Buyer: ").append(purchase.getBuyer())
                    .append(", Date: ").append(purchase.getDate())
                    .append(", Amount: ").append(purchase.getAmount())
                    .append("\n");
        }
        return report.toString();
    }
}
