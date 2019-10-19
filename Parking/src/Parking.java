import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Parking {
	
	static int capacity = 5;
	static Car[] carArr = new Car[99];
	
	public static void main(String[] args) {
		Scanner scanner = null;
		int count = 0; //used for iteration
		int totalCars = 0;
		int waitline = 0;
		int parked = 0;
		try {
			scanner = new Scanner(new File("C:\\Users\\Ivan\\git\\parking\\Parking\\src\\input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String line = scanner.next();
			if (count == 0) {
				//totalCars++;
				carArr[totalCars] = new Car();
				carArr[totalCars].CarMake(line);
				if (parked >= capacity) {
					waitline++;
					carArr[totalCars].cWait();
				}
				if (parked < capacity) {
					parked++;
					carArr[totalCars].cParked();
				}
			}
			if (count == 1) {
				carArr[totalCars].CarModel(line);
			}
			if (count == 2) {
				carArr[totalCars].CarTime(line);
				totalCars++;
			}
			//System.out.println(line);
			count++;
			if (count == 3) {
				count = 0;
			}
		}

		for (int i=0; i<totalCars; i++) {
			carArr[i].CarPrint();
		}
		System.out.println("There is " + waitline + " vehicle(s) waiting for a spot to open.");
	}

}
