
public class Document {
	
	public String text;
	
	public Document() {
		 text = "none";
	}

	
	public Document(String t) {
		text = t;
	}
	
	
	public String getText() {
		return text;
	}

	
	public void setText(String txt) {
		text = txt;
	}
	
	public String toString() {
		return text;
	}
	
}
