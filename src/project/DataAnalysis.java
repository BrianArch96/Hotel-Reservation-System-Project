package project;
import java.util.*;
import java.io.*;

public class DataAnalysis{
	private Scanner scan;
	private HashMap <String, ArrayList<RoomInfo>> map;
	private ArrayList<Reservation> reservations;
	private GregorianCalendar dateStart, dateEnd;
	private int totalOccupancy, totalMoney;
	

	public DataAnalysis(){
		scan = new Scanner(System.in);
		dateStart = new GregorianCalendar();
		dateEnd = new GregorianCalendar();
		totalOccupancy = 0;
		totalMoney = 0;
		map = new HashMap <String, ArrayList<RoomInfo>>();
		reservations = new ArrayList<Reservation>();
	}
	
	public DataAnalysis(HashMap<String ,ArrayList<RoomInfo>> map, ArrayList<Reservation> reservations){
		this.map = map;
		this.reservations = reservations;
		scan = new Scanner(System.in);
		dateStart = new GregorianCalendar();
		dateEnd = new GregorianCalendar();
		totalOccupancy = 0;
		totalMoney = 0;
		
	}
	public void run(){
		for (int i = 0; i < reservations.size(); i++){
		}
		System.out.println("D)ata Analysis");
		String choice = scan.nextLine();
		//DOES NOT WORK.
		if (choice.equals("D")){
		
		System.out.println("Enter the date you want to start your analysis from: ");
		System.out.println("Day: ");
		dateStart.set(GregorianCalendar.DATE, Integer.parseInt(scan.nextLine()));
		System.out.println("Month: ");
		dateStart.set(GregorianCalendar.MONTH, Integer.parseInt(scan.nextLine())-1);
		System.out.println("Year: ");
		dateStart.set(GregorianCalendar.YEAR, Integer.parseInt(scan.nextLine()));
		
		System.out.println("Enter the date you want to end your analysis from: ");
		System.out.println("Day: ");
		dateEnd.set(GregorianCalendar.DATE, Integer.parseInt(scan.nextLine()));
		System.out.println("Month: ");
		dateEnd.set(GregorianCalendar.MONTH, Integer.parseInt(scan.nextLine())-1);
		System.out.println("Year: ");
		dateEnd.set(GregorianCalendar.YEAR, Integer.parseInt(scan.nextLine()));
		
		for(String key: map.keySet()){
			System.out.println(key);
		}
		
		System.out.println("Please select your desired hotel for Data Analysis");
		String hotelChoice = scan.nextLine();
		
		System.out.println("What period of time would you to investigate?");
		System.out.println("M)onth, W)eek, D)ay, S)pecific Interval");
		String inputOne = scan.nextLine();
			
		
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("DataAnalysis.csv"));
			writer.write("RoomType");
			writer.write(",");
			writer.write("Child Occupancy");
			writer.write(",");
			writer.write("Total Money");
			writer.write("\n");
			
			for( int i = 0; i < reservations.size();i++){
				System.out.println(reservations.get(i).getRooms().get(0).getType());
			}
			

			if (inputOne.equals("M")){	
			for(String key: map.keySet()){
				if (hotelChoice.equals(key)){
					int array []= new int[map.get(key).size()];
					while (dateStart.get(GregorianCalendar.DAY_OF_YEAR)<= dateEnd.get(GregorianCalendar.DAY_OF_YEAR)){
					for(int i = 0; i < map.get(key).size(); i++){
					
						for(int j = 0; j < reservations.size(); j++){
							System.out.println(j);
							System.out.println(dateStart.get(GregorianCalendar.DAY_OF_YEAR));
							System.out.println(map.get(key).get(i).getRoomType());
							System.out.println(reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR));
							System.out.println(reservations.get(j).getRooms().get(0).getType());
							if(dateStart.get(GregorianCalendar.DAY_OF_YEAR) == reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR) &&(map.get(key).get(i).getRoomType().equals(reservations.get(j).getRooms().get(0).getType()))){
									int subtotal = reservations.get(j).getRooms().get(0).getOccupancyChild() + reservations.get(j).getRooms().get(0).getOccupancyAdult();
									array[i] = subtotal;
									System.out.println(array[i]);
									System.out.println("Hi");	
								}	
						}
						dateStart.add(GregorianCalendar.DAY_OF_YEAR,1);
						}
						
					}
					
					for(int o = 0; o < map.get(key).size();o++){
					//System.out.println(map.get(key).get(o).roomType);
						writer.write(map.get(key).get(o).roomType);
						writer.write(",");
						//System.out.println(array[o]);
						writer.write(array[o]);
						writer.write("\n");
					}
				}
			}
			}
				
			if (inputOne.equals("W")){
				for(String key: map.keySet()){
					if (hotelChoice.equals(key)){
						int array []= new int[map.get(key).size()];
						while (dateStart.get(GregorianCalendar.DAY_OF_YEAR)< dateEnd.get(GregorianCalendar.DAY_OF_YEAR)){
						for(int i = 0; i < map.get(key).size(); i++){
						
							for(int j = 0; j < reservations.size(); j++){
								System.out.println(j);
								System.out.println(dateStart.get(GregorianCalendar.DAY_OF_YEAR));
								System.out.println(reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR));
								System.out.println(map.get(key).get(i).getRoomType());
								System.out.println(reservations.get(j).getRooms().get(0).getType());
								if(dateStart.get(GregorianCalendar.DAY_OF_YEAR) == reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR) &&(map.get(key).get(i).getRoomType().equals(reservations.get(j).getRooms().get(0).getType()))){
										int subtotal = reservations.get(j).getRooms().get(0).getOccupancyChild() + reservations.get(j).getRooms().get(0).getOccupancyAdult();
										array[i] = subtotal;
										System.out.println(array[i]);
										System.out.println("Hi");	
									}	
							}
							}
							dateStart.add(GregorianCalendar.DAY_OF_YEAR,1);
						}
						
						for(int o = 0; o < map.get(key).size();o++){
						//System.out.println(map.get(key).get(o).roomType);
							writer.write(map.get(key).get(o).roomType);
							writer.write(",");
							//System.out.println(array[o]);
							writer.write(array[o]);
							writer.write("\n");
						}
					}
				}
				
			}
			else if (inputOne.equals("D")){
				for(String key: map.keySet()){
					if (hotelChoice.equals(key)){
						int array []= new int[map.get(key).size()];
						while (dateStart.get(GregorianCalendar.DAY_OF_YEAR)< dateEnd.get(GregorianCalendar.DAY_OF_YEAR)){
						for(int i = 0; i < map.get(key).size(); i++){
						
							for(int j = 0; j < reservations.size(); j++){
								System.out.println(j);
								System.out.println(dateStart.get(GregorianCalendar.DAY_OF_YEAR));
								System.out.println(reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR));
								System.out.println(map.get(key).get(i).getRoomType());
								System.out.println(reservations.get(j).getRooms().get(0).getType());
								if(dateStart.get(GregorianCalendar.DAY_OF_YEAR) == reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR) &&(map.get(key).get(i).getRoomType().equals(reservations.get(j).getRooms().get(0).getType()))){
										int subtotal = reservations.get(j).getRooms().get(0).getOccupancyChild() + reservations.get(j).getRooms().get(0).getOccupancyAdult();
										array[i] = subtotal;
										System.out.println(array[i]);
										System.out.println("Hi");	
									}	
							}
							}
							dateStart.add(GregorianCalendar.DAY_OF_YEAR,1);
						}
						
						for(int o = 0; o < map.get(key).size();o++){
						//System.out.println(map.get(key).get(o).roomType);
							writer.write(map.get(key).get(o).roomType);
							writer.write(",");
							//System.out.println(array[o]);
							writer.write(array[o]);
							writer.write("\n");
						}
					}
				}
				
			}
			else if (inputOne.equals("S")){
				for(String key: map.keySet()){
					if (hotelChoice.equals(key)){
						int array []= new int[map.get(key).size()];
						while (dateStart.get(GregorianCalendar.DAY_OF_YEAR)< dateEnd.get(GregorianCalendar.DAY_OF_YEAR)){
						for(int i = 0; i < map.get(key).size(); i++){
						
							for(int j = 0; j < reservations.size(); j++){
								System.out.println(j);
								System.out.println(dateStart.get(GregorianCalendar.DAY_OF_YEAR));
								System.out.println(reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR));
								System.out.println(map.get(key).get(i).getRoomType());
								System.out.println(reservations.get(j).getRooms().get(0).getType());
								if(dateStart.get(GregorianCalendar.DAY_OF_YEAR) == reservations.get(j).getGregDate().get(GregorianCalendar.DAY_OF_YEAR) &&(map.get(key).get(i).getRoomType().equals(reservations.get(j).getRooms().get(0).getType()))){
										int subtotal = reservations.get(j).getRooms().get(0).getOccupancyChild() + reservations.get(j).getRooms().get(0).getOccupancyAdult();
										array[i] = subtotal;
										System.out.println(array[i]);
										System.out.println("Hi");	
									}	
							}
							}
							dateStart.add(GregorianCalendar.DAY_OF_YEAR,1);
						}
						
						for(int o = 0; o < map.get(key).size();o++){
						//System.out.println(map.get(key).get(o).roomType);
							writer.write(map.get(key).get(o).roomType);
							writer.write(",");
							//System.out.println(array[o]);
							writer.write(array[o]);
							writer.write("\n");
						}
					}
				}
			}
			writer.flush();
			writer.close();
		}
		catch (IOException ex){
			System.out.println(ex);
		}
		}
	}
}
			
