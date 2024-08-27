
public class Person {
	public String name; 
	public int age;
	
	
	
	public Person() {
		name = "";
		age = 0;
	}
	
	
	
	public Person(String n, int a) {
		name = n;
		age = a;
	}
	
	public String getName(){
		return name; 
		}
	
	public int getAge() {
		return age; 
	}
	
	public void setName (String n) {
		name = n;
	}
	
	public void setAge(int num) {
		age = num;
	}
	
	public boolean equals(Person obj1, Person obj2) {
		if (obj1.getName() == obj2.getName()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String info = "Personal Information: " + "\n Name: " + name + "\n Age: " + age;

		return info;
	}
}
