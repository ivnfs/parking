
public class Car {
	String Make;
	String Model;
	String timeParking;
	
	public void CarMake(String s) {
		this.Make = s;
	}
	public void CarModel(String s) {
		this.Model = s;
	}
	public void CarTime(String s) {
		this.timeParking = s;
	}
	public void CarPrint() {
		double price = Integer.parseInt(timeParking);
		price = price * 0.05;
		System.out.println("The " + Make + " " + Model + " has parked for a total of " + timeParking + " minutes.");
		System.out.println("The " + Make + " " + Model + " check out total is $" + price + ".");
	}
}
