package pharmacy;

import java.util.Date;

public class Purchase {
    private String buyer;
    private Date date;
    private double amount;

    public Purchase(String buyer, Date date, double amount) {
        this.buyer = buyer;
        this.date = date;
        this.amount = amount;
    }

    // Getters and Setters
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
