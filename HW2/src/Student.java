
public class Student {
	private String name;
	private int id;
	private double gpa;

	
	Student(){
		name = "none";
		id = 0;
		gpa = 0.0;
	}

	

	Student(String n, int number, double avg){
		name = n;
		id = number;
		gpa = avg;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}
	
	public double getGPA() {
		return gpa;
	}

	public void setName(String n) {
		name = n;
	}
	
	public void setID(int num) {
		id = num;
	}
	
	public void setGPA(double avg) {
		gpa = avg;
	}

	public String toString(String n, int num, double avg) {
		String id = Integer.toString(num);
		
		String gpa = Double.toString(avg);
		
		String info = n + ", " + id + ", " + gpa;
		
		return info;
	}

}


