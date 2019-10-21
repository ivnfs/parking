import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Parking {
	
	static int capacity = 5;//number of available parking spots
	static Car[] carArr = new Car[99];//storage of customer car info and time
	
	public static void main(String[] args) {
		Scanner scanner = null;
		int count = 0; //used for iteration with scanner
		int totalCars = 0;//total cars trying to enter
		int waitline = 0;//cars waiting to park
		int parked = 0;//cars that have parked
		try {
			scanner = new Scanner(new File("C:\\Users\\Ivan\\git\\parking\\Parking\\src\\input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {//read from input.txt
			String line = scanner.next();
			if (count == 0) {//takes in the make of car
				//totalCars++;
				carArr[totalCars] = new Car();
				carArr[totalCars].CarMake(line);
				if (parked >= capacity) {//adds to wait line if parking full
					waitline++;
					carArr[totalCars].cWait();//Lets Car class know status of car (waiting)
				}
				if (parked < capacity) {//adds to parked if successfully parked
					parked++;
					carArr[totalCars].cParked();//Lets Car class know status of car (parked)
				}
			}
			if (count == 1) {//takes in model of car
				carArr[totalCars].CarModel(line);
			}
			if (count == 2) {//takes in time of stay
				carArr[totalCars].CarTime(line);
				totalCars++;//when make, model, and time are entered, a car has been added
			}
			//System.out.println(line);
			count++;
			if (count == 3) {//creates an iteration of 3, so data is taken in 3 parts, looped
				count = 0;
			}
		}

		for (int i=0; i<totalCars; i++) {//Prints each cars' info and status
			carArr[i].CarPrint();
		}
		System.out.println("There is " + waitline + " vehicle(s) waiting for a spot to open.");
	}

}
