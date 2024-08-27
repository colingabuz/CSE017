
public class Appointment {
	private String event;
	private Date date;
	private Time time;
	private String location;
	
	public Appointment() {
		event = "";
		date = null;
		time = null;
		location = "";
	}
	
	public Appointment(String event, String date, String time, String location) throws InvalidDateException, InvalidTimeException{
		this.event = event;
		this.date  = new Date (date);
		this.time = new Time (time);
		this.location = location;
		
	}
	
	public String getEvent() {
		return event;
	}
	
	public String getDate() {
		return date.toString();
	}
	
	public String getTime() {
		return time.toString();
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public void setDate(String date) {
		try {
		this.date = new Date(date);
		}
		catch (InvalidDateException e) {
			System.out.println("Invalid Date");
		}
	}
	public String toString() {
		String appt = "";
		
			appt += event + "\n" + date.toString() + "\n" + time.toString() + "\n" + location;
		
		return appt;
	}
	
	public boolean equals(Object obj) {
		Appointment appt = (Appointment) obj;
		if (appt == obj) {
			return true;
		}
		return false;
	}
}
