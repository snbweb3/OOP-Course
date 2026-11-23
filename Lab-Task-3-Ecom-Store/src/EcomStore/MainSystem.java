package EcomStore;

public class MainSystem {

	public static class WebsiteStats {
		static final String WEBSITENAME="EcomStore";
		
		public static void showReport() {
			System.out.println("Website: "+WEBSITENAME);
			System.out.println("Total Successful Orders: "+Order.totalOrders);
			System.out.println("Total Revenue: Rs. "+Order.totalRevenue);
			System.out.println("Average Order Value: Rs. "+Order.averageOrderValue());
			System.out.println("Sales Status: "+Order.getSalesStatus());
		}
	}

	public static void main(String[] args) {
		
		Product keyboard=new Product(11,"Keyboard","Computers",2500,12);
		Product bag=new Product(12,"School Bag","Fashion",4000,6);
		Product tablet=new Product(13,"Tablet","Electronics",30000,4);
		Product camera=new Product(14,"Camera","Electronics",60000,2);
		
		keyboard.displayProduct();
		bag.displayProduct();
		tablet.displayProduct();
		camera.displayProduct();
		
		Order order1=new Order(201,"Hamza","Islamabad","Easypaisa");
		Order order2=new Order(202,"Fatima","Multan","Cash on Delivery");
		Order order3=new Order(203,"Zain","Rawalpindi","Debit Card");
		Order order4=new Order(204,"Ayesha","Quetta","JazzCash");
		Order order5=new Order(205,"Danish","Islamabad","Debit Card");
		
		order1.placeOrder(keyboard,1);
		double bill2=order2.placeOrder(bag,2);
		order3.placeOrder(bag,4);
		order4.placeOrder(tablet,2);
		order5.placeOrder(camera,3);
		
		System.out.println("Customer "+order2.getCustomer()+" from "+order2.getCity()+" cancels order "+order2.getOrderId());
		order2.cancelOrder(bag,2,bill2);
		order2.cancelOrder(bag,0,bill2);
		
		System.out.println("Bag stock now: "+bag.stock);
		System.out.println("Total Orders: "+Order.totalOrders);
		System.out.println("Average Order Value: Rs. "+Order.averageOrderValue());
		System.out.println("Sales Status: "+Order.getSalesStatus());
		
		MainSystem.WebsiteStats.showReport();
	}

}
