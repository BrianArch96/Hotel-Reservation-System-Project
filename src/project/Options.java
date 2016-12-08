package project;
import java.util.*;

import java.io.*;

/**
* Options is the class where all methods regarding the options available 
* for the hotel are written and it also contains the methods for importing and exporting 
* data to the different csv files

* @author Brian Archbold
*/

public class Options {
	private static int reservationNumber = 0;
	private Scanner input;
	private ArrayList<Reservation> reservationArray;
	private ArrayList<RoomInfo> dataInfo;
	protected HashMap<String, ArrayList<RoomInfo>> hotelData;
	private ArrayList<String> keys, roomTypeArray;
	private String roomChoice, reservationChoice, purchaseType;
	private GregorianCalendar checkOut,checkIn, todayDate;
	private int nightsAvailable;
	private boolean processed;
	
	/** Creates a default constructor
	 * Uses this constructor to take in variables from the Options class to different classes */
	public Options(){
	dataInfo = new ArrayList<RoomInfo>();
	reservationArray = new ArrayList<Reservation>();
	input = new Scanner(System.in);
	hotelData = new HashMap<String, ArrayList<RoomInfo>>();
	processed = false;
	}
	
	/** Adds a reservation to the reservations list for l4Hotel
	 *@param List Takes in the reservations listed for the hotel*/
	public void addReservation(ArrayList<Reservation> List){
		reservationArray = List;
		checkIn = new GregorianCalendar();
		input = new Scanner(System.in);
		keys = new ArrayList<String>();
		ArrayList<Room> rooms = new ArrayList<Room>();
		roomTypeArray = new ArrayList<String>();
		boolean breakfast;
		todayDate = new GregorianCalendar();
		processed = false;
		boolean run = true;
		int breakfastCost = 7, nightsStaying = 0, occupantChild = 0, occupantAdult = 0, numberOfRooms = 0;
		double total = 0;
		String name = "";
		
		while(run){
			System.out.println("Hotel Types:");
			for(String key : hotelData.keySet()){
				System.out.println(key);
				keys.add(key);
			}	
			System.out.println("\nWhat type of hotel are you making a reservation for?");
			reservationChoice = input.nextLine();
			if(!keys.contains(reservationChoice)){
				System.out.println("Error, please enter a valid hotel Type\n");
				run = true;
			}
			else run = false;
		}
		
		run = true;
		
		while(run){
			if (reservationArray.size() == 0){
				reservationNumber = 0;
			}
			else reservationNumber = reservationArray.get(reservationArray.size() -1 ).getNumber() +1;
			System.out.println("What is your Reservation Name?");
			name = input.nextLine();
			name.trim();
			
			System.out.println("How many rooms would you like to book?");
			numberOfRooms = Integer.parseInt(input.nextLine());
			boolean wrongDate = true;
			while (wrongDate == true){
				System.out.println("What date would you like to book for?\n");
				System.out.println("Day of month: ");
				checkIn.set(GregorianCalendar.DATE, Integer.parseInt(input.nextLine()));
				System.out.println("Month[1-12].");
				checkIn.set(GregorianCalendar.MONTH, Integer.parseInt(input.nextLine())-1);
				System.out.println("Year: \n");
				checkIn.set(GregorianCalendar.YEAR,Integer.parseInt(input.nextLine()));
				if(checkIn.get(GregorianCalendar.YEAR) < todayDate.get(GregorianCalendar.YEAR)){
					if(checkIn.get(GregorianCalendar.MONTH)< todayDate.get(GregorianCalendar.MONTH)){
						if(checkIn.get(GregorianCalendar.DATE)< todayDate.get(GregorianCalendar.DATE)){
					System.out.println("Error invalid booking date\n");
					
						}
					}
					System.out.println("Error invalid booking date");
					wrongDate = true;
				}
				else wrongDate = false;
			}
			run = true;
			while(run){
				
			System.out.println("How many nights will you be staying with us?");
			nightsStaying = Integer.parseInt(input.nextLine());
			for (int a = 0; a < numberOfRooms; a++){
				System.out.println("Info for Room " + (a+1) + "\n");
				System.out.println("\n  Room Types  \t\t\t  Rates\t\t\t\t No. Available Rooms \t Mininum Occupancy \t Maximum Occupancy");
				System.out.println("\t         Mon / Tue / Wed / Thur / Fri / Sat / Sun \t\t\t\t   Child / Adult \t   Child / Adult");
				
			for(int i = 0; i < hotelData.get(reservationChoice).size();i++){
				roomTypeArray.add(hotelData.get(reservationChoice).get(i).getRoomType());
				System.out.println(hotelData.get(reservationChoice).get(i).getRoomType()  +"   " + hotelData.get(reservationChoice).get(i).getRates()[0] +
						" /" + hotelData.get(reservationChoice).get(i).getRates()[1] +" / " + hotelData.get(reservationChoice).get(i).getRates()[2] + " / " + hotelData.get(reservationChoice).get(i).getRates()[3] +
						" / "  + hotelData.get(reservationChoice).get(i).getRates()[4] +" / "+
						hotelData.get(reservationChoice).get(i).getRates()[5] +" / " + hotelData.get(reservationChoice).get(i).getRates()[6] + "\t "
						+ hotelData.get(reservationChoice).get(i).getNumberAvailable() + " rooms left\t\t     " + hotelData.get(reservationChoice).get(i).getMinChild()+ "\t    " + hotelData.get(reservationChoice).get(i).getMinAdult() +
						"\t\t      " +  hotelData.get(reservationChoice).get(i).getMaxChild() + "\t    " + hotelData.get(reservationChoice).get(i).getMaxAdult());
			}
			System.out.println("\nPlease select a room");
			roomChoice = input.nextLine();
			
			if (!roomTypeArray.contains(roomChoice)){
				System.out.println("Error, please enter a sufficient room type.");
				run = true;
			}	
			else run = false;
			//CHECKS IF THERE ARE ROOMS AVAILABLE FOR THE ROOM TYPE CHOSEN
			for(int i = 0; i< hotelData.get(reservationChoice).size();i++){
				if(hotelData.get(reservationChoice).get(i).getNumberAvailable() == 0){
					System.out.println("Error, We're out of " + roomChoice + " rooms");
					System.out.println("Please select another room");
					run = true;
				}			
			}
		
	
			
			System.out.println("Would you like breakfast?(£10)(Yes/No)");
			if(input.nextLine().equals("Yes")){
				total = (breakfastCost * nightsStaying);
				breakfast = true;	
			}
			else breakfast = false;
			boolean occupancyAcceptable =false;
			while (occupancyAcceptable == false){
				occupancyAcceptable = true;
			System.out.println("How many children will be staying in the room?");
			 occupantChild = Integer.parseInt(input.nextLine());
			
			
			System.out.println("How many adults will be staying in the room?");
			 occupantAdult = Integer.parseInt(input.nextLine());
			 for(int b = 0; b< hotelData.get(reservationChoice).size(); b++){
				 if (roomChoice.equals(hotelData.get(reservationChoice).get(b).getRoomType())){
					 if(occupantChild > hotelData.get(reservationChoice).get(b).getMaxChild() || occupantAdult > hotelData.get(reservationChoice).get(b).getMaxAdult()){
						 occupancyAcceptable = false;
					 }
					 else occupancyAcceptable = true;
				 } 
			 }
			 if (occupancyAcceptable == false)
				 System.out.println("Error, not a valid number of occupants, try again\n");
			}
		
			
			
			Room room = new Room(roomChoice, breakfast, occupantChild, occupantAdult);
			rooms.add(room);
		}
			}
		}
		
		for(int i = 0; i < hotelData.get(reservationChoice).size();i++){
			if(hotelData.get(reservationChoice).get(i).getRoomType().equals(roomChoice)){
				int nightsAvailable = hotelData.get(reservationChoice).get(i).getNumberAvailable();
				nightsAvailable--;
				hotelData.get(reservationChoice).get(i).setNumberAvailable(nightsAvailable);
				System.out.println("\n\nReservation Details");
			}
		}	
		System.out.println("Would you like to pay in Advanced(5% discount)[AP] or pay when you arrive[S]?");
		purchaseType = input.nextLine();
		
			for(int i = 0;i < hotelData.get(reservationChoice).size(); i++){
				int day = ((checkIn.get(GregorianCalendar.DAY_OF_WEEK))-1);
					for(int j = 0; j< rooms.size();j++){
						if(hotelData.get(reservationChoice).get(i).getRoomType().equals(rooms.get(j).getType())){
							for(int o = 0; o< nightsStaying; o++){
								total += hotelData.get(reservationChoice).get(i).getRates()[day];
								day++;
								if (day >6){
									day = 0;
								}
							}
						}
					}
			}
	
			
		if(purchaseType.equals("AP")){
			 total = ((total/100)*95);
				}	
		
		System.out.println("Your total comes to: " + total);
		boolean cancel = false;
		double deposit  = 0;
		if (purchaseType.equals("S")){
			System.out.println("Please enter the deposit you want");
			deposit = Double.parseDouble(input.nextLine());
			total = total - deposit;
		}
		
		
		String check = String.valueOf(checkIn.get(GregorianCalendar.DATE)) + "/" + String.valueOf(checkIn.get(GregorianCalendar.MONTH)+1) + "/" + String.valueOf(checkIn.get(GregorianCalendar.YEAR));
		
		Reservation reservation = new Reservation(reservationNumber, name, purchaseType,check, nightsStaying,numberOfRooms,rooms, total, deposit, cancel, processed);
		reservationArray.add(reservation);
	}
	/**  Cancels reservation that the user enters if it correlates with one on the reservation system  */
	public void CancelReservation(){
		boolean match = false;

		System.out.println("Please enter your Reservation Name");
		String reservationName = input.nextLine();
		for (int i = 0; i < reservationArray.size();i++){
			checkIn = reservationArray.get(i).getGregDate();
			
			if(reservationName.trim().equals(reservationArray.get(i).getName().trim()) && (reservationArray.get(i).getPurchaseType().equals("S")) && (((checkIn.get(GregorianCalendar.DAY_OF_YEAR) - todayDate.get(GregorianCalendar.DAY_OF_YEAR)) <= 2))){
				reservationArray.get(i).setCancel(true);
				//System.out.println(reservationArray.get(i).getRooms().size() + "size");
				System.out.println("You will be given a full refund as you cancelled within the right time-window");
				match = true;
				reservationArray.get(i).setCancel(true);
				processed = true;
			}

			else if (reservationName.equals(reservationArray.get(i).getName()) && (reservationArray.get(i).getPurchaseType().equals("S"))){
				System.out.println("Advanced Booking or Cancelation was made too late. You will not be given a refund.");
				reservationArray.get(i).setCancel(true);
				match = true;
				processed = true;
			}
			
			else if (reservationName.equals(reservationArray.get(i).getName()) && (reservationArray.get(i).getPurchaseType().equals("AP"))){
				reservationArray.get(i).setCancel(true);
				System.out.println("Advanced Bookings(AP) are non-refundable");
				match= true;
				processed = true;
			}

			reservationArray.get(i).setProcessed(processed);
		}	
		if (!match){
			System.out.println("Error, could not find " + reservationName + " in the System.");
		}
	}
	/** Handles when a person with a reservation would like to check in */
	public void HandleCheckIns(){
		todayDate = new GregorianCalendar();
		System.out.println("Enter the name your Reservation is under");
		String name = input.nextLine();
		for(int i= 0; i < reservationArray.size();i++){
			checkIn = reservationArray.get(i).getGregDate();
			
			if((name.trim().equals(reservationArray.get(i).getName().trim()) && (checkIn.get(GregorianCalendar.DAY_OF_YEAR) == todayDate.get(GregorianCalendar.DAY_OF_YEAR)))){
				processed = true;
				reservationArray.get(i).setProcessed(processed);
			}
			else 
				processed = false;
			reservationArray.get(i).setProcessed(processed);
		}
		if (processed == false){
			System.out.println("Error, name was not found on system or check-in date was incorrect");
			
		}
		else System.out.println("Thank you for using l4Hotels, we hope you enjoy your stay!");
	}
	/** Handles when a person with a reservation would like to check out of the hotel  */
	public void HandleCheckOuts(){
		checkOut = new GregorianCalendar();
		System.out.println("Enter your reservation Name please");
		String reservation = input.nextLine();
		boolean check = true;
		for(int i = 0; i < reservationArray.size();i++){
			if(reservation.equals(reservationArray.get(i).getName())){
				checkOut.set(GregorianCalendar.DATE, ((checkIn.get(GregorianCalendar.DATE) + reservationArray.get(i).getNightsStaying()))); 
				for(int j = 0; j<hotelData.get(reservationChoice).size();j++){
					for(int k = 0; k<reservationArray.get(i).getRooms().size();k++){
					if(reservationArray.get(i).getRooms().get(k).getType().equals(hotelData.get(reservationChoice).get(j).getRoomType()))
						hotelData.get(reservationChoice).get(j).setNumberAvailable(hotelData.get(reservationChoice).get(j).getNumberAvailable()+1);
						check = true;
					}		
				}
				reservationArray.remove(i);
			}
			else check = false;
		}
			if(check == true){
				System.out.println("We've hoped you've enjoyed your stay, please come visit us again");
			}
			else System.out.println("Error, could not find corresponding Reservation Name. ");
		
	}
	/** Allows the supervisor to initialize a discount to a reservation of his choice  */
	public void DiscountReservation(){
	System.out.println("Enter the name the customers reservation is under.");
	String name = input.nextLine();
	
	for(int i = 0; i < reservationArray.size(); i++){
		if (reservationArray.get(i).getName().equals(name)){
		System.out.println("Current total is: " + reservationArray.get(i).getTotal());
		System.out.println("Enter the discount(%) you want to apply to this customers account.");
		int discount = Integer.parseInt(input.nextLine());
		double total = ((reservationArray.get(i).getTotal()/100)*(100-discount));
		System.out.println(reservationArray.get(i).getName() + " 's new total is: " + (total));
		reservationArray.get(i).setTotal(total);
		}
	}
		
	}
	/** 
	   *@return hotelData.keySet returns the information from the l4hotel file  */
	public Set<String> grabInfo(){
		try{
		BufferedReader fileReader = new BufferedReader (new FileReader("l4Hotels.csv"));
		fileReader.readLine();
		fileReader.readLine();
		String fileLine;
		hotelData = new HashMap<String,ArrayList<RoomInfo>>();
		String currentHotelName = "";
		String hotelName = "";
		while ((fileLine = fileReader.readLine()) != null) {
			String [] data = fileLine.split(",", -1);
			hotelName = data[0];
			if(!hotelName.equals(""))
			currentHotelName = hotelName;
			String roomType = data[1];
			nightsAvailable = Integer.parseInt(data[2]);
			String[] dataOne = (data[3].split("\\+"));
			String[] dataTwo = (data[4].split("\\+"));
			int aOccupancyMaxChild = Integer.parseInt(dataTwo[1]);
			int aOccupancyMaxAdult = Integer.parseInt(dataTwo[0]);
			int aOccupancyMinChild = Integer.parseInt(dataOne[1]);
			int aOccupancyMinAdult = Integer.parseInt(dataOne[0]);
			
			double[] rates = new double[7];
			
			
			for(int i = 5; i < data.length; i++){ 
			rates[i-5] = Double.parseDouble(data[i]);
				//System.out.println(aRates[i-5]);	
				}
				RoomInfo info = new RoomInfo(roomType, nightsAvailable, aOccupancyMinChild, aOccupancyMinAdult, aOccupancyMaxChild, aOccupancyMaxAdult, rates);
				dataInfo.add(info);
				
				//for(int i = 0; i < dataInfo.size(); i++){
					//System.out.println(dataInfo.get(i).getRoomType());
				//}
				if(hotelData.get(currentHotelName) == null)
					hotelData.put(currentHotelName, new ArrayList<RoomInfo>());
				
					//Adds RoomInfo to the desired hotels ArrayList for RoomInfo
					hotelData.get(currentHotelName).add(info);	
			}
			fileReader.close();
			}
			catch (Exception ex){
			ex.printStackTrace();
		}
		return hotelData.keySet();

	}
	/** 
	   *@return reservationArray returns the information from the reservations file so that it may be used it by this program  */
	public ArrayList<Reservation> getReservationArray(){
		try{
			reservationArray = new ArrayList<Reservation>();
			BufferedReader read = new BufferedReader(new FileReader("Reservations.csv"));
			read.readLine();
			String file;
			while ((file = read.readLine()) != null){
				ArrayList<Room> roomz = new ArrayList<Room>();
				Room room = new Room();
				String []data = file.split(",",-1);
				int num = Integer.parseInt(data[0]);
				String name = data[1];
				String type = data[2];
				String checkIn = data[3];
				int nights = Integer.parseInt(data[4]);
				int numberOfRooms = Integer.parseInt(data[5]);
					room.setType(data[9]);
					room.setBreakfast(Boolean.parseBoolean(data[11]));
					String dataOne[] = data[10].split("\\+");
					room.setChildOccupancy(Integer.parseInt(dataOne[0]));
					room.setAdultOccupancy(Integer.parseInt(dataOne[1]));
				roomz.add(room);
				double total = Double.parseDouble(data[6]);
				double deposit = Double.parseDouble(data[7]);
				boolean cancel = Boolean.parseBoolean(data[8]);
				Reservation reservation = new Reservation(num,name, type, checkIn,nights,numberOfRooms, roomz, total, deposit, cancel, processed);
				reservationArray.add(reservation);
			}
			read.close();
		}	
		catch (Exception ex){
			System.out.println(ex);
			
		}
		return reservationArray;
	}
	/** Simply writes the contents of the reservation array (which includes previous entries and new) to the reservation file to be stored  */
	public void writeToFileReservation(){
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("Reservations.csv", false));	
			writer.write("Res Number");
			writer.write(",");
			writer.write("Res Name");
			writer.write(",");
			writer.write("Res Type");
			writer.write(",");
			writer.write("Check-In");
			writer.write(",");
			writer.write("Nights Staying");
			writer.write(",");
			writer.write("Number of Rooms");
			writer.write(",");
			writer.write("Total");
			writer.write(",");
			writer.write("Deposit");
			writer.write(",");
			writer.write("Cancelation");
			writer.write(",");
			writer.write("Room Type");
			writer.write(",");
			writer.write("Occupancy(Adult+Child");
			writer.write(",");
			writer.write("Breakfast");
			writer.write("\n");
			for(int i = 0; i< reservationArray.size();i++){
				writer.write(String.valueOf(reservationArray.get(i).getNumber()));
				writer.write(",");
				writer.write(reservationArray.get(i).getName());
				writer.write(",");
				writer.write(reservationArray.get(i).getPurchaseType());
				writer.write(",");
				writer.write(reservationArray.get(i).getDate());
				writer.write(",");
				writer.write(String.valueOf(reservationArray.get(i).getNightsStaying()));
				writer.write(",");
				writer.write(String.valueOf(reservationArray.get(i).getNumberOfRooms()));
				writer.write(",");
				writer.write(String.valueOf(reservationArray.get(i).getTotal()));
				writer.write(",");
				writer.write(String.valueOf(reservationArray.get(i).getDeposit()));
				writer.write(",");
				writer.write(String.valueOf(reservationArray.get(i).getCancel()));
					writer.write(",");
					writer.write((reservationArray.get(i).getRooms().get(0).getType()));
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getRooms().get(0).getOccupancyAdult()) + "+" + String.valueOf(reservationArray.get(i).getRooms().get(0).getOccupancyChild()));
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getRooms().get(0).getBreakfast()));
				writer.write("\n");
			}
			writer.close();
		}
		catch (IOException ex){
			System.out.println(ex);
		}
		
	}
	/** Simply updates the l4Hotels file, both incrementing and decrementing the number of rooms available depending on previous operations */
	public void writeToFilel4(){
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("l4hotels.csv"));
			writer.write("Hotel Type ");
			writer.write(",");
			writer.write("Room Type ");
			writer.write(",");
			writer.write("Number of Rooms");
			writer.write(",");
			writer.write("Occupancy-min");
			writer.write(",");
			writer.write("Occupancy-max");
			writer.write(",");
			writer.write("Rates");
			writer.write(",");
			writer.write(",");
			writer.write(",");
			writer.write(",");
			writer.write(",");
			writer.write(",");
			writer.write("\n");
			writer.write(",");
			writer.write(",");
			writer.write(",");
			writer.write("Adult+child");
			writer.write(",");
			writer.write("Adult+child");
			writer.write(",");
			writer.write("Mon");
			writer.write(",");
			writer.write("Tues");
			writer.write(",");
			writer.write("Wed");
			writer.write(",");
			writer.write("Thurs");
			writer.write(",");
			writer.write("Fri");
			writer.write(",");
			writer.write("Sat");
			writer.write(",");
			writer.write("Sun");
			writer.write("\n");
		
			for (String key: hotelData.keySet()){
				writer.write(key);
				writer.write(",");
				for (int i = 0; i < hotelData.get(key).size(); i++){
					if ( i != 0){
						writer.write(",");
					}
					writer.write(hotelData.get(key).get(i).getRoomType());
					writer.write(",");
					writer.write(String.valueOf(hotelData.get(key).get(i).getNumberAvailable()));
					writer.write(",");
					writer.write(String.valueOf(hotelData.get(key).get(i).getMinAdult()) + "+" + String.valueOf(hotelData.get(key).get(i).getMinChild()));
					writer.write(",");
					writer.write(String.valueOf(hotelData.get(key).get(i).getMaxAdult()) + "+" + String.valueOf(hotelData.get(key).get(i).getMaxChild()));
					for (int j = 0; j < hotelData.get(key).get(i).getRates().length; j++){
						writer.write(",");
						writer.write(String.valueOf(hotelData.get(key).get(i).getRates()[j]));	
					}
					writer.write("\n");
				}
				
			}
			writer.close();	
		}
		catch (IOException ex){
			System.out.println("Error");
		}
		
	}
	/** Simply writes the contents of the reservation array (which includes previous entries and new) to the StayInfomration file to be stored  */
	public void WriteToStayInfo(){
				try{
					PrintWriter writer = new PrintWriter(new FileWriter("StayInformation.csv"));
					writer.write("Res Number");
					writer.write(",");
					writer.write("Res Name");
					writer.write(",");
					writer.write("Res Type");
					writer.write(",");
					writer.write("Check-In");
					writer.write(",");
					writer.write("Nights Staying");
					writer.write(",");
					writer.write("Number of Rooms");
					writer.write(",");
					writer.write("Total");
					writer.write(",");
					writer.write("Deposit");
					writer.write(",");
					writer.write("Room Type");
					writer.write(",");
					writer.write("Occupancy(Adult+Child");
					writer.write(",");
					writer.write("Breakfast");
					writer.write("\n");
					for (int i = 0; i< reservationArray.size(); i++){
						System.out.println(reservationArray.get(i).getProcessed());
						if (reservationArray.get(i).getProcessed() == true){
						writer.write(String.valueOf(reservationArray.get(i).getNumber()));
						writer.write(",");
						writer.write(reservationArray.get(i).getName());
						writer.write(",");
						writer.write(reservationArray.get(i).getPurchaseType());
						writer.write(",");
						writer.write(reservationArray.get(i).getDate());
						writer.write(",");
						writer.write(String.valueOf(reservationArray.get(i).getNightsStaying()));
						writer.write(",");
						writer.write(String.valueOf(reservationArray.get(i).getNumberOfRooms()));
						writer.write(",");
						writer.write(String.valueOf(reservationArray.get(i).getTotal()));
						writer.write(",");
						writer.write(String.valueOf(reservationArray.get(i).getDeposit()));
						for (int j = 0; j < reservationArray.get(i).getRooms().size(); j++){
							writer.write(",");
							writer.write((reservationArray.get(i).getRooms().get(j).getType()));
							writer.write(",");
							writer.write(String.valueOf(reservationArray.get(i).getRooms().get(j).getOccupancyAdult()) + "+" + String.valueOf(reservationArray.get(i).getRooms().get(j).getOccupancyChild()));
							writer.write(",");
							writer.write(String.valueOf(reservationArray.get(i).getRooms().get(j).getBreakfast()));
						}
						writer.write("\n");
				}
				
					}
					writer.close();
				}
				catch (IOException ex){
					System.out.println(ex);
				}
	}
	/** Simply writes the contents of the reservation array (which includes previous entries and new) to the Cancellation file to be stored consisting of all cancelled reservations */
	public void WriteToCancelFile(){
			try{
				PrintWriter writer = new PrintWriter(new FileWriter("Cancelations.csv", false));	
				writer.write("Res Number");
				writer.write(",");
				writer.write("Res Name");
				writer.write(",");
				writer.write("Res Type");
				writer.write(",");
				writer.write("Check-In");
				writer.write(",");
				writer.write("Nights Staying");
				writer.write(",");
				writer.write("Number of Rooms");
				writer.write(",");
				writer.write("Total");
				writer.write(",");
				writer.write("Deposit");
				writer.write(",");
				writer.write("Cancelation");
				writer.write(",");
				writer.write("Room Type");
				writer.write(",");
				writer.write("Occupancy(Adult+Child");
				writer.write(",");
				writer.write("Breakfast");
				writer.write("\n");
				for(int i = 0; i< reservationArray.size();i++){
					if (reservationArray.get(i).getCancel() == true){
					writer.write(String.valueOf(reservationArray.get(i).getNumber()));
					writer.write(",");
					writer.write(reservationArray.get(i).getName());
					writer.write(",");
					writer.write(reservationArray.get(i).getPurchaseType());
					writer.write(",");
					writer.write(reservationArray.get(i).getDate());
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getNightsStaying()));
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getNumberOfRooms()));
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getTotal()));
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getDeposit()));
					writer.write(",");
					writer.write(String.valueOf(reservationArray.get(i).getCancel()));
					for (int j = 0; j < reservationArray.get(i).getRooms().size(); j++){
						writer.write(",");
						writer.write((reservationArray.get(i).getRooms().get(j).getType()));
						writer.write(",");
						writer.write(String.valueOf(reservationArray.get(i).getRooms().get(j).getOccupancyAdult()) + "+" + String.valueOf(reservationArray.get(i).getRooms().get(j).getOccupancyChild()));
						writer.write(",");
						writer.write(String.valueOf(reservationArray.get(i).getRooms().get(j).getBreakfast()));
					}
					writer.write("\n");
				}
				}
				writer.close();
			}
			catch (IOException ex){
				System.out.println("Error");
			}	
	}
	                      
}
