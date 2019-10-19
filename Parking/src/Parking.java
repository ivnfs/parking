import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Parking {
	
	int capacity = 10;
	
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("C:\\Users\\Ivan\\git\\parking\\Parking\\src\\input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			String line = scanner.next();
			System.out.println(line);
		}
		

	}

}
