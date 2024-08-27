import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Calendar {
	//instance
	private Appointment[] appointments;
	//constructors
	public Calendar() {
		this.appointments = null;
	}
	public Calendar(int capacity, String filename) {
		appointments = new Appointment[capacity];
		try {
		readCalendarFromFile(filename);
		}catch(InvalidTimeException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//methods
	private void readCalendarFromFile(String filename) throws FileNotFoundException,
	InvalidDateException, InvalidTimeException{
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new FileInputStream(filename));
			while(fileScanner.hasNextLine()) {
				String event = fileScanner.nextLine();
				String date = fileScanner.nextLine();
				String time = fileScanner.nextLine();
				String location = fileScanner.nextLine();
				Appointment app = new Appointment(event, date, time, location);
				addAppointment(app);
			}
		}
		catch (FileNotFoundException e){
			for (int i = 0; i < appointments.length;i++)
				appointments[i] = new Appointment();
		}
		catch (InvalidDateException e){
			System.out.println(e.getMessage());
		}
		catch (InvalidTimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveCalendarToFile(String filename) {
		PrintWriter fileWriter = null;
		try {
			fileWriter = new PrintWriter(new FileOutputStream(filename));
		}
		catch (FileNotFoundException e) {
			System.out.print("File not found");
		}
		String text = "";
		for (int i = 0; i < appointments.length; i++)
			text += appointments[i].getEvent() + "\n "+ appointments[i].getDate()
					+ "\n" + appointments[i].getTime() + "\n"+ 
					appointments[i].getLocation() + "\n";
		fileWriter.print(text);
		fileWriter.close();
	}
	
	public static int size = 0;
	public boolean addAppointment(Appointment a) {
		if(size == appointments.length) {
			System.out.println("Calendar full - cannot add more appointments");
			return false;
		}
		else {
			appointments[size++] = a;
			System.out.println("Appointment added successfully");
			return true;
		}
	}
	
	public void removeAppointment(Appointment a) {
		for (int i = 0; i < appointments.length; i++) {
			if(a.getEvent().matches(appointments[i].getEvent())) {
				appointments[i] = new Appointment();
				size--;
			}
		}
	}
	
	public Appointment findAppointment(String event) {
		for (int i = 0; i < appointments.length; i++) {
			if(event.matches(appointments[i].getEvent()))
				return appointments[i];
		}
		return null;
	}
	public String toString() {
		String s = "";
		for(int i = 0; i < appointments.length; i++) {
			s += appointments[i].toString() + "\n";
		}
		return s;
	}
}

