
public class PartTimeEmployee extends Employee{
	public double hourlyWage;
	public double numberOfHours;
	
	public PartTimeEmployee() {
		hourlyWage = 0.0;
		numberOfHours = 0.0;
	}

	public PartTimeEmployee(String a, int b, int c, String d, double e, double f){
		name = a;
		age = b;
		id = c; 
		hireDate = d;
		hourlyWage = e;
		
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	public double getTotalWage() {
		return (hourlyWage * numberOfHours);
	}
	
	public double getNumberOfHours() {
		return numberOfHours;
	}
	
	public void setHourlyWage(double wage) {
		hourlyWage = wage;
	}
	
	public void setNumberOfHours(double num) {
		numberOfHours = num;
	}
	
	public String toString(String n, int num, double avg) {
		String info = "Part Time Employee Information: " + "\n Name: " + name + "\n Age: " + age + "\n ID: " + id + "\n Hire Date: " + hireDate;
		
		return info;
	}
}
