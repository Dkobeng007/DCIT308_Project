package pharmacy;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class PharmacyApp extends JFrame {
    private final Pharmacy pharmacy;
    private final JTextArea reportArea;

    public PharmacyApp() {
        pharmacy = new Pharmacy();
        reportArea = new JTextArea(); // Initialize reportArea here
        initializeUI();
        setupInitialData();
    }

    private void initializeUI() {
        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create buttons
        JButton drugReportButton = new JButton("Generate Drug Inventory Report");
        JButton salesReportButton = new JButton("Generate Sales History Report");

        // Configure text area for displaying reports
        reportArea.setEditable(false);

        // Add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drugReportButton);
        buttonPanel.add(salesReportButton);

        // Add components to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // Add action listeners to buttons using lambdas
        drugReportButton.addActionListener(_ -> reportArea.setText(pharmacy.generateDrugInventoryReport()));
        salesReportButton.addActionListener(_ -> reportArea.setText(pharmacy.generateSalesHistoryReport()));
    }

    public static void main(String[] args) {
        // Show the UI using a lambda
        SwingUtilities.invokeLater(() -> {
            PharmacyApp app = new PharmacyApp();
            app.setVisible(true);
        });
    }

    private void setupInitialData() {
        // Adding some initial data for testing purposes
        Drug drug1 = new Drug("D001", "Aspirin");
        pharmacy.addDrug(drug1);

        Supplier supplier1 = new Supplier("Supplier A", "New York");
        pharmacy.addSupplier("D001", supplier1);

        Purchase purchase1 = new Purchase("John Doe", new Date(), 15.0);
        pharmacy.addPurchase("D001", purchase1);

        // You can add more data as needed
    }
}
