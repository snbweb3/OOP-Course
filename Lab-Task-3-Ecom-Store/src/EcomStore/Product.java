package EcomStore;

public class Product {
	int id;
	String name;
	String category;
	double price;
	int stock;
	
	public Product(int id,String name,String category,double price,int stock){
		this.id=id;
		this.name=name;
		this.category=category;
		this.price=price;
		this.stock=stock;
	}
	
	void displayProduct() {
		System.out.println("Product ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Category: "+category);
		System.out.println("Price: Rs. "+price);
		System.out.println("Stock: "+stock);
	}
	
	boolean isAvailable(int quantity) {
		return quantity>0 && quantity<=stock;
	}

}
