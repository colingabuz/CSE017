import java.util.Arrays;
public class Testing {
	public static void main (String [] args) {
		Integer [] randomList = new Integer [10000];
		for (int i = 0; i < randomList.length; i++) {
			randomList[i] = (int) (Math.random()*999);
		}
		
		Arrays.sort(randomList);
		
		Integer [] sortedList = new Integer [10000];
		for (int j = 0; j < sortedList.length; j++) {
			sortedList[j] = randomList[j];
		}
		
		int count = randomList.length - 1; 
		Integer [] invertedList = new Integer [10000];
		for(int n = 0; n <invertedList.length; n++) {
			invertedList[n] = randomList[count];
			count--;
		}
		
		System.out.printf("%-30s\t%-20s\t%-20s\t%-20s\n", "Sorting", "Random", "Sorted", "Inverted");
		Sort.selectionSort(randomList);
		int randomSelect = Sort.iterations[0];
		Sort.iterations[0] = 0; 
		Sort.selectionSort(sortedList);
		int sortedSelect = Sort.iterations[0];
		Sort.iterations[0] = 0;
		Sort.selectionSort(invertedList);
		int invertedSelect = Sort.iterations[0];
		
		
		Sort.insertionSort(randomList);
		int randomInsert = Sort.iterations[1];
		Sort.iterations[1] = 0; 
		Sort.selectionSort(sortedList);
		int sortedInsert = Sort.iterations[1];
		Sort.iterations[1] = 0;
		Sort.selectionSort(invertedList);
		int invertedInsert = Sort.iterations[1];
		
		
		Sort.bubbleSort(randomList);
		int randomBubble = Sort.iterations[2];
		Sort.iterations[2] = 0; 
		Sort.selectionSort(sortedList);
		int sortedBubble = Sort.iterations[2];
		Sort.iterations[2] = 0;
		Sort.selectionSort(invertedList);
		int invertedBubble = Sort.iterations[2];
		
		
		Sort.mergeSort(randomList);
		int randomMerge = Sort.iterations[3];
		Sort.iterations[3] = 0; 
		Sort.mergeSort(sortedList);
		int sortedMerge = Sort.iterations[3];
		Sort.iterations[3] = 0;
		Sort.mergeSort(invertedList);
		int invertedMerge = Sort.iterations[3];
		
		
		Sort.quickSort(randomList);
		int randomQuick = Sort.iterations[4];
		Sort.iterations[4] = 0; 
		Sort.quickSort(sortedList);
		int sortedQuick = Sort.iterations[4];
		Sort.iterations[4] = 0;
		Sort.quickSort(invertedList);
		int invertedQuick = Sort.iterations[4];
		
		
		Sort.bucketSort(randomList, Sort.max(randomList));
		int randomBucket = Sort.iterations[5];
		Sort.iterations[5] = 0; 
		Sort.selectionSort(sortedList);
		int sortedBucket = Sort.iterations[5];
		Sort.iterations[5] = 0;
		Sort.selectionSort(invertedList);
		int invertedBucket = Sort.iterations[5];
		
		Sort.radixSort(randomList);
		int randomRadix = Sort.iterations[6];
		Sort.iterations[6] = 0; 
		Sort.selectionSort(sortedList);
		int sortedRadix = Sort.iterations[6];
		Sort.iterations[6] = 0;
		Sort.selectionSort(invertedList);
		int invertedRadix = Sort.iterations[6];
		
		
		Heap.heapSort(randomList);
		int randomHeap = Sort.iterations[7];
		Sort.iterations[7] = 0; 
		Heap.heapSort(sortedList);
		int sortedHeap = Sort.iterations[7];
		Sort.iterations[7] = 0;
		Heap.heapSort(invertedList);
		int invertedHeap = Sort.iterations[7];
		
		
		
		
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Selection", randomSelect, sortedSelect, invertedSelect);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Insertion", randomInsert, sortedInsert, invertedInsert);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Bubble", randomBubble, sortedBubble, invertedBubble);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Merge", randomMerge, sortedMerge, invertedMerge);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Quick", randomQuick, sortedQuick, invertedQuick);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Bucket",randomBucket, sortedBucket, invertedBucket);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Radix", randomRadix, sortedRadix, invertedRadix);
		System.out.printf("%-30s\t%-20d\t%-20d\t%-20d\n", "Heap", randomHeap, sortedHeap, invertedHeap);
		
		
	
		  /*
		   Each algorithm had varying performance levels, with insertion using the least amount of iterations, and 
		   Selection having the most. Each algorithm had varying complexities depending on the type of array, besides 
		   Quick sort and Selection sort. In the case of these arrays, Insertion sort seems to be the most efficient to use in 
		   terms of iteration count. 
		   */
		
	}
}	
