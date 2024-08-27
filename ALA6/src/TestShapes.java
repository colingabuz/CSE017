import java.util.Arrays;
public class TestShapes {
	public static void main (String [] args) {
		Shape [] shapes = new Shape [8];
		
		Circle origCircle = new Circle("Black", 2.5);
		Rectangle origRect = new Rectangle("Red", 5, 3);
		Triangle origTriangle = new Triangle("Green", 6, 6, 8);
		Octagon origOct = new Octagon("Yellow", 7);
		
		shapes[0] = origCircle;
		shapes[1] = origRect;
		shapes[2] = origTriangle;
		shapes[3] = origOct;
		
		shapes[4] = (Circle)(shapes[0].clone()); // create a clone of the first Circle object
		((Circle)shapes[4]).setRadius(1.5); 
		
		shapes[5] = (Rectangle) (shapes[1].clone());
		((Rectangle)shapes[5]).setLength(20);
		
		shapes[6] = (Triangle) origTriangle.clone();
			
		shapes[7] = (Octagon) origOct.clone();
			((Octagon)shapes[7]).setSide(2.5);
			
		
		
			System.out.println("Before Sort");
			System.out.println("------------");
			display(shapes);
		
		
			Arrays.sort(shapes);
			System.out.println("After Sort");
			System.out.println("------------");
			display(shapes);
		
			System.out.println("------------");
			System.out.println();
			double avg = getAveragePerimeter(shapes);
			System.out.println("The average perimeter is: " + avg);
			
	}
	
	public static void display(Shape [] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println("Object " + (i+1) + ": " + list[i].toString());
			System.out.println();
		}
	}
	
	public static double getAveragePerimeter(Shape [] list) {
		double sum = 0.0;
		for(int i = 0; i < list.length; i++) {
			sum += list[i].getPerimeter();
		}
		return sum / list.length;
	}
}
