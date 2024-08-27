import java.util.Scanner;
public class Test{
  public static void main(String[] args) {
Scanner keyboard = new Scanner(System.in);

System.out.println("Enter the number of students: ");

int students = keyboard.nextInt();

String[] studentNames = new String[students];

double[] studentGPAs = new double[students];

int[] studentIDs = new int[students];

int operation = 0;

keyboard.nextLine();
 
inputData(keyboard, studentNames, studentIDs, studentGPAs);

do {
 operation = getOperation(keyboard);
 switch(operation) {
   case 1:
      System.out.printf("Enter student ID: ");
      int id = keyboard.nextInt();
      int i = findStudentID(studentIDs, id);
      if (i == -1)
        System.out.println(id + " not found.");
        else
        System.out.println("ID found, Name: " +
        studentNames[i] + ", GPA: " + studentGPAs[i]);
        break;
        case 2:
    displayData(studentNames, studentIDs, studentGPAs);
    break;
    case 3:
      double avg = averageGPA(studentGPAs);
      System.out.printf("Average GPA: %5.2f\n", avg);
      break;
      case 4:
      sortNames(studentNames, studentIDs, studentGPAs);
      displayData(studentNames, studentIDs, studentGPAs);
      break;

      case 5:
      sortIDs(studentIDs, studentGPAs, studentNames);
      displayData(studentNames, studentIDs, studentGPAs);
      break;

      case 6:
      sortGPAs(studentGPAs, studentNames, studentIDs);
      displayData(studentNames, studentIDs, studentGPAs);
      break;


      case 7:
      int indexHigh = highestGPA(studentGPAs);
      System.out.print("The highest GPA is: " + studentGPAs[indexHigh]);
      System.out.println("The name of the student with the highest GPA is : " + studentNames[indexHigh]);
      System.out.println("The ID of the student with the highest GPA is: " + studentIDs[indexHigh]);
      break;

      case 8:
      int indexLow = lowestGPA(studentGPAs);
      System.out.print("The lowest GPA is: " + studentGPAs[indexLow]);
      System.out.println("The name of the student with the lowest GPA is : " + studentNames[indexLow]);
      System.out.println("The ID of the student with the lowest GPA is: " + studentIDs[indexLow]);
      break;

      case 9:
      System.out.println("Thank you for using my program.");
    }
  } while (operation != 9);
}

  public static void inputData(Scanner input, String [] names, int [] ids, double [] gpas){
    for(int i = 0; i < names.length; i++) {
        System.out.println("Enter name of student " +(i+1)+ ": ");
          names[i] = input.nextLine();
          do {
            System.out.println("Enter id of student " +(i+1)+ ": ");
            if (input.hasNextInt())
            break;

            else {
              System.out.println("ID must be an integer.");
              input.nextLine();
            }
          } while (true);
            ids[i] = input.nextInt();
        do{
          System.out.println("Enter gpa of student " + (i+1) + ":" );
          if (input.hasNextDouble()) break;
          else {
            input.nextLine();
            System.out.println("GPA must be a double.");
          }
        } while (true);
          gpas[i] = input.nextDouble();
          input.nextLine();
      }
    }



    public static void displayData(String [] names, int [] ids, double [] gpas){
      System.out.printf("%-20s\t%-15s\t%-15s\n", "Student name", "Student ID", "Student GPA");
        for (int i = 0; i< names.length; i++)
          System.out.printf("%-20s\t%-15d\t%-15.2f\n", names[i], ids[i], gpas[i]);
    }


    public static int getOperation(Scanner input) {
      int op = 0;
      do {
        printMenu();
        if (input.hasNextInt()) {
          op = input.nextInt();
          if (op >=1 && op <= 9) break;
          else
          System.out.println("Invalid operation (1-4 or 9)");
        }
        else {
          input.nextLine();
          System.out.println("Invalid operation(must be integer)");
        }
      } while (true);
      return op;
    }


    public static void printMenu(){
      System.out.println("\nSelect an operation: ");
      System.out.println(" 1: Find student (id)");
      System.out.println(" 2: View all students");
      System.out.println(" 3: View average GPA");
      System.out.println(" 4: Sort students by name");
      System.out.println(" 5: Sort students by ID");
      System.out.println(" 6: Sort students by GPA");
      System.out.println(" 7: Show information on the student with the highest GPA");
      System.out.println(" 8: Show information on the student with the lowest GPA");
      System.out.println(" 9: Exit program");
 }




 public static double averageGPA(double[] gpas) {
   double average = 0;
   for (int i = 0; i< gpas.length; i++) {
     average += gpas[i];
   }
   return average/gpas.length;
  }

  public static int findStudentID(int[] ids, int id) {
    for (int i = 0; i< ids.length; i++) {
      if(ids[i] == id)
      return i;
    }
    return -1;
  }




  public static void sortNames(String[] names, int[] ids, double[] gpas) {
   for (int i=0; i<names.length; i++) {
     int minIndex = i;
     String minName = names[i];
     for(int j=i+1; j<names.length; j++) {
       if(names[j].compareTo(minName) < 0 ){
         minName = names[j]; minIndex = j;
       }
     }
     swap(names, i, minIndex);
     swap(ids, i, minIndex);
     swap(gpas, i, minIndex);
   }
  }



  public static void swap(String[] names, int i, int j) {
    String temp = names[i];
    names[i] = names[j];
    names[j] = temp;
  }

  public static void swap(int[] ids, int i, int j) {
    int temp = ids[i];
    ids [i] = ids [j];
    ids [j] = temp;
  }

    public static void swap(double[] gpas, int i, int j) {
      double temp = gpas[i];
      gpas [i] = gpas [j];
      gpas [j] = temp;
    }



    public static int binarySearchStudentID(int [] ids, double [] gpas, String [] names, int k) {
        int low = 0;
        int high = ids.length - 1;
        int middle;
        while (high >= low){
          for (int i = 0; i < ids.length; i++){
            middle = (low + high) / 2;
            if (ids[i] > middle){
              low = middle + 1;
            }
            else if (ids[i] < middle){
              high = middle - 1;
            }
            else {
              return middle;
            }
          }
        }
      return -1;
    }

    public static int highestGPA(double [] gpas){
      double highGPA = 0.0;
      int index = 0;
        for (int i = 0; i < gpas.length; i++){
          if (gpas[i] > highGPA){
            highGPA = gpas[i];
            index = i;
          }
        }
        return index;
    }


    public static int lowestGPA(double [] gpas){
        double lowest = 10.0;
        int index = 0;
          for(int i = 0; i < gpas.length; i++){
            if (gpas[i] < lowest){
              lowest = gpas[i];
                index = i;
            }
          }
        return index;
    }

    public static void sortGPAs(double[] list, String [] names, int[] ids) {
		double current;
		for(int i=1; i<list.length; i++) {
			current = list[i];
			int k=i;
			while (k>0 && current < list[k-1]) {
				list[i] = list[i-1]; //shift element list[j-1] one position to the right
				k--;
			}
			list[i] = current; // insert current at position j
			ids[i] = ids[k];
			names[i] = names[k];
			}	
	}
    
    public static void sortIDs(int[] list, double [] gpas, String [] names) {
		int min;
		int minIndex;
	for (int j = 0; j < list.length; j++) {	
		min = list[j];
		minIndex = j;
			for(int k=j; k<list.length; k++) { // loop to find the minimum
				if(list[k] < min) {
					min = list[k];
					minIndex = k;
				}
			}
			swap(names, j, minIndex);
		     swap(list, j, minIndex);
		     swap(gpas, j, minIndex);
			}
	
    	}
	}

    
