import java.util.ArrayList;


public class GenericMatrix <E> {
	private ArrayList<ArrayList<E>> map;
	
	public GenericMatrix() { // Constructor
		map = new ArrayList<>();
		for (int i = 0; i < rows(); i++) {
			map.add(new ArrayList<>());
		}
	}
	
	
	public GenericMatrix(E [][] cityArray) { // Constructor
		map = new ArrayList<>();
		for (int i = 0; i < cityArray.length; i++) {
			ArrayList<E> row = new ArrayList<>();
			for (int j = 0; j < cityArray[i].length; j++) {
				row.add(cityArray[i][j]);
			}
			map.add(row);
		}
	}
	
	public E get(int i, int j) { // Accsessor
		return map.get(i).get(j);
	}
	
	public void set(int i, int j, E item) { //Mutator
		map.get(i).set(j, item);
	}
	
	public int rows() { // returns the amount of rows
		return map.size();
	}
	
	public int columns() { // returns the amount of columns
		return map.get(0).size();
	}
	
	public String toString() { // prints the map as a formatted string
		for (int i = 0; i < map.size(); i++) {
			System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n",  map.get(i).get(0), map.get(i).get(1), map.get(i).get(2), map.get(i).get(3), map.get(i).get(4));
		}
		return "";
	}
}
