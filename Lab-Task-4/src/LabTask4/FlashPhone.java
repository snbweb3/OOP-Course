package LabTask4;

public class FlashPhone extends Electronics {
    static String[] codes = {"DARAZ500", "MEGA10", "OLD500"};
    static double[] minimumBills = {10000, 25000, 10000};
    static double[] fixedDiscounts = {500, 0, 500};
    static double[] rates = {0, 10, 0};
    static double[] discountCaps = {500, 2000, 500};
    static int[] useLimits = {2, 1, 3};
    static int[] usedCounts = {0, 0, 0};
    static boolean[] expired = {false, false, true};

    public FlashPhone(int id, String name, double price, int stock, int warrantyMonths) {
        super(id, name, price, stock, warrantyMonths);
    }

    public double calculatePrice(int qty) {
        double bill = super.calculatePrice(qty);
        if (bill == -1) {
            return -1;
        }
        double extraDiscount = bill * 0.08;
        if (extraDiscount > 2500) {
            extraDiscount = 2500;
        }
        return bill - extraDiscount;
    }

    private int findVoucher(String code) {
        for (int i = 0; i < codes.length; i++) {
            if (codes[i].equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public void displayVouchers() {
        for (int i = 0; i < codes.length; i++) {
            String status;
            if (expired[i]) {
                status = "Expired";
            } else if (usedCounts[i] >= useLimits[i]) {
                status = "Limit reached";
            } else {
                status = "Active";
            }
            System.out.println(codes[i] + " Minimum Bill: Rs. " + minimumBills[i] + " Fixed Discount: Rs. " + fixedDiscounts[i] + " Rate: " + rates[i] + "% Cap: Rs. " + discountCaps[i] + " Limit: " + useLimits[i] + " Used: " + usedCounts[i] + " Remaining: " + (useLimits[i] - usedCounts[i]) + " Status: " + status);
        }
    }

    public double applyVoucher(double bill, String code) {
        int index = findVoucher(code);
        if (index == -1) {
            System.out.println("Voucher rejected: invalid code");
            return bill;
        } else if (expired[index]) {
            System.out.println("Voucher rejected: expired");
            return bill;
        } else if (usedCounts[index] >= useLimits[index]) {
            System.out.println("Voucher rejected: usage limit reached");
            return bill;
        } else if (bill < minimumBills[index]) {
            System.out.println("Voucher rejected: minimum bill not met");
            return bill;
        }
        double discount = fixedDiscounts[index] + bill * rates[index] / 100;
        if (discount > discountCaps[index]) {
            discount = discountCaps[index];
        }
        double newBill = bill - discount;
        if (newBill < 0) {
            newBill = 0;
        }
        return newBill;
    }

    public void checkout(int qty, String code) {
        double bill = calculatePrice(qty);
        if (bill == -1) {
            System.out.println("Order rejected for " + super.name + " quantity " + qty);
            System.out.println("Remaining Stock: " + stock);
            return;
        }
        double finalBill = applyVoucher(bill, code);
        double voucherDiscount = bill - finalBill;
        if (confirmSale(qty)) {
            if (voucherDiscount > 0) {
                usedCounts[findVoucher(code)]++;
            }
            System.out.println("Product: " + super.name);
            System.out.println("Quantity: " + qty);
            System.out.println("Voucher Discount: Rs. " + voucherDiscount);
            System.out.println("Final Bill: Rs. " + finalBill);
            System.out.println("Remaining Stock: " + stock);
        }
    }
}
