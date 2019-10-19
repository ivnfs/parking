
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
		System.out.println("The " + Make + " " + Model + " has checked out in " + timeParking + " minutes");
	}
}
