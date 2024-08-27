import java.util.ArrayList;
import java.util.Collection;

public class Sort<E> {
	public static int[] iterations = new int[8];
	public static <E extends Comparable<E>> void selectionSort(E[] list) {
	 int minIndex;
	 for (int i=0; i<list.length-1; i++) {
		 iterations[0]++;
	 minIndex = findMin(list, i);
	 E temp = list[i];
	 list[i] = list[minIndex];
	 list[minIndex] = temp;
	
	 }
	}
	public static <E extends Comparable<E>>int findMin(E[] list, int start){
	 E min = list[start]; int index = start;
	 for (int i=start; i<list.length; i++){
		 iterations[0]++;
	 if (list[i].compareTo(min) < 0){
	 min = list[i];
	 index = i;
	 }
	 
	 }
	 return index;
	}
	
	
	public static <E extends Comparable<E>> void insertionSort(E[] list) {
			 for (int i = 1; i < list.length;i++) {
				 iterations[1]++;
			 // Insert element i
			 // in the sorted sub-list
			 insert(list, i);
			 
			 }
			} 
	
	private static <E extends Comparable<E>> void insert(E[] list, int i) {

		 E currentVal = list[i];

		 while (i > 0 && currentVal.compareTo(list[i - 1]) < 0)
		 {
			 iterations[1]++;
		 // Shift element (i-1) into element (i)
		 list[i] = list[i - 1];
		 i--;
		 }
		 // Insert currentVal at position i
		 list[i] = currentVal;
		}
	
	
	
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		 boolean sorted = false;
		 for (int k=1;k < list.length && !sorted;k++) {
		 sorted = true;
		 for (int i=0; i<list.length-k; i++) {
			 iterations[2]++;
		 if (list[i].compareTo(list[i+1]) < 0) {
		 // swap
		 E temp = list[i];
		 list[i] = list[i+1];
		 list[i+1] = temp;
		 sorted = false;
		 		}
		 	}
		 }
	}
	
	
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) { // base case
		 Comparable<E>[] firstHalf = new Comparable[list.length/2];
		 Comparable<E>[] secondHalf = new Comparable[list.length - list.length/2];
		 System.arraycopy(list, 0, firstHalf, 0,list.length/2);
		 System.arraycopy(list, list.length/2,secondHalf, 0,list.length-list.length/2);
		mergeSort((E[])firstHalf);
		
		mergeSort((E[])secondHalf);
		
		merge((E[])firstHalf, (E[])secondHalf, list);
		
		 }
		}
	
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] list) {
			int list1Index = 0;
			int list2Index = 0;
			int listIndex = 0;
			while( list1Index < list1.length &&
			 list2Index < list2.length) {
				iterations[3]++;
			if (list1[list1Index].compareTo(list2[list2Index]) < 0)
			list[listIndex++] = list1[list1Index++];
			else
			list[listIndex++] = list2[list2Index++];
				
			}
			while(list1Index < list1.length) {
			list[listIndex++] = list1[list1Index++];
				iterations[3]++;
			}
			while(list2Index < list2.length) {
			list[listIndex++] = list2[list2Index++];
				iterations[3]++;
				}
			}
	
	
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length-1);
		
		}
		public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
		if (last > first) {
		int pivotIndex = partition(list, first, last);
		quickSort(list, first, pivotIndex-1);
		
		quickSort(list, pivotIndex+1, last);
		
		}
		}
		
		
		public static <E extends Comparable<E>> int partition(E list[], int first, int last){
				 E pivot;
				 int index, smallIndex;
				 pivot = list[first];// pivot is the first element
				 smallIndex = first;
				 for (index = first + 1; index <= last; index++) {
					 iterations[4]++;
				 if (list[index].compareTo(pivot) < 0){
				 smallIndex++;
				 swap(list, smallIndex, index);
				 	}
				 }
				 swap(list, first, smallIndex);
				 return smallIndex;
				}
		private static <E extends Comparable<E>> void swap(E[] list, int index1, int index2) {
	        E temp = list[index1];
	        list[index1] = list[index2];
	        list[index2] = temp;
	    }
		
		
		
		public static void bucketSort(Integer[] list, int t) {
			ArrayList<ArrayList<Integer>> buckets;
			buckets = new ArrayList<>(t+1);
			for(int i=0; i<t+1; i++) {
				iterations[5]++;
			buckets.add(new ArrayList<>());
			}// bucket i
			//Distribute data on buckets
			for(int i=0; i<list.length; i++) {
				iterations[5]++;
			ArrayList<Integer> bucket = buckets.get(list[i]);
			bucket.add(list[i]);
			buckets.set(list[i], bucket);
			}
			// Move data from the buckets back to the list
			int k = 0;
			for(int i=0; i<buckets.size(); i++) {
				iterations[5]++;
			ArrayList<Integer> bucket = buckets.get(i);
			for(int j=0; j<bucket.size(); j++)
			list[k++] = bucket.get(j);
			
				}
			}
		
		
		public static void radixSort(Integer[] list) {
			 ArrayList<ArrayList<Integer>> buckets;
			 buckets = new ArrayList<>(10);// 10 buckets
			 Integer digits = max(list);
			 digits = digits.toString().length();
			 for(int i=0; i<digits; i++) {
			 for(int j=0; j<10; j++) { // create buckets for iteration I
				 iterations[6]++;
			 buckets.add(new ArrayList<>());
			 }
			 //Distribute data on buckets
			 for(int j=0; j<list.length; j++){
				 iterations[6]++;
			 int digit = list[i] % (10 * (i+1)) / (int)Math.pow(10,i);
			 ArrayList<Integer> bucket = buckets.get(digit);
			 bucket.add(list[i]);
			 buckets.set(digit, bucket);
			 }
			 // Move data from the buckets back to the list
			 int k = 0;
			 for(int n=0; n<buckets.size(); n++) {
				 
			 ArrayList<Integer> bucket = buckets.get(i);
			 for(int j=0; j<bucket.size(); j++) {
				 iterations[6]++;
				 while(k < bucket.size())
			 list[k++] = bucket.get(j);
			 	}
			 }
			 buckets.clear(); // for next iteration
			 
			 }
		}
		
		public static int max(Integer[] list) { 
		    int mx = list[0]; 
		    for (int i = 1; i < list.length; i++) 
		        if (list[i] > mx) 
		            mx = list[i]; 
		    return mx; 
		}
		
}