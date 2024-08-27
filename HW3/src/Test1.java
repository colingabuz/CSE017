
public class Test1 {
	public static void main(String [] args) {
	Person [] listOfPeople = new Person [10];
	listOfPeople[0] = new Student1("Lucy Treston", 20, 12345, "CSE", 3.75);
	listOfPeople[1] = new Student1("Mark Brown", 18, 12344, "ISE", 3.50);
	listOfPeople[2] = new FullTimeEmployee("Jerry Zurcker", 25, 3333333, "03/10/2017", 500000);
	listOfPeople[3] = new PartTimeEmployee("Sharon Luft", 22, 6666666, "01/01/2020", 32.0, 100);
	listOfPeople[4] = new Student1("Emma Packard", 19, 12355, "CSB", 3.0);
	listOfPeople[5] = new Student1("Felix Hirpara", 22, 55123, "CSE", 2.75);
	listOfPeople[6] = new PartTimeEmployee("Jade Farrar", 29, 1111111, "07/22/2012", 22.0, 45);
	listOfPeople[7] = new Student1 ("Juanita Stoltzman", 21, 44123, "ISE", 2.5);
	listOfPeople[8] = new PartTimeEmployee ("Brian Lin", 31, 7777777, "02/01/2014", 35.0, 31);
	listOfPeople[9] = new FullTimeEmployee ("Alicia Bubash", 35, 5555555, "08/01/2018", 125000);
	
	
	
	for (int i = 0; i < listOfPeople.length; i++) {
		String print = listOfPeople[i].toString();
		System.out.println(print);
		System.out.println();
		}
	
		System.out.println("List of students with GPA greater than 3.0");
		displayStudents(listOfPeople, 3.0);
		System.out.println();
		
		System.out.println("List of part-time employees");
		displayPartTimeEmployees(listOfPeople);
		System.out.println();
		
		
		System.out.println("List of full time employees");
		displayFullTimeEmployees(listOfPeople);
		System.out.println();
		
	
	}
	
	
	public static void displayStudents(Person [] list, double gpa) {
		for (int i = 0; i < list.length; i++) {
			if(list[i] instanceof Student1) {
				Student1 student = (Student1) list[i];
				if (student.getGPA() > gpa) {
					System.out.println(student.getName());
				}
			}
		}
	}
	
	
	public static void displayPartTimeEmployees(Person[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] instanceof PartTimeEmployee) {
				PartTimeEmployee emp = (PartTimeEmployee) list[i];
				System.out.println(emp.getName());
			}
		}
	}
	
	
	
	public static void displayFullTimeEmployees(Person [] list) {
		for (int i = 0; i < list.length; i++) {
			if (list [i] instanceof FullTimeEmployee) {
				FullTimeEmployee fullEmp = (FullTimeEmployee) list[i];
				System.out.println(fullEmp.getName());
			}
		}
	}
}
