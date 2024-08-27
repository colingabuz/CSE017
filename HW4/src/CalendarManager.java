import java.util.Scanner;
import java.io.FileNotFoundException;

public class CalendarManager {
	public static void main (String [] args) {
		Scanner input = new Scanner (System.in);
		String filename = "appointments.txt";
		Calendar listEvents = new Calendar(30, filename);
		
		int choose = 0;
		
		do {
			
			choose = getChoice(input);
			
			switch(choose) {
			
			case 1:
				System.out.println("Enter an event: ");
				String eventSearch = "";
				eventSearch = input.nextLine();
				listEvents.findAppointment(eventSearch);
				break;
				
				
			case 2:
				System.out.println(listEvents.toString());
				break;
				
				
			case 3:
				System.out.println("Enter a new appointment, one piece of information at a time (event, date, time, location): ");
				try {
					String info = input.nextLine();
					String [] split = info.split(" ");
					String event = split[0];
					String date = split[1];
					String time = split[2];
					String location = split[3];
				Appointment addAppt = new Appointment (event, date, time, location);
				listEvents.addAppointment(addAppt);
				}
				catch (InvalidTimeException e) {
					System.out.println(e.getMessage());
				}
				catch (InvalidDateException e) {
					System.out.println(e.getMessage());
				}
				break;
				
				
			case 4:
				System.out.println("Enter an appiontment description (event):  ");
				String description = input.next();
				Appointment findAppt = listEvents.findAppointment(description);
				if(findAppt == null) {
					System.out.print("Appointment not found");
				}else {
					System.out.println("enter new information to update the appointment: ");
					String event1 = input.next();
					String date1 = input.next();
					String time1 = input.next();
					String location1 = input.next();
					try {
						Appointment updated = new Appointment (event1, date1, time1, location1);
						listEvents.addAppointment(updated);
				}catch (InvalidTimeException e) {
					System.out.println(e.getMessage());
					}catch (InvalidDateException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
			case 5:
				System.out.println("Enter the event name of the appointment you'd like to remove: ");
				String removeEvent = input.next();
					Appointment remove = listEvents.findAppointment(removeEvent);
					if (remove == null) {
						System.out.println("That appointment does not exist. ");
					}else {
						listEvents.removeAppointment(remove);
						System.out.println("Appointment removed. ");
					}
				break;
				
				
			case 6:
				listEvents.saveCalendarToFile(filename);				
				System.out.println("Exiting Program ... ");
				break;
				
			
			
			
			}
			
			
			
		}while(choose > 0 && choose < 7);
		
	}
	
	public static void printOptions() {
		System.out.println("Please select an operation: ");
		System.out.println("1: View an appointment ");
		System.out.println("2: View all appointments ");
		System.out.println("3: Add new appointment ");
		System.out.println("4: Update an existing appointment ");
		System.out.println("5: Remove an appointment ");
		System.out.println("6: Quit program ");
	}
	
	
	
	
	
	public static int getChoice(Scanner input){
		int operation = 0;
		boolean flag = false;

	do {
			printOptions();

				if (input.hasNextInt()) {
					operation = input.nextInt();

					if (operation > 0 && operation < 7) {
						flag = true;
					}

					else {
						input.nextLine();
						System.out.println("Invalid operation choice. ");
						flag = false;
					}

			}
				else {
					System.out.println("You must enter an integer operation 1-3. ");
					continue;
				}


		}while (flag == false);

		return operation;
	}
}
