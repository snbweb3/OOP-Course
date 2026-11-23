package EcomStore;

public class Order {
	int orderId;
	String customer;
	String city;
	String paymentMethod;
	
	static int totalOrders=0;
	static double totalRevenue=0;
	
	static final double DELIVERYCHARGE=500;
	static final double DISCOUNTRATE=0.1;
	static final double TAXRATE=0.2;
	
	Order(int orderId,String customer,String city,String paymentMethod){
		this.orderId=orderId;
		this.customer=customer;
		this.city=city;
		this.paymentMethod=paymentMethod;
	}
	
	double calculateSubtotal(Product p,int quantity) {
		if(quantity<=0 || quantity>p.stock) {
			System.out.println("Invalid Quantity");
			return 0;
		}
		else {
			return p.price*quantity;
		}
	}
	
	double calculateDiscount(double subtotal) {
		if(subtotal>=5000 && subtotal<=10000) {
			return subtotal*0.05;
		}
		else if(subtotal>=10000 && subtotal<=25000) {
			return subtotal*DISCOUNTRATE;
		}
		else if(subtotal>25000) {
			return subtotal*0.15;
		}
		else {
			return 0;
		}
	}
	
	static double calculateDelivery(double amount,String city) {
		double delivery;
		if(amount>=15000) {
			delivery=0;
		}
		else {
			delivery=DELIVERYCHARGE;
		}
		if(city.equalsIgnoreCase("Islamabad") || city.equalsIgnoreCase("Rawalpindi")) {
			return delivery;
		}
		else {
			return delivery+200;
		}
	}
	
	double calculateFinalBill(Product p,int quantity) {
		double subtotal=calculateSubtotal(p,quantity);
		double discount=calculateDiscount(subtotal);
		double afterDiscount=subtotal-discount;
		double delivery=calculateDelivery(afterDiscount,city);
		double tax=afterDiscount*TAXRATE;
		return afterDiscount+delivery+tax;
	}
	
	double placeOrder(Product p,int quantity) {
		double subtotal=calculateSubtotal(p,quantity);
		if(subtotal<=0) {
			System.out.println("Order rejected.");
			return 0;
		}
		double discount=calculateDiscount(subtotal);
		double afterDiscount=subtotal-discount;
		double delivery=calculateDelivery(afterDiscount,city);
		double tax=afterDiscount*TAXRATE;
		double finalBill=afterDiscount+delivery+tax;
		
		p.stock=p.stock-quantity;
		totalOrders++;
		totalRevenue=totalRevenue+finalBill;
		
		System.out.println("Order placed successfully.");
		System.out.println("Customer: "+customer+" ("+city+")");
		System.out.println("Payment Method: "+paymentMethod);
		System.out.println("Product: "+p.name+" x "+quantity);
		System.out.println("Subtotal: Rs. "+subtotal);
		System.out.println("Discount: Rs. "+discount);
		System.out.println("Delivery: Rs. "+delivery);
		System.out.println("Tax: Rs. "+tax);
		System.out.println("Final Bill: Rs. "+finalBill);
		System.out.println("Remaining stock: "+p.stock);
		return finalBill;
	}
	
	boolean cancelOrder(Product p,int quantity,double paidAmount) {
		if(quantity<=0 || paidAmount<=0) {
			System.out.println("Cancellation rejected, invalid quantity or amount.");
			return false;
		}
		else if(paidAmount>totalRevenue || totalOrders<=0) {
			System.out.println("Cancellation rejected, no sale found.");
			return false;
		}
		p.stock=p.stock+quantity;
		totalRevenue=totalRevenue-paidAmount;
		totalOrders--;
		System.out.println("Order "+orderId+" cancelled.");
		System.out.println("Refunded: Rs. "+paidAmount);
		System.out.println("Stock restored: "+p.stock);
		return true;
	}
	
	static double averageOrderValue() {
		if(totalOrders==0) {
			return 0;
		}
		return totalRevenue/totalOrders;
	}
	
	static String getSalesStatus() {
		if(totalRevenue>=300000) {
			return "Excellent";
		}
		else if(totalRevenue>=100000) {
			return "Good";
		}
		else {
			return "Low";
		}
	}
	
	int getOrderId() {
		return orderId;
	}
	
	String getCustomer() {
		return customer;
	}
	
	String getCity() {
		return city;
	}
	
	String getPaymentMethod() {
		return paymentMethod;
	}

}
