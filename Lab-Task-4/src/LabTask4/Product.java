package LabTask4;

public class Product {
    private int id;
    protected String name;
    protected double price;
    protected int stock;
    public static final int MAX_QTY = 3;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public double calculatePrice(int qty) {
        if (qty <= 0 || qty > MAX_QTY || qty > stock) {
            return -1;
        }
        return price * qty;
    }

    public final boolean confirmSale(int qty) {
        if (qty <= 0 || qty > MAX_QTY || qty > stock) {
            return false;
        }
        stock = stock - qty;
        return true;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: Rs. " + price);
        System.out.println("Stock: " + stock);
    }
}
