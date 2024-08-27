import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class PostfixExpression {
	public static void main (String [] args) {
		
		Scanner keyboard = new Scanner(System.in); // makes a scanner to read postfix input from user
		
		Stack<Integer> postfixStack = new Stack<Integer>(); // instantiates the Stack class
		
		System.out.println("Enter a postfix expression: "); //prompt user to enter a postfix expression
		
		String expression = keyboard.nextLine();
		
		String [] split = expression.split(" ");
		
		int type = 0;
		
		try {
			for (int i = 0; i < split.length; i++) { // assign values to the types of entries
				if(split[i].equals("*") || split[i].equals("/") || split[i].equals("+") || split[i].equals("-")) {
					type = 1;
				}
				else {
					type = 2;
				}
				
				switch (type) { // switch to perform operations depending on what is entered
				case 1: 
						int first = postfixStack.pop();
						int second = postfixStack.pop();
						
						if (split[i].equals("*"))
							postfixStack.push(first*second);
						if (split[i].equals("/"))
							postfixStack.push(second/first);
						if (split[i].equals("+"))
							postfixStack.push(first + second);
						if (split[i].equals("-"))
							postfixStack.push(second - first);
						break;
						
				case 2: 
					postfixStack.push(Integer.valueOf(split[i]));
					break;
					
					default: 
						System.out.println("This character is invalid. ");
						postfixStack.push(postfixStack.pop());
						postfixStack.push(postfixStack.pop());
				}
			}
			
			int result = postfixStack.pop();
			if (postfixStack.isEmpty()) { // if the stack is empty the user is informed 
				System.out.println("the resut  of the postfix expression is: " + result);
			}else {
				System.out.println("Postfix Expression Malformed. ");
			}
			System.exit(0);
		} 
		
			catch(EmptyStackException e) { // if the stack is empty an exception is thrown and caught
			System.out.println(e.getMessage());
		}
	}
}
