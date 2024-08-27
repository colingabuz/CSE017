import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		String [] countries = null;
		
		try { // read file and add the contents to an array, then a Linked List
			countries = new String[228];
			
			Scanner fileReader = new Scanner(new FileInputStream("countries.txt"));
			
			int i = 0; 
			
			while (fileReader.hasNextLine()) {
			
				String line = fileReader.nextLine();
			
				countries[i] = line; 
			
				i++;
			}
			
				fileReader.close();
		
			DoublyLinkedList<String> countriesLinkedList = new DoublyLinkedList<>(countries);
			System.out.println("Printed List Forwards: ");
			printForward(countriesLinkedList);
			System.out.println();
			System.out.println("Printed List Backwards: ");
			printBackward(countriesLinkedList);

		}
	
	catch (FileNotFoundException e) { // if the file is not read an exception is thrown
			System.out.println(e.getMessage());
		}
	}
	
	// print methods
		public static <E> void printForward(DoublyLinkedList<E> list) {
			ListIterator<E> iter = list.iterator();
			for (int i = 0; i < list.size(); i++) {
				if (iter.hasNext()) {
					System.out.println(iter.next());
				}
			}
			
	}

		public static <E> void printBackward(DoublyLinkedList<E> list) {
			ListIterator<E> iter = list.iterator(list.size() - 1);
				while(iter.hasPrevious()) {
					System.out.println(iter.previous());
				}
			}
	}










