package ParkingManagementSystem;

public class ParkingSystem {

	static void parkvehicle(ParkingSlot[] slots,Vehicle vehicle) {
		for(int i=0;i<slots.length;i++) {
			if(slots[i].available) {
				slots[i].park(vehicle);
				return;
			}
		}
		System.out.println("Parking Full  "+vehicle.vehicleReg+" cannot be parked");
	}
	
	static void removevehicle(ParkingSlot[] slots,String regno,int exithour) {
		for(int i=0;i<slots.length;i++) {
			if(!slots[i].available && slots[i].vehicle.vehicleReg.equalsIgnoreCase(regno)) {
				slots[i].remove(exithour);
				return;
			}
		}
		System.out.println("Vehicle "+regno+" not found");
	}
	
	static void displayslots(ParkingSlot[] slots) {
		for(int i=0;i<slots.length;i++) {
			slots[i].display();
		}
	}
	
	static void countslots(ParkingSlot[] slots) {
		int availablecount=0,occupiedcount=0;
		for(int i=0;i<slots.length;i++) {
			if(slots[i].available) {
				availablecount++;
			}
			else {
				occupiedcount++;
			}
		}
		System.out.println("Available slots   "+availablecount);
		System.out.println("Occupied slots    "+occupiedcount);
	}

	public static void main(String[] args) {
		
		ParkingSlot[] slots=new ParkingSlot[3];
		for(int i=0;i<slots.length;i++) {
			slots[i]=new ParkingSlot(i+1);
		}
		
		Vehicle vehicle1=new Vehicle();
		Vehicle vehicle2=new Vehicle("AB 12","suv",12);
		Vehicle vehicle3=new Vehicle("LEB 456","Bike",9);
		Vehicle vehicle4=new Vehicle("RIK 789","Car",10);
		
		vehicle1.display();
		vehicle2.display();
		
		parkvehicle(slots,vehicle1);
		parkvehicle(slots,vehicle2);
		parkvehicle(slots,vehicle3);
		displayslots(slots);
		countslots(slots);
		
		parkvehicle(slots,vehicle4);
		
		removevehicle(slots,"AB 12",20);
		removevehicle(slots,"XYZ 000",15);
		displayslots(slots);
		countslots(slots);
		
		parkvehicle(slots,vehicle4);
		displayslots(slots);
		
		removevehicle(slots,"LEB 456",11);
		removevehicle(slots,"ABC 123",1);
		countslots(slots);
		
	}

}
