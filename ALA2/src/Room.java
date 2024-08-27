
public class Room {
	private String name;
	private String location;
	private int capacity;
	private double length;
	private double width;
	
	public Room(){
		name = "none";
		location = "none";
		capacity = 0;
		length = 0.0;
		width = 0.0;
	}
	
	public Room (String n, String loc, int c, double l, double w){
		name = n;
		location = loc;
		capacity = c;
		length = l;
		width = w;
	}
		
	public double getArea(double l, double w) {
		double area = l * w;
		return area;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public void setCapacity(int c) {
		capacity = c;
	}
	public void setLocation(String loc) {
		location = loc;
	}
	public void setName(String n) {
		name = n;
	}
	public void setLength(double l) {
		length = l;
	}
	public void setWidth(double w) {
		width = w;
	}
}
