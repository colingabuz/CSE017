import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LL_BST {
	public static void main (String [] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		String [] animalNames = null;
		
		try { // try block to read the file 
			Scanner fileReader = new Scanner(new FileInputStream("animals.txt"));
			
			 animalNames = new String [455];
			
			int i = 0;
			
			while (fileReader.hasNextLine()) {
			
				String line = fileReader.nextLine();
			
				animalNames[i] = line;
				
				i++;
			}
			
			fileReader.close();
		
			shuffle(animalNames);
			
		}
	
	catch (FileNotFoundException e) { // exception catch for the case of there being no existing file
			System.out.println(e.getMessage());
		}
		
		// creating an array list for the data in the text file
		ArrayList<String> animalArrayList = new ArrayList<>();
			for (int i = 0; i < animalNames.length; i++) {
				animalArrayList.add(animalNames[i]);
			}
		
			// creates two data structures to store the animal data
			LinkedList<String> animalList = new LinkedList<>(animalNames);
		
			BST<String> animalBST = new BST<>(animalNames);
			
			boolean proceed = false;
			String name = " ";
			while(!proceed) { // while loop to keep searching as long as the user wants to 
				System.out.println("Enter the name of an animal to search for: ");
				 name = keyboard.next();
				if(name.contentEquals("")) {
					proceed = true; 
					System.out.println("You did not enter an animal name. ");
				}
				else{
					int listComps = animalList.searchComparisons(name);
					int bstComps = animalBST.searchComparisons(name);
					if (listComps == 455) {
						System.out.println(name + " not found in the animal Linked List. Number of comparisons: " + listComps); 
					}
					else {
						System.out.println(name + " found in the animal Linked List. Number of comparisons: " + listComps);
					}
					if (bstComps == 455) {
						System.out.println(name + " not found in the animal BST. Number of comparisons: " + bstComps);
					}
					else {
						System.out.println(name + " found in the animal BST. Number of comparisons: " + bstComps);
					}
				}
				System.out.println("Would you like to keep searching? (y/n)");
				String answer = keyboard.next();
				if (answer.equals("y")) {
					continue;
				}
				else {
					break;
				}
			}
	}
	
	
	
	public static void shuffle(String [] list) {
		for (int i = 0; i < list.length; i++) {
			int index = (int) (Math.random() * list.length);
			String temp = list[index];
			list[index] = list[i];
			list[i] = temp;
		}
	}
}
