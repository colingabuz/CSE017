import java.util.Scanner;


public class AirplaneSeatProgram {
	public static void main (String [] args) {
		Scanner keyboard = new Scanner (System.in);

		Airplane seatmap = new Airplane("seatsmap.txt");
		
			
		System.out.println(seatmap.toString());

		int choose = 0;

		do {
			choose = getChoice(keyboard);

			switch (choose) {

			case 1:
				boolean flag = false;
				do {
				System.out.println("Enter a seat to reserve: ");
				String seat = keyboard.next();
				if (seatmap.reserveSeat(seat)) {
					flag = true;
				}
				System.out.print(seatmap.toString());
				seatmap.saveMap("seatsmap.txt");
				}while(!flag);
				break;

			case 2:
				boolean check = false;
				do {
				System.out.println("Enter a seat to free: ");
				String seatFree = keyboard.next();
				if (seatmap.freeSeat(seatFree)) {
					check = true;
				}
				 System.out.print(seatmap.toString());
				 seatmap.saveMap("seatsmap.txt");
				}while(!check);
				break;

			case 3:
				seatmap.saveMap("seatsmap.txt");
				System.out.println("Exiting Program... ");
				break;

			}

		}while (choose > 0 && choose < 3 );

	}




	public static void printOptions() {
		System.out.println("Please select an operation: ");
		System.out.println("1: Reserve a seat ");
		System.out.println("2: Free a Seat ");
		System.out.println("3: Quit Program ");
	}



	public static int getChoice(Scanner input){
		int operation = 0;
		boolean flag = false;

	do {
			printOptions();

				if (input.hasNextInt()) {
					operation = input.nextInt();

					if (operation > 0 && operation < 5) {
						flag = true;
					}

					else {
						input.nextLine();
						System.out.println("Invalid operation choice. ");
						flag = false;
					}

			}
				else {
					System.out.println("You must enter an integer operation 1-3. ");
					continue;
				}


		}while (flag == false);

		return operation;
	}
}
