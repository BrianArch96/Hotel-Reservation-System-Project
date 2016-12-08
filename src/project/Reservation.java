package project;
import java.util.*;

/**
* Reservation is the class where the each reservation is made, it consists of various get and set methods
* which are used to instantiate and grab values and variables the reservation objects
* @author Brian Archbold
*/

public class Reservation {
	private int number;
	private String name;
	private String purchaseType;
	private int nightsStaying;
	private ArrayList<Room> rooms;
	private String checkIn;
	private double total;
	private double deposit;
	private int numberOfRooms;
	private GregorianCalendar check;
	private boolean cancel, processed;
	
	/** Default Constructor
	 * Used to construct/shell a reservation for the resident */
	public Reservation(){
		number = 0;
		name = "";
		purchaseType = "";
		nightsStaying = 0;
		checkIn = "";
		total = 0;
		deposit = 0;
		rooms = new ArrayList<Room>();
		numberOfRooms = 0;
		check = new GregorianCalendar();
		cancel = false;
		processed = false;
		
	}
	/** Constructor containing arguments
	 * This constructor takes in arguments 
	 * These arguments are then assigned to their variables, respectively
	 * @param aNumber The residence reservation number.
	 * @param aName The full name of the resident
	 * @param aPurchaseType The purchase type that the resident used to book his/her room
	 * @param aCheckIn The date at which they will be checking in.
	 * @param aNightsStaying The number of nights the residents will be staying at the hotel
	 * @param aNumberOfRooms The number of rooms the resident has booked at the hotel
	 * @param aRooms Contents concerning each room the resident has booked, includes the type of room, occupancy and choice of breakfast
	 * @param aTotal The sum of money the resident owes during his stay.
	 * @param aDeposit The deposit the resident has paid, only applies to Standard Bookings
	 * @param aCancel Whether or not the resident has cancelled or not
	 * @param aProcessed Whether or not the resident has been processed
	 * */
	public Reservation(int aNumber, String aName, String aPurchaseType, String aCheckIn,int aNightsStaying,int aNumberOfRooms, ArrayList<Room> aRooms,double aTotal, double aDeposit, boolean aCancel, boolean aProcessed){
		number = aNumber;
		name = aName;
		purchaseType = aPurchaseType;
		nightsStaying = aNightsStaying;
		checkIn = aCheckIn;
		total = aTotal;
		rooms = aRooms;
		check = new GregorianCalendar();
		numberOfRooms = aNumberOfRooms;
		cancel = aCancel;
		processed = aProcessed;
	}
	/** Gets whether the residence has been processed, (ie. checkedIn or cancelled)their reservation or not 
	 * @return processed true or false depending if resident has been processed*/
	public boolean getProcessed(){
		return processed;
	}
	/** sets whether the user has been processed or not
	 * @param aProcessed Takes in whether the user has been processed or not*/
	public void setProcessed(boolean aProcessed){
		processed = aProcessed;
	}
	/** Gets whether the resident has cancelled their reservation or not 
	 * @return true or false depending on whether or not the resident has cancelled reservation or not*/
	public boolean getCancel(){
		return cancel;
	}
	/** Sets whether the resident has cancelled their reservation or not 
	 * @param aCancel Takes in whether the resident has cancelled or not*/
	public void setCancel(boolean aCancel){
		cancel = aCancel;
	}
	/** 
	   *@return number the reservation number of the specified resident  */
	public int getNumber(){
		return number;
	}
	
	/** 
	   *@return name the reservation name of the specified resident  */
	public String getName(){
		return name;
	}
	
	/** 
	   *@return purchaseType the purchase-type of the specified resident  */
	public String getPurchaseType(){
		return purchaseType;
	}
	
	/** 
	   *@return nightsStaying  how many nights the specified resident is staying  */
	public int getNightsStaying(){
		return nightsStaying;
	}
	
	/** 
	   *@return numberOfRooms the number of rooms the specified resident is booking */
	public int getNumberOfRooms(){
		return numberOfRooms;
	}
	
	/** 
	   *@return rooms An array-list containing the room details for each room the specified resident has booked  */
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	/** 
	   *@return CheckInDate the check-in date of the specified resident  */
	public String getDate(){
		String []date = checkIn.split("/");
		check.set(GregorianCalendar.DATE, Integer.parseInt(date[0]));
		check.set(GregorianCalendar.MONTH, Integer.parseInt(date[1])-1);
		check.set(GregorianCalendar.YEAR, Integer.parseInt(date[2]));
		String CheckInDate = check.get(GregorianCalendar.DATE) + "/" + (check.get(GregorianCalendar.MONTH)+1) + "/" + check.get(GregorianCalendar.YEAR);
		return CheckInDate;
	}
	/** Gets the date for which the resident has booked their reservation for 
	 * @return check returns the date of reservation*/
	public GregorianCalendar getGregDate(){
		return check;
	}
	/** 
	   *@return total the amount that the resident owes to or has spent with l4hotels  */
	public double getTotal(){
		return total;
	}
	
	/** 
	   *@return deposit the deposit that the resident has made on their amount  */
	public double getDeposit(){
		return deposit;
	}
	
	/** sets the total money that the resident owes to l4hotels
	 * @param aTotal Takes in the total money owed */
	public void setTotal(double aTotal){
		total = aTotal;
	}
	
}
