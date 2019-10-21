
public class Car {
	String Make;
	String Model;
	String timeParking;
	int isPark = 0;//status to see if car is parked or waiting
	
	public void CarMake(String s) {//function to attach car make
		this.Make = s;
	}
	public void CarModel(String s) {//function to attach car model
		this.Model = s;
	}
	public void CarTime(String s) {//function to attach time stayed
		this.timeParking = s;
	}
	public void cParked() {//keeps the individual status of car, so in this case parked = 1
		this.isPark = 1;
	}
	public void cWait() {//keeps the individual status of car, waiting = 2
		this.isPark = 2;
	}
	
	public void CarPrint() {//prints out car info and time based on if they are parked / waiting
		double price = Integer.parseInt(timeParking);//switch from string to double
		price = price * 0.05;//calculates price of stay, rate is 5 cents a minute
		if (isPark == 1) {//if car is successfully parked
			System.out.println("The " + Make + " " + Model + " has parked for a total of " + timeParking + " minutes.");
			System.out.println("The " + Make + " " + Model + " check out total is $" + price + ".");
			System.out.println();
		}
		if (isPark == 2) {//if car is waiting
			System.out.println("The " + Make + " " + Model + " is waiting for a parking spot to open.");
			System.out.println();
		}
	}
}
