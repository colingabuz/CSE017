
public class TestGenericMatrix {
	public static void main(String [] args) {
		String [][] cityArray = new String [5][5]; // creates city array and initializes each row
		cityArray[0] = new String [] { "Tamaqua", "Lehighton", "Danielsville", "Liberty", "Hope"};	
		
		cityArray[1] = new String [] { "Kempton", "Northampton", "Nazareth", "Lopatcong", "Washington"};	
		
		cityArray[2] = new String [] { "Hamburg", "Allentown", "Bethlehem", "Easton", "Stewartsville"};	
		
		cityArray[3] = new String [] { "Bernville", "Emmaus", "Hellertown", "Milford", "Alexandria"};	
		
		cityArray[4] = new String [] { "Reading", "Boyertown", "Harleysville", "Doylestown", "New Hope"};
		
		GenericMatrix<String> cityMap = new GenericMatrix<String>(cityArray); // creates a generic matrix to show the city map 
		
		System.out.println(cityMap.toString()); //prints the map and paths between cities
		System.out.println();
		System.out.println("One path from Bernville to Hope is: \n" + findOnePath(cityMap,3,0,0,4));
		System.out.println();
		System.out.println("There are " + countPaths(cityMap,4,0,2,2) + " paths between Reading and Bethlehem. ");
		
	}
	
	
	
	
	
	
	public static <E> String findOnePath(GenericMatrix<E> list, int startRow, int startCol, int endRow, int endCol) { // recursive method to find the path from one city to another
		if (list.get(startRow, startCol) == list.get(endRow, endCol)) {
			return list.get(endRow, endCol).toString();
		}
		
		if(startCol < endCol) {
			return list.get(startRow, startCol) + "-->" + findOnePath(list, startRow, startCol+1, endRow, endCol);
		}
		
		if (startRow > endRow) {
			return list.get(startRow, startCol) + "-->" + findOnePath(list, startRow-1, startCol, endRow, endCol);
		}
		return "";
	}
	
	public static <E> int countPaths(GenericMatrix<E> list, int startRow, int startCol, int endRow, int endCol) { // recursive method to count all the paths possible to get from point A to point B
		int paths = 0; 
		if (list.get(startRow, startCol) == list.get(endRow, endCol)) {
			return 1;
		}
		
		if (startCol < endCol) {
			paths += countPaths(list, startRow, startCol+1, endRow, endCol);
		}
		
		if (startRow > endRow) {
			paths += countPaths(list, startRow-1, startCol, endRow, endCol);
		}
		return paths;
		
	}
	
}
