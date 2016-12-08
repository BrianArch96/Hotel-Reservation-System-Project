package project;
/**
* Test runs the entire System, containing the main method
* @author Brian Archbold
*/

public class Test {
	/** Runs the whole l4Hotels Program
	 * @param args Arguments for the main Method 
	 * @throws Exception Throws an exception*/
	public static void main(String[] args) throws Exception {
		ReservationMenu menu = new ReservationMenu();
		menu.run();
		
	}

}
