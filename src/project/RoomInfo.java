package project;

/**
* RoomInfo contains and changes with regards to availability the data stored on the l4Hotels csv file.
* It is used to keep track of the room-types and their availability with regards to number of rooms.

* @author Brian Archbold
*/

public class RoomInfo {
	protected String roomType;
	protected int numberAvailable;
	protected int occupancyMinChild;
	protected int occupancyMinAdult;
	protected int occupancyMaxChild;
	protected int occupancyMaxAdult;
	protected double[] rates;
	
	/** No-Arg Constructor
	 * Gives default values to the variables for this class */
	public RoomInfo(){
		roomType = "";
		numberAvailable = 0;
		occupancyMinChild = 0;
		occupancyMinAdult = 0;
		occupancyMaxChild = 0;
		occupancyMaxAdult = 0;
		rates = new double[7];
	}
	/** A constructor containing arguments
	 * Assigns these arguments to the variables in this class, respectively
	 * @param aRoomType The type of room
	 * @param aNumberAvailable The number of rooms available for that specific room 
	 * @param aOccupancyMinChild The minimum amount of children for this room-type
	 * @param aOccupancyMinAdult The minimum amount of adults for this room-type
	 * @param aOccupancyMaxChild The maximum amount of children for this room-type
	 * @param aOccupancyMaxAdult The maximum amount of adults for this room-type
	 * @param aRates The rates associated with this room-type(Monday-Sunday), respectively*/
	public RoomInfo(String aRoomType, int aNumberAvailable, int aOccupancyMinChild, int aOccupancyMinAdult, int aOccupancyMaxChild, int aOccupancyMaxAdult, double[] aRates){
		roomType = aRoomType;
		numberAvailable = aNumberAvailable;
		occupancyMinChild = aOccupancyMinChild;
		occupancyMinAdult = aOccupancyMinAdult;
		occupancyMaxChild = aOccupancyMaxChild;
		occupancyMaxAdult = aOccupancyMaxAdult;
		rates = aRates;
	}
	
	/** Sets the type of room  
	 * @param aRoomType Takes in a room type value*/
	public void setRoomType(String aRoomType){
		roomType = aRoomType;
	}
	
	/**  Sets the number of rooms available for that specific room-type
	 *@param aNumberAvailable Takes in the number available for a specific room */
	public void setNumberAvailable(int aNumberAvailable){
		numberAvailable = aNumberAvailable;
	}
	
	/** Sets the maximum child residents allowed for that specific room-type
	 * @param aOccupanyMinChild Takes in a rooms minimum number of children allowed */
	public void setOccupancyMinChild(int aOccupanyMinChild){
		occupancyMinChild = aOccupanyMinChild;
	}
	
	/** Sets the maximum adult residents allowed for that specific room-type
	 * @param aOccupanyMaxAdult Takes in the maximum amount of adults allowed in a specific room*/
	public void setOccupancyMaxAdult(int aOccupanyMaxAdult){
		occupancyMaxAdult = aOccupanyMaxAdult;
	}
	
	/** Sets the rates(Monday-Sunday respectively) for specified room-type
	 * @param aRates Takes in the rates for a specific room-type (weekly)*/
	public void setRates(double[] aRates){
		rates = aRates;
	}
	/** 
	   *@return roomType returns the room-type  */
	public String getRoomType(){
		return roomType;
	}
	/** 
	   *@return numberAvailable the number of that room-type available */
	public int getNumberAvailable(){
		return numberAvailable;
	}
	
	/** 
	   *@return rates the rates(Monday-Sunday respectively) for specified room-type */
	public double[] getRates(){
		return rates;
	}
	
	/** 
	   *@return occupancyMinChild the minimum children allowed for that specific room-type  */
	public int getMinChild(){
		return occupancyMinChild;
	}
	
	/** 
	   *@return occupancyMinAdult the minimum adults allowed for that specific room-type*/
	public int getMinAdult(){
		return occupancyMinAdult;
	}
	
	/** 
	   *@return occupancyMaxChild the maximum children allowed for that specific room-type */
	public int getMaxChild(){
		return occupancyMaxChild;
	}
	/** 
	   *@return occupancyMazAdult the maximum adults allowed for that specific room-type */
	public int getMaxAdult(){
		return occupancyMaxAdult;
	}
}
