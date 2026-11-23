package LabTask4;

public final class MainSystem {
    public static void main(String[] args) {
        Product chair = new Product(101, "Office Chair", 8000, 5);
        Electronics television = new Electronics(102, "LED TV", 65000, 4, 24);
        FlashPhone phone = new FlashPhone(103, "Samsung A55", 95000, 10, 12);

        chair.displayDetails();
        System.out.println();
        television.displayDetails();
        System.out.println();
        phone.displayDetails();
        System.out.println();

        System.out.println("Bill for 2 Office Chairs: Rs. " + chair.calculatePrice(2));
        System.out.println("Bill for 2 LED TVs: Rs. " + television.calculatePrice(2));
        System.out.println();

        phone.displayVouchers();
        System.out.println();

        phone.checkout(2, "MEGA10");
        System.out.println();
        phone.checkout(1, "MEGA10");
        System.out.println();
        phone.checkout(1, "DARAZ500");
        System.out.println();
        phone.checkout(1, "DARAZ500");
        System.out.println();
        phone.checkout(1, "DARAZ500");
        System.out.println();
        phone.checkout(1, "OLD500");
        System.out.println();
        phone.checkout(1, "INVALID");
        System.out.println();
        phone.checkout(3, "DARAZ500");
        System.out.println();

        phone.displayVouchers();
    }
}
