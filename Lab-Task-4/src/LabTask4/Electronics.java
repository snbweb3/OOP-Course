package LabTask4;

public class Electronics extends Product {
    protected int warrantyMonths;

    public Electronics(int id, String name, double price, int stock, int warrantyMonths) {
        super(id, name, price, stock);
        this.warrantyMonths = warrantyMonths;
    }

    public double calculatePrice(int qty) {
        double bill = super.calculatePrice(qty);
        if (bill == -1) {
            return -1;
        }
        if (qty >= 2) {
            bill = bill - bill * 0.05;
        }
        if (warrantyMonths == 24) {
            bill = bill + 400 * qty;
        }
        return bill;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}
