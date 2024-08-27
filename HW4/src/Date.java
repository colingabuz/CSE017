
public class Date {
	private int day;
	private int month;
	private int year;
	
	
	public Date(){
		day = 0; 
		month = 0;
		year = 0;
	}
	
	public Date(String date)throws InvalidDateException {
		String regex = "\\d(\\d)?/\\d(\\d)?/\\d{4}";
		if (!date.matches(regex)) {
			throw new InvalidDateException("That is not a correctly formatted date.");
		}
		String [] dateParts = date.split("/");
		month = Integer.parseInt(dateParts[0]);
		day = Integer.parseInt(dateParts[1]);
		year = Integer.parseInt(dateParts[2]);
		if (day > 31 || day < 1) {
			throw new InvalidDateException("Invalid day");
		}
	
		if (month > 12 || month < 1) {
			throw new InvalidDateException("Invalid month");
		}
		
		if (year >= 3000 || year < 1950) {
			throw new InvalidDateException("Invalid year");
		}
	}
	
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	public boolean equals(Object obj) {
		Date date = (Date) obj;
		if (date == obj) {
			return true;
		}
		return false;
	}
}
