
public class Circle extends Shape{
	private double radius;
	
	
	public Circle() {
		radius = 0.0;
	}
	
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	public String toString() {
		return  "Circle " + "\nColor: " + this.getColor() + "\nRadius: " + this.getRadius() + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter();

	}
	
	
	public double getArea() {
		return (radius * radius) * Math.PI;

	}
	
	public double getPerimeter() {
		return (radius * 2) * Math.PI;

	}
	
	public Object clone() {
		return new Circle(this.getColor(), this.getRadius());

	}
}
