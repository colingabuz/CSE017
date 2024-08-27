

import java.util.Scanner;
public class homework1 {
	public static void main(String [] args) {
		Scanner keyboard = new Scanner (System.in);
		
			int size; 
			
			
			do {
				System.out.print("Enter an odd integer n:  ");
				
				boolean integer = keyboard.hasNextInt();
				
				if (integer) {
					size = keyboard.nextInt();
					
					if (size % 2 == 0) {
						System.out.println("You did not enter an odd integer.");
						continue; 
					}
					
					else {
						break;
					}
				}
					
			}while(true);	
			
			int [][] magicSquare = magicSquare(size);
			
			for (int i = 0; i < magicSquare.length; i++) {
				System.out.print("[ ");
				for (int j = 0; j < magicSquare[i].length; j++) {
					System.out.print(magicSquare[i][j] + " ");
				}
				System.out.println(" ]");
			}
			
			
			System.out.print("Enter the size of list 1: ");
			
			int size1 = keyboard.nextInt();
			
			int [] array1 = new int [size1];
			
			System.out.print("Enter " + size1 + " integers: ");
			
			for (int k = 0; k < size1; k++) {
				array1[k] = keyboard.nextInt();
			}
	
			
			System.out.print("Enter the size of list 2: ");
			
			int size2 = keyboard.nextInt();
			
			int [] array2 = new int [size2];
			
			System.out.print("Enter " + size2 + " integers: ");
			
			for (int m = 0; m < size2; m++) {
				array2[m] = keyboard.nextInt();
			}
			
			int [] mergedArrays = merge(array1, array2);
				
			
				for (int t = 0; t < mergedArrays.length; t++) {
					System.out.print(mergedArrays[t] + " ");
				}
		}
	
	public static int [][] magicSquare(int n){
		
        int[][] square = new int[n][n]; 
        
        int i = 0;
        
        int j = (n / 2) + 1;
        
        int originalRow;
        
        int originalCol;
        
       for (int fillNumbers = 1; fillNumbers < (n*n); fillNumbers++){
            square[i][j] = fillNumbers;
            
            originalRow = i;
            
            originalCol = j;

            i--;
            
            j++;
            
            if(i == -1){
            	i = n - 1;
            	}
            if(j == n){
            	j = 0;
            	}
            if(square[i][j] != 0){
            	i = originalRow + 1;
            	j = originalCol; 
            }
        }
        return square;
	} 
	
	
	
	public static int [] merge (int [] list1, int [] list2) {
		
		int [] merge = new int [list1.length + list2.length];
			int countList1 = 0;
			for (int i = 0; i < list1.length; i++) {
				merge [i] = list1[i];
				countList1++;
			}
			for (int j = 0; j < list2.length - 1; j++) {
				merge[countList1 + (j + 1)] = list2[j];
			}
			
			
			for (int l = 0; l < merge.length - 1; l++) {
				int temp;
				if (merge[l] < merge[l + 1]) {
					temp = merge[l];
					merge[l] = merge[l + 1];
					merge[l + 1] = temp;
				}
			}
		return merge;
	}
				

}