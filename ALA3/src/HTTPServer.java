import java.util.Scanner;
public class HTTPServer {
	public static void main(String [] args) {
		Scanner input = new Scanner (System.in);
		
		Stack requestStack = new Stack(50);
		
		System.out.println("Welcome to my HTTP server. ");
		
		
		int op = 0;
		
		String [] list = requestStack.getElements();
		
		int current = requestStack.getSize();
		
		do {
			op = getChoice(input);
			
			switch(op) {
			
			case 1: 
				
				System.out.print("Enter the page URL: ");
				
				String regex = "(http(s)?)://w{3}(.)*(.)(com|net|org|gov|edu)";
				
				String url = input.nextLine();
				
				while (!url.matches(regex)) {
					System.out.println("Invalid URL. Try again. ");
					System.out.print("Enter the page URL: ");
					url = input.nextLine();
			}
				requestStack.push(url);
				System.out.println("Request added successfully");
				 break;
				
			case 2:
				boolean empty = requestStack.empty();
				if (empty) {
					System.out.println("The stack is empty. ");
				}
				else {
					requestStack.top(requestStack.getElements());
				}
			
				
				System.out.println("The last request was: " + list[requestStack.getSize() - 1]);
				break;
				
			case 3:
				boolean ifEmpty = requestStack.empty();
				if (ifEmpty) {
					System.out.println("The stack is empty. ");
				}
				else {
					requestStack.pop(requestStack.getElements());
				}
			System.out.println("Last request: " + list[requestStack.getSize()]);
			System.out.println("Request removed successfully.");
				break;
				
				
			default: 
				System.out.println("Exiting program... ");
				break;
		} 
	} while(op > 0 && op < 4);
}	
	
	
	
	public static int getChoice(Scanner input){
		int operation = 0;
		
	do {
			printOptions();
				if (input.hasNextInt()) {
					operation = input.nextInt();
			
					if (operation > 0 && operation < 5) {
						break;
					}
		
					else {
						input.nextLine();
						System.out.println("Invalid operation choice. ");
						continue;
					}
			}
		
			
		}while (true);
			
		return operation;
	}
	
	public static void printOptions() {
		System.out.println("Please select an operation: ");
		System.out.println("1: Enter a new request ");
		System.out.println("2: View the last request ");
		System.out.println("3: Remove the last request ");
		System.out.println("4: Quit program");
	}
		
}
