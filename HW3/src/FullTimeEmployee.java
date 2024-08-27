
public class FullTimeEmployee extends Employee {
	public double annualSalary;
	public double monthlySalary;
	
	
	public FullTimeEmployee(){
		annualSalary = 0.0;
	}
	
	public FullTimeEmployee(String a, int b, int c, String d, double e) {
		name = a;
		age = b;
		id = c;
		hireDate = d;
		annualSalary = e;
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public double getMonthlySalary() {
		return (annualSalary / 12);
	}
	
	public void setAnnualSalary(double s) {
		annualSalary = s;
	}
	
	public String toString(String n, int num, double avg) {
		String info = "Full Time Employee Information: " + "\n Name: " + name + "\n Age: " + age + "\n ID: " + id + "\n Hire Date: " + hireDate;
		
		return info;
	}
}
