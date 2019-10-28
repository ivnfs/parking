import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Parking {
	
	static int capacity = 3; //number of available parking spots, change if needed
	static int overflowCapacity = 3; //number of available over flow parking spots, change if needed
	static Car[] carArr = new Car[99]; //storage of customer car info and time
	
	public static Car[] removeIndex(Car[] c, int x) {//remove index from array
		if (c == null || x < 0 || x >= c.length) {//help on this function from geeksforgeeks.org
			return c;
		}
		Car[] temp = new Car[100];
		System.arraycopy(c, 0, temp, 0, x);
		System.arraycopy(c, x+1, temp, x, c.length - x - 1);
		return temp;
	}
	
	public static void waitPrint(int wait) {//prints wait line data
		if (wait == 0) {
			System.out.println("All vehicle(s) have successfully parked.");
		}
		if (wait > 0) {
			System.out.println("There is " + wait + " vehicle(s) waiting at the entrance gate for a parking spot to open.");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = null;
		int count = 0; //used for iteration with scanner
		int totalCars = 0; //total cars trying to enter
		int waitline = 0; //cars waiting to park
		int parked = 0; //cars that have parked
		int parked2 = 0; //cars that have parked in overflow
		try {
			scanner = new Scanner(new File("C:\\Users\\Ivan\\git\\parking\\Parking\\src\\input.txt"));//to test, add 2-5 between "input" and ".txt"
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {//read from input.txt
			String line = scanner.next();
			if (count == 0) {//takes in the make of car
				carArr[totalCars] = new Car();
				carArr[totalCars].CarMake(line);
				if (parked >= capacity) {//adds vehicles to overflow if lot 1 full
					if (parked2 >= overflowCapacity) {//adds vehicles to wait list if overflow full
						waitline++;
						carArr[totalCars].cWait(); //Lets Car class know status of car (waiting)
					}
					if (parked2 < overflowCapacity) {//parks in overflow parking lot if under capacity
						parked2++;
						carArr[totalCars].cParked2(); //Lets Car class know status of car (parked in overflow)
					}
				}
				if (parked < capacity) {//adds to parked if successfully parked
					parked++;
					carArr[totalCars].cParked(); //Lets Car class know status of car (parked)
				}
			}
			if (count == 1) {//takes in model of car
				carArr[totalCars].CarModel(line);
			}
			if (count == 2) {//takes in time of stay
				carArr[totalCars].CarTime(line);
				totalCars++; //when make, model, and time are entered, a car has been added
				for (int i=0; i<totalCars-1; i++) {//loops through all cars on file, if exact same entry, car leaves early
					if (carArr[totalCars-1].Make == carArr[i].Make & carArr[totalCars-1].Model == carArr[i].Model & carArr[totalCars-1].timeParking == carArr[i].timeParking) {
						System.out.println(carArr[totalCars-1].Make + " " + carArr[totalCars-1].Model + "has exited the lot early!");
						removeIndex(carArr, i); //removes original car from array
						removeIndex(carArr, totalCars-2); //removes new entry from array, -2 because array shifts after a removal
					}
				}
			}
			count++;
			if (count == 3) {//creates an iteration of 3, so data is taken in 3 parts, looped
				count = 0;
			}
		}

		for (int i=0; i<totalCars; i++) {//Prints each cars' info and status
			carArr[i].CarPrint();
		}
		
		
		waitPrint(waitline); //Prints wait line data
		
	}

}
