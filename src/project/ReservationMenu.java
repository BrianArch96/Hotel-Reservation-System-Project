package project;
import java.util.*;

/**
* ReservationMenu is the class the runs the menu for the l4Hotels System. 

* @author Brian Archbold
*/

public class ReservationMenu {
	private Scanner scan;
	private Options options;
	private String sPass;
	private String lPass;
	
	/** Default Constructor
	 * Used to shell the menu.
	 * Fills out things such as the passwords for the hotel staff .
	 * Initializes both the scanner and the options objects */
	public ReservationMenu(){
		scan = new Scanner(System.in);;
		options = new Options();
		sPass = "Super";
		lPass = "Lower";
		
	}
	/** Sets up and establishes the menu for the l4hotel Hotel System  */
	public void run(){
		boolean run = true;
		options.grabInfo();
		options.writeToFilel4();
		options.getReservationArray();
	
		while (run){
		System.out.println("\n");
		System.out.println("Welcome to l4Hotels; we hope you enjoy your stay!");
		System.out.println("Please select one of the following Options.");
		System.out.println("C)ustomer, H).D.K, S)upervisor, Q)uit");
		String input = scan.nextLine().toUpperCase();
		
			if (input.equals("C")){
				//takes in l4hotels info

				System.out.println("A)dd Reservation");
				System.out.println("C)ancel Reservation");
				String secondaryInput = scan.nextLine().toUpperCase();
					if(secondaryInput.equals("A")){
						options.addReservation(options.getReservationArray());
						options.writeToFileReservation();
						options.writeToFilel4();
						
					}
					else if(secondaryInput.equals("C")){
						options.CancelReservation();
						options.writeToFileReservation();
						options.writeToFilel4();
						options.WriteToCancelFile();
						
					}
			}
			else if (input.equals("H")){
				System.out.println("Enter password for H.D.K authority");
				String attempt = scan.nextLine();
				if(attempt.equals(lPass)){
					System.out.println("A)dd Reservation");
					System.out.println("C)ancel Reservation");
					System.out.println("H)andle Check Ins/Outs");
					String secondaryInput = scan.nextLine().toUpperCase();
						if(secondaryInput.equals("A")){
							options.addReservation(options.getReservationArray());
							options.writeToFileReservation();
							options.writeToFilel4();
							
							
						}
						else if(secondaryInput.equals("C")){
							options.CancelReservation();
							options.writeToFileReservation();
							options.writeToFilel4();
							options.WriteToCancelFile();
						}
						else if(secondaryInput.equals("H"))
						{
							System.out.println("Handle Check I)ns");
							System.out.println("Handle Check O)uts");
							String c = scan.nextLine().toUpperCase();
							if(c.equals("O")){
								options.HandleCheckOuts();
								options.writeToFileReservation();
								options.writeToFilel4();
							}
							else if(c.equals("I")){
								options.HandleCheckIns();
								options.writeToFileReservation();
								options.writeToFilel4();
								options.WriteToStayInfo();
							}
						}
					}
					else 
						System.out.println("Error, Invalid Password");
				}
				else if (input.equals("S")){
						System.out.println("Enter password for Supervisor authority");
						String attempt = scan.nextLine();
						if(attempt.equals(sPass)){
							System.out.println("A)dd Reservation");
							System.out.println("C)ancel Reservation");
							System.out.println("H)andle Check Ins/Outs");
							System.out.println("D)iscounts");
							System.out.println("B)illing Analysis");
							String secondaryInput = scan.nextLine().toUpperCase();
							
								if(secondaryInput.equals("A")){
									 options.addReservation(options.getReservationArray());
									 options.writeToFileReservation();
									 options.writeToFilel4();
									
								}
								else if(secondaryInput.equals("C")){
									options.CancelReservation();
									options.writeToFileReservation();
									options.writeToFilel4();
									options.WriteToCancelFile();
								}
								else if(secondaryInput.equals("H"))
								{
									System.out.println("Check O)uts");
									System.out.println("Check I)ns");
									String c = scan.nextLine().toUpperCase();
									if(c.equals("O")){
										options.HandleCheckOuts();
										options.writeToFileReservation();
										options.writeToFilel4();
									}
									else if(c.equals("I")){
										options.HandleCheckIns();
										options.writeToFileReservation();
										options.writeToFilel4();
										options.WriteToStayInfo();
									}
								}	
								
								else if(secondaryInput.equals("D")){
									options.DiscountReservation();
									options.writeToFileReservation();
								}
								
						}
						else 
							System.out.println("Error, Invalid Password");
						}
				else if (input.equals("Q")){
					run = false;
					System.out.println("Thank you for using L4Hotels!\nWe hope you've enjoyed your stay.");
			}
		}
	}
}

