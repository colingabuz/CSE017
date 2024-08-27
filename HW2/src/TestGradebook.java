import java.util.Scanner;

public class TestGradebook {
	public static void main(String [] args) {
		Scanner keyboard = new Scanner (System.in);
		Student [] studentList = new Student [5];
		studentList[0] = new Student ("Jerry Marcy" , 1234, 3.25);
		studentList[1] = new Student ("Lily Merchant" , 1342, 3.75);
		studentList[2] = new Student ("Elanor Maxwell", 4213, 3.90);
		studentList[3] = new Student ("Fred Karl", 2134, 2.00);
		studentList[4] = new Student ("Anatoly Marsh", 3421, 3.25);
		
		
		int op = 0; 
		
		Gradebook book = new Gradebook (studentList);
		
		do {
			op = getChoice(keyboard);
			
			switch(op) {
			
			case 1: 
				System.out.println("Enter an id to search for: ");
				int search = 0;
				String person = "";
				search = keyboard.nextInt();
				person = book.findStudentID(search, studentList);
				System.out.println(person);
				break;
				
			case 2:
				book.displayData(studentList);
				break;
				
			case 3:
				double average = book.getAverageGPA(studentList);
				System.out.println("The average GPA is: " + average);
				break;
				
			case 4:
				book.sortIDs(studentList);
				book.displayData(studentList);
				break;
				
			case 5:
				String infoLowest = book.lowestGPA(studentList);
				System.out.println(infoLowest);
				break;
				
			case 6: 
				String infoHighest = book.highestGPA(studentList);
				System.out.println(infoHighest);
				break;
				
			case 7:
				System.out.println("Exiting program... ");
				break;
		} 
	} while(op > 0 && op < 7);
				
}
	
	
	public static void printMenu() {
		System.out.println("This is the Gradebook. Enter the number of an operation you wish to perform: ");
		System.out.println("1: find student ID in the Gradebook object");
		System.out.println("2: display all student information stored in the grade book");
		System.out.println("3: find average GPA and display it");
		System.out.println("4: sort students by id and display the sorted list");
		System.out.println("5: find the student with the lowest GPA and display the student information");
		System.out.println("6: find the student with the highest GPA and display the student information");
		System.out.println("7: quit program");
	}
	
	
	
	public static int getChoice(Scanner input){
		int operation = 0;
		
	do {
			printMenu();
				if (input.hasNextInt()) {
					operation = input.nextInt();
			
					if (operation > 0 && operation < 8) {
						break;
					}
		
					else {
						input.nextLine();
						System.out.println("Invalid operation choice. ");
						continue;
					}
			}
				
				else {
					input.nextLine();
					System.out.println("Please enter an integer value. ");
					continue;
				}
		
			
		}while (true);
			
		return operation;
	}
}
