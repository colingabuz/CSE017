
public class Octagon extends Shape{
	private double side;
	
	public Octagon() {
		super();
		side = 0.0;
	}
	
	public Octagon(String color, double side) {
		super(color);
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	public String toString() {
		return  "Octagon " + "\nColor: " + this.getColor() + "\nSide: " + this.getSide() + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter();

	}
	
	public double getArea() {
		return (2 + 4*(Math.sqrt(2))) * (side*side);
	}
	
	public double getPerimeter() {
		return (side*8);
	}
	
	public Object clone() {
		return new Octagon(this.getColor(), this.getSide());
	}
}
