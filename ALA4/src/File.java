
public class File extends Document {
	private String pathname;
	private String filetext;
	
	
	public File() {
		pathname = "";
	}
	
	public File(String p) {
		pathname = p;
	}
	
	public String getPathname() {
		return pathname;
	}
	
	public void setPathname(String p) {
		pathname = p;
	}
	
	public String getFiletext() {
		return filetext;
	}
	
	public void setFiletext(String f) {
		filetext = f;
	}
	
	public void toString(String p, String file) {
	 
		System.out.println("Pathname: " + p);
		System.out.println("File: " + filetext);
	}
	
}
