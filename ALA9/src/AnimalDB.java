import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnimalDB {
	public static void main(String [] args) {
		
		String [] animalArray = null;
		
		
		try {
				Scanner fileReader = new Scanner(new FileInputStream("animals.txt"));
				
				 animalArray = new String [455];
				
				int i = 0;
				
				while (fileReader.hasNextLine()) {
				
					String line = fileReader.nextLine();
				
					animalArray[i] = line;
					
					i++;
				}
				
				
				fileReader.close();
			
				shuffle(animalArray);	
				
				ArrayList<String> animalArrayList = new ArrayList<>(animalArray);
				LinkedList<String> animalLinkedList = new LinkedList<>(animalArray);
				System.out.printf("%-30s\t%-20s\t%-20s\n", "Animal Name", "#comparisons(ArrayList)", "#comparisons(LinkedList)");
				for(int j = 0; j < 100; j++) {
					int random =  (int) (Math.random() * animalArrayList.size());
					System.out.printf("%-30s\t%-20d\t%-20d\n", animalArray[random], animalArrayList.searchComparisons(animalArrayList.get(random)), animalLinkedList.searchComparisons(animalLinkedList.get(random)));
				}
				
			}
		
		catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
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
