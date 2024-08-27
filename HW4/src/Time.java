
public class Time {
	private int hours;
	private int minutes;
	
	
	public Time() {
		hours = 0; 
		minutes = 0; 
	}
	
	
	public Time (String time) throws InvalidTimeException{
		String regex = "\\d{2}:\\d{2}";
		if (!time.matches(regex)) {
			throw new InvalidTimeException("Incorect Time Format.");
		}
		String [] timeParts = time.split(":");
		hours = Integer.parseInt(timeParts[0]);
		minutes = Integer.parseInt(timeParts[1]);
		
		if (hours < 0 || hours > 23) {
			throw new InvalidTimeException("Invalid value for hours.");
		}
		if (minutes < 0 || minutes > 59) {
			throw new InvalidTimeException("Invalid value for minutes.");
		}
	}
	
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public void setMinutes(int mins) {
		minutes = mins;
	}
	
	public void setHours(int hrs) {
		hours = hrs;
	}
	
	
	public String toString() {
		return hours + ":" + minutes;
	}
	
	public boolean equals(Object obj) {
		Time time = (Time) obj;
		if (time == obj) {
			return true;
		}
		return false;
	}
}
