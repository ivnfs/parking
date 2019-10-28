
public class Car {//stores Car data and functions
	String Make;
	String Model;
	String timeParking;
	int isPark = 0; //status to see if car is parked, waiting, or parked in overflow
	
	public void CarMake(String s) {//function to attach car make
		this.Make = s;
	}
	public void CarModel(String s) {//function to attach car model
		this.Model = s;
	}
	public void CarTime(String s) {//function to attach time staying
		this.timeParking = s;
	}
	public void cParked() {//keeps the individual status of car, so in this case parked = 1
		this.isPark = 1;
	}
	public void cWait() {//keeps the individual status of car, waiting = 2
		this.isPark = 2;
	}
	public void cParked2() {//keeps the individual status of car, overflow parked = 3
		this.isPark = 3;
	}
	
	
	public void CarPrint() {//prints out car info and time based on if they are parked / waiting
		double price = Integer.parseInt(timeParking);//switch from string to double
		double price1 = price * 0.05; //calculates price of stay, rate is 5 cents a minute for lot 1
		double price2 = price * 0.15; //calculates price of stay for overflow lot 2 rates
		if (isPark == 1) {//if car is successfully parked
			System.out.println("The " + Make + " " + Model + " is parking at lot 1 for a total of " + timeParking + " minutes.");
			System.out.println("The " + Make + " " + Model + " check out total is $" + price1 + " at standard rates.");
			System.out.println();
		}
		if (isPark == 2) {//if car is waiting
			System.out.println("The " + Make + " " + Model + " is still waiting at the entrance gate for a parking spot to open.");
			System.out.println();
		}
		if (isPark == 3) {//if parking at overflow at higher rate
			System.out.println("The " + Make + " " + Model + " is parking at overflow lot 2 for a total of " + timeParking +" minutes.");
			System.out.println("The " + Make + " " + Model + " check out total is $" + price2 + " at higher rates.");
			System.out.println();
		}
	}
}
