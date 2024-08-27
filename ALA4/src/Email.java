
public class Email extends Document{
	private String sender;
	private String recipient;
	private String subject;
	
	
	public Email() {
		sender = "";
		recipient = "";
		subject = "";
	}
	
	public Email(String a, String b, String c) {
		sender = a;
		recipient = b;
		subject = c;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setSender(String s) {
		sender = s;
	}
	
	public void setRecipient(String r) {
		recipient = r;
	}
	
	
	public void setSubject(String sub) {
		subject = sub;
	}
	
	
	public void toString(String sender, String recipient, String subject) {
		System.out.println("From: " + sender);
		System.out.println("To: " + recipient);
		System.out.println("Subject: " + subject);
		System.out.println("Body: ");
		String email = text;
		System.out.println(email);
		System.out.println();
	}
	
	
	
}
