package pharmacy;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();

        // Adding a drug
        Drug drug1 = new Drug("D001", "Aspirin");
        pharmacy.addDrug(drug1);

        // Searching for a drug
        Drug searchResult = pharmacy.searchDrug("D001");
        if (searchResult != null) {
            System.out.println("Search Result: " + searchResult.getName());
        } else {
            System.out.println("Drug not found");
        }

        // Adding a supplier
        Supplier supplier1 = new Supplier("Supplier A", "New York");
        pharmacy.addSupplier("D001", supplier1);

        // Adding a purchase
        Purchase purchase1 = new Purchase("John Doe", new Date(), 15.0);
        pharmacy.addPurchase("D001", purchase1);

        // Sorting purchase history
        pharmacy.sortPurchaseHistory("D001");

        // Removing a drug
        pharmacy.removeDrug("D001");

        // Generate reports
        String drugReport = pharmacy.generateDrugInventoryReport();
        String salesReport = pharmacy.generateSalesHistoryReport();
        System.out.println(drugReport);
        System.out.println(salesReport);
    }
}
