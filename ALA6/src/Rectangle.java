
public class Rectangle extends Shape{
	private double length;
	private double width;
	
	
	public Rectangle() {
		length = 0.0;
		width = 0.0;
	}
	
	public Rectangle(String c, double length, double width) {
		super(c);
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public String toString() {
		return "Rectangle " + "\nColor: " + this.getColor() + "\nLength: " + this.getLength() + "\nWidth: " + this.getWidth() + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter();

	}
	
	public double getArea() {
		return (length * width);
	}
	
	public double getPerimeter() {
		return ((length *2) + (width *2));
	}
	
	public Object clone() {
		return new Rectangle(this.getColor(), this.getLength(), this.getWidth());
	}
}
