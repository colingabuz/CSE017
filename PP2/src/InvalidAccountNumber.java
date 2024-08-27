
public class InvalidAccountNumber extends Exception{
	public InvalidAccountNumber() {
		super("Invalid Account Number (must be 5 digits). ");
	}
	
	public InvalidAccountNumber(String message) {
		super(message);
	}
}
