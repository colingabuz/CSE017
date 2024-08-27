
public class InvalidSeatException extends Exception {
	public String excepMessage;
	
	public InvalidSeatException(){
		 excepMessage = "";
	}
	
	
	public InvalidSeatException(String message) {
		//System.out.println(message);
	}
	
}
