
public class Car {
	String Make;
	String Model;
	String timeParking;
	int isPark = 0;
	
	public void CarMake(String s) {
		this.Make = s;
	}
	public void CarModel(String s) {
		this.Model = s;
	}
	public void CarTime(String s) {
		this.timeParking = s;
	}
	public void cParked() {
		this.isPark = 1;
	}
	public void cWait() {
		this.isPark = 2;
	}
	
	public void CarPrint() {
		double price = Integer.parseInt(timeParking);
		price = price * 0.05;
		if (isPark == 1) {
			System.out.println("The " + Make + " " + Model + " has parked for a total of " + timeParking + " minutes.");
			System.out.println("The " + Make + " " + Model + " check out total is $" + price + ".");
			System.out.println();
		}
		if (isPark == 2) {
			System.out.println("The " + Make + " " + Model + " is waiting for a parking spot to open.");
			System.out.println();
		}
	}
}
