package project;

/**
* Room is the class that sets up the Room Objects, these objects consist of a roomType, whether or not the resident 
* wants breakfast and the occupancy with regards to children and adults

* @author Brian Archbold
*/
public class Room{
	protected String roomType;
	protected boolean breakfast;
	protected int occupantsChild, occupantsAdults;
	/** Default Constructor
	 * Gives default values to the variables */
	public Room(){
		roomType = "";
		breakfast = true;
		occupantsChild = 0;
		occupantsAdults = 0; 
	}
	/** Constructor containing arguments
	 * These arguments are given to the variables for this class
	 * @param aRoomType residence type of room 
	 * @param aBreakfast True or false depending on whether to resident is having breakfast
	 * @param aOccupantsChild Shows how many children are staying in this room
	 * @param aOccupantsAdults Shows how many adults are staying in this room*/
	public Room(String aRoomType, boolean aBreakfast, int aOccupantsChild, int aOccupantsAdults){
		roomType = aRoomType;
		breakfast = aBreakfast;
		occupantsChild = aOccupantsChild;
		occupantsAdults = aOccupantsAdults;
	}
	/** Sets the type of room 
	 * @param aRoomType Takes in the room type*/
	public void setType(String aRoomType){
		roomType = aRoomType;
	}
	
	/** Sets the amount of children residing in the room
	 * @param aOccupantsChild Takes in the amount of children residing in a room */
	public void setChildOccupancy(int aOccupantsChild){
		occupantsChild = aOccupantsChild;
	}
	/** Sets the amount of Adults residing in the room 
	 * @param aOccupantsAdult Takes in the amount of adults residing in a room*/
	public void setAdultOccupancy(int aOccupantsAdult){
		occupantsAdults = aOccupantsAdult;
	}
	
	/** Sets whether or not if the resident wants Breakfast or not
	 * @param aBreakfast Takes in whether or not the resident wants breakfast or not  */
	public void setBreakfast(boolean aBreakfast){
		breakfast = aBreakfast;
	}
	
	/** 
	   *@return breakfast whether the chosen resident wants breakfast or not */
	public boolean getBreakfast(){
		return breakfast;
	}
	
	/** 
	   *@return occupantsChild how many children are staying in the room */
	public int getOccupancyChild(){
		return occupantsChild;
	}
	
	/**
	 *@return occupantsAdults how many adults are staying in the room */
	public int getOccupancyAdult(){
		return occupantsAdults;
	}
	
	/** 
	   *@return roomType the type of room that the resident will be residing in */
	public String getType(){
		return roomType;
	}
}
