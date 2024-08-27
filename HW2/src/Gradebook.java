
public class Gradebook {
	private Student [] roster;
	
	
	public Gradebook(){
		roster = new Student [50];
	}
	
	

	public Gradebook(Student [] list) {
		roster = new Student [list.length];
		        
		for (int i = 0; i < list.length; i++) {
			roster[i] = new Student(list[i].getName(), list[i].getID(), list[i].getGPA());
		}
		
	}

	public String findStudentID(int id, Student [] roster) {
		int finder = 0;
		int index = 0;
		String name = "";
		double gpa = 0.0;
		 
			for (int i = 0; i < roster.length; i++) {
				finder = roster[i].getID();
				
				if(finder == id) {
					index = i; 
					name = roster[i].getName();
					gpa = roster[i].getGPA();
					break;
			}
		}
			return roster[index].toString(name, id, gpa);
	}
	
	public double getAverageGPA(Student [] roster) {
		double sum = 0.0;
		int counter = 0; 
			for (int i = 0; i < roster.length; i++) {
				
				sum += roster[i].getGPA();
				
				if (roster[i].getGPA() != 0.0) {
				counter++;
				}
				
			}
		return (sum / counter);	
	}
	
	
	public void displayData(Student [] roster) {
		System.out.printf("%-20s\t%-15s\t%-15s\n", "Student name", "Student ID", "Student GPA");
		System.out.println();
		for (int i = 0; i < roster.length; i++) {
			System.out.printf ("%-20s\t%-15s\t%-15s\n", roster[i].getName(), roster[i].getID(), roster[i].getGPA());
		}
		System.out.println();
	}
	
	public void sortIDs(Student [] roster) {
		int currentID; 
			for (int i = 0; i < roster.length; i++) {
				currentID= roster[i].getID();
				int place = i;
				while (place > 0 && currentID < roster[place - 1].getID()) {
					int move = roster[place].getID();
					int shift = roster[place - 1].getID();
					
					int temp = move;
					move = shift;
					shift = temp;
					
					place--;
				}
			}
		}
	
	public String highestGPA(Student [] roster) {
		double highest = 0.0;
		
		int index = 0;
		
		String name = "";
		
		double gpa = 0.0;
		
		int id = 0;
		
		for (int i = 0; i < roster.length; i++) {
			if(roster[i].getGPA() > highest) {
				highest = roster[i].getGPA();
				index = i; 
			}
		}
		name = roster[index].getName();
		id = roster[index].getID();
		
		
		return roster[index].toString(name, id, highest);
	}
	
	
	public String lowestGPA(Student [] roster) {
		double lowest = 10.0;
		
		int index = 0; 
		
		String name = "";
		
		double gpa = 0.0;
		
		int id = 0; 
		
		for (int i = 0; i < roster.length; i++) {
			if (roster[i].getGPA() < lowest) {
				lowest = roster[i].getGPA();
				index = i;
			}
		}
		name = roster[index].getName();
		id = roster[index].getID();
		
		return roster[index].toString(name, id, lowest);
	}
	
	
	
}
	