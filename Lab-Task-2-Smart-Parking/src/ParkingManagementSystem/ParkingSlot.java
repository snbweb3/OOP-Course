package ParkingManagementSystem;

public class ParkingSlot {
int slotnumber;
Vehicle vehicle;
boolean available;

ParkingSlot(){
	slotnumber=0;
	vehicle=null;
	available=true;
	
}

ParkingSlot(int slotnumber){
	this.slotnumber=slotnumber;
	this.vehicle=null;
	this.available=true;
	
}

void park(Vehicle vehicle) {
	if(!available) {
		System.out.println("No Parking   "+slotnumber);
		return;
		
	}
	else {
	this.vehicle=vehicle;
	available=false;
	System.out.println(vehicle.vehicleReg+"  Parked in slot   "+slotnumber);
	}
}

double remove(int exithour) {
	double fee=vehicle.calculatefee(exithour);
	System.out.println(vehicle.vehicleReg+"  left from slot   "+slotnumber);
	System.out.println("Total fee  "+fee);
	vehicle=null;
	available=true;
	return fee;
}

void display() {
	if(available) {
		System.out.println("Slot "+slotnumber+"   Available");
	}
	else {
		System.out.println("Slot "+slotnumber+"   Occupied   "+vehicle.vehicleReg+"  "+vehicle.type);
	}
}
	
}
