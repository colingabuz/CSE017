
public class Pair <E1, E2>{
	private E1 first;
	private E2 second;
	
	public Pair() { // Constructor
		first = null;
		second = null;
	}
	
	
	public Pair(E1 first, E2 second) { // Constructor
		this.first = first;
		this.second = second;
	}
	
	public E1 getFirst() { // Accessor
		return first;
	}
	
	
	public E2 getSecond() { // Accessor
		return second;
	}
	
	
	public void setfirst(E1 set) { //Mutator
		first = set;
	}
	
	
	public void setsecond(E2 set) { // Mutator
		second = set;
	}
	
	
	public String toString() { // Method to display information as a string
		return (first + " " + second);	
	}
	
	
	public boolean equals(Object obj) { // method to see if second objects are the same
		Pair<E1, E2> pair = (Pair<E1, E2>) obj;
		 boolean eq = pair.getFirst().equals(first);
		 eq = eq && pair.getSecond().equals(second);
		 return eq;
		}
}
