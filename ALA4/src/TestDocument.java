
public class TestDocument {
	public static void main(String [] args) {
		Email myEmail = new Email("boo111@lehigh.edu", "hoo111@lehigh.edu", "Late Working Hours");
		myEmail.setText("Hello," + "\n" + "This is a reminder for your approval of late working hours on 1/24/2020." + "\n" + "Best regards, " + "\n" + "Ben");
		myEmail.toString(myEmail.getSender(), myEmail.getRecipient(), myEmail.getSubject());
		
		File myFile = new File ("/home/boo111/CSE17/Practice.java");
		myFile.setFiletext("public class Lab1 {" + "\n" + "\t" + "public static void main(String [] args){" + "\n" + "\t" + "System.out.println('Hello World!');" + "\n" + "} // end of main method" + "\n" + "} // end of class Lab1");
		myFile.toString(myFile.getPathname(), myFile.getFiletext());
		
		boolean emailLate = containsKeyword(myEmail, "Late");
		System.out.println(emailLate);
		boolean fileLate = containsKeyword(myFile, "Late");
		boolean emailHello = containsKeyword(myEmail, "Hello");
		boolean fileHello = containsKeyword(myFile, "Hello");
		
		
		if ((emailLate == true) && (fileLate == true)) {
			System.out.println("Both the email and the file contain the word 'Late' ");
		}
		else if ((emailLate == true) && (fileLate == false)) {
			System.out.println("Only the email contains the word 'Late");
		}
		else if ((emailLate == false) && (fileLate == true)) {
			System.out.println("Only the file contains the word 'Late' ");
		}
		else {
			System.out.println("Neither the file nor email contain the word 'Late' ");
		}
		
		
		if ((emailHello == true) && (fileHello == true)) {
			System.out.println("Both the email and the file contain the word 'Hello' ");
		}
		else if ((emailHello == false) && (fileHello == true)) {
			System.out.println("Only the file contains the word 'Hello' ");
		}
		else if ((emailHello == true) && (emailHello == false)) {
			System.out.println("Only the email contains the word 'Late");
		}
		else { 
			System.out.println("Neither the file nor email contain the word 'Hello' ");		
	}
}	
	
	public static boolean containsKeyword(Document docObject, String keyword) {
		if (docObject.toString().contains(keyword)) 
			return true;
		else
			return false;
	}
	
	
	
}
