package ParkingManagementSystem;

public class Vehicle {
	String vehicleReg;
	String type;
	double entrytime;
	
	Vehicle(){
		vehicleReg="ABC 123";
		type="Car";
		entrytime=0;
			
	}
	
	Vehicle(String vehicleReg,String type,double entrytime){
		this.vehicleReg=vehicleReg;
		this.type=type;
		this.entrytime=entrytime;
		
	}
	
	
	double calculatefee(int exithour) {
	double totalhours = exithour-entrytime;
	double firsthourfee = 0,extrahourfee = 0;
	
	if(type.equalsIgnoreCase("car")) {
		firsthourfee=100;
		extrahourfee=80;
		
	}
	else if(type.equalsIgnoreCase("SUV")){
		firsthourfee=150;
		extrahourfee=120;
	
	}
	else if (type.equalsIgnoreCase("Bike")) {
		firsthourfee=50;
		extrahourfee=30;
		
	}
	else {
		System.out.println("Invalid Type");
		
	}
	double totalfee = 0;
	if (totalhours<=0) {
		System.out.println("Invalid Duration");
		return 0;
	}
	else if(totalhours==1) {
		totalfee=firsthourfee;
	}
	else {
		totalfee=firsthourfee+(extrahourfee*(totalhours-1)) ;	
	}
	if(totalhours>5) {
		totalfee=totalfee-totalfee*0.1;
		
	}
	return totalfee;
	}
	
	void display() {
		System.out.println("Registration   "+vehicleReg);
		System.out.println("Vehicle type   "+type);
		System.out.println("Entry Time     "+entrytime);
	}


}
