
public class Employee extends Person{
	public int id;
	public String hireDate;
	
	
	
	public Employee() {
		id = 0; 
		hireDate = "";
	}
	
	
	public Employee(int num, String date) {
		id = num;
		hireDate = date;
	}
	
	
	public int getID() {
		return id;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public void setID(int a) {
		id = a;
	}

	public void setHireDate(String date) {
		hireDate = date;
	}
	
	public boolean equals(Employee obj1, Employee obj2) {
		if (obj1.getID() == obj2.getID()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String info = "Employee Information: " + "\n Name: " + name + "\n Age: " + age + "\n ID: " + id + "\n Hire Date: " + hireDate;
		
		return info;
	}
}
