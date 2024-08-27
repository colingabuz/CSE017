
public abstract class Shape implements Cloneable, Comparable<Shape> {
	private String color;
	
	protected Shape() {
		color = "";
	}
	
	protected Shape(String s) {
		color = s;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return color;
	}
	
	public int compareTo(Shape obj) {
		if(this.getArea() == obj.getArea()) {
			return 0;
		}
		else if (this.getArea() > obj.getArea()) {
			return 1;
		}
		else return -1;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public Object clone() {
		return this;
	}
}
