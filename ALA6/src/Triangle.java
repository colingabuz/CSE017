
public class Triangle extends Shape{
	private double side1;
	private double side2;
	private double side3;
	
	
	public Triangle() {
		side1 = 0.0;
		side2 = 0.0;
		side3 = 0.0;
	}
	
	public Triangle(String c, double side1, double side2, double side3) {
		super(c);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}
	
	public void setSide1(double s1) {
		side1 = s1;
	}
	
	public void setSide2(double s2) {
		side2 = s2;
	}
	
	public void setSide3(double s3) {
		side3 = s3;
	}
	
	public double getArea() {
		double step1 = (side1 + side2 + side3) /2;
		double area = step1 * ((step1 - side1) * (step1 - side2) * (step1 - side3));
		return Math.sqrt(area);
	}
	
	public double getPerimeter() {
		return (side1 + side2 + side3);
	}
	
	public String toString() {
		return "Triangle" + "\nColor: " + this.getColor() + "\nSide 1 = " + side1 + "\nSide 2 = " + side2  + "\nSide 3 = " + side3  + "\nArea = " + this.getArea() + "\nPerimeter = " + this.getPerimeter();
	}
	
	public Object clone() {
		return new Triangle(this.getColor(), this.getSide1(), this.getSide2(), this.getSide3());
	}
	
}
