
public class Student1 extends Person {
	public int id;
	public String major;
	public double gpa;
	
	
	public Student1() {
		id = 0; 
		major = "";
		gpa = 0.0;
	}
	
	
	public Student1(String n, int a, int b, String c, double grade) {
		name = n;
		age = a;
		id = b;
		major = c;
		gpa = grade;
	}
	
	
	public int getID() {
		return id; 
	}
	
	public String getMajor() {
		return major;
	}
	
	
	public double getGPA() {
		return gpa;
	}
	
	
	public void setID(int num) {
		id = num;
	}
	
	
	public void setMajor(String m) {
		major = m;
	}
	
	public void setGPA(double g) {
		gpa = g;
	}
	
	public String toString() {
		String info = "Student information:" + "\n Name: " + name + "\n Age: " + age + "\n Major: " + major + "\n GPA: " + gpa;
		return info;
	}
	
	public boolean equals(Student1 obj1, Student1 obj2) {
		if(obj1.getID() == obj2.getID()) {
			return true;
		}
		return false;
	}
}
