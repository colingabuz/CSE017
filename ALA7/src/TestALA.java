import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TestALA {
	public static void main(String [] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter a pathname: "); // prompt the user to enter a pathname 
		
		String name = input.next();
		
		int sizeFile = getSize(name);
		
		if (sizeFile <= 1000000) { // prints the size of the file 
			System.out.println("Size = " + (sizeFile / 1000) + "Kbytes");
		}	else if (sizeFile > 1000000 && sizeFile <= 1000000000) {
			System.out.println("Size = " + (sizeFile / 1000000) + "Mbytes");
		}
		else {
			System.out.println("Size = " + (sizeFile / 1000000000) + "Gigabytes");
		}
		
		ArrayList<Pair<String, Integer>> listTrees = new ArrayList<>(); // creates an array list for the trees 
		
		
		//declares members of the tree array
		Pair <String, Integer> tree1 = new Pair<String, Integer> ("Leather Leaf Acacia", 12);
		Pair <String, Integer> tree2 = new Pair<String, Integer> ("Key Lime", 24);
		Pair <String, Integer> tree3 = new Pair<String, Integer> ("American Hazelnut", 24);
		Pair <String, Integer> tree4 = new Pair<String, Integer> ("Flowering Maple", 24);
		Pair <String, Integer> tree5 = new Pair<String, Integer> ("Silverberry", 36);
		
		//adds members to the array
		listTrees.add(tree1);
		listTrees.add(tree2);
		listTrees.add(tree3);
		listTrees.add(tree4);
		listTrees.add(tree5);
		
		ArrayList<Pair<Integer, Double>> listStudents = new ArrayList<>(); // creates an array for students
		
		
		//declares student array members
		Pair<Integer, Double> student1 = new Pair<Integer, Double> (12345, 3.96);
		Pair<Integer, Double> student2 = new Pair<Integer, Double> (54321, 2.25);
		Pair<Integer, Double> student3 = new Pair<Integer, Double> (12453, 3.50);
		Pair<Integer, Double> student4 = new Pair<Integer, Double> (53421, 2.83);
		Pair<Integer, Double> student5 = new Pair<Integer, Double> (51234, 1.25);
		
		
		//adds students to the array
		listStudents.add(student1);
		listStudents.add(student2);
		listStudents.add(student3);
		listStudents.add(student4);
		listStudents.add(student5);
		
		
		boolean valid = false; // initializes valid to false
		
		while(!valid) { // loop to allow user to continue searching
			System.out.println("Which type of search would you like to perform? 1: search for a tree 2: search for a student ");
			int response = input.nextInt();
			input.nextLine();
			if (response == 1) {
				System.out.println("What type of tree would you like to search for? ");
				String treeSearch = input.next();
				int result = search(listTrees, treeSearch);
				if (result == -1) {
					System.out.println("That tree was not found. ");
				}
				else {
					System.out.println(listTrees.get(result).toString());
				}
			} else {
				System.out.println("What student ID would you like to search for? ");
				int idSearch = input.nextInt();
				int id = search(listStudents, idSearch);
				
				if (idSearch == -1) {
					System.out.println("That student was not found. ");
				}
				
				else {
					System.out.println(listStudents.get(id).toString());
				}
			}
			
			System.out.println("Would you like to keep searching? (y/n) ");
			if (input.next().equals("y")) {
				valid = true;
			}
			else {
				System.out.println("Exiting program...");
				valid = true;
			}
		}
	}
	
	
	
	public static int getSize(String directoryName) { // method to get the size of the directory 
		int count = 0;
		File name = new File(directoryName);
		
		if(!name.isFile() && !name.isDirectory()) {
			return 0;
		}
		else if (name.isDirectory()) {
			File[] fileArray = name.listFiles();
			for (int i = 0; i < fileArray.length; i++) {
				count += getSize(fileArray[i].getName());
			}
		}
		else 
			return (int) name.length();
		return count;
	}
	
	public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key) { // method to search the files for the key entered
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFirst().equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
}
