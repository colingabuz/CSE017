
public class Stack {
	private String [] elements;
	private int size;
	private int capacity;
	
	
	Stack(){
		elements = new String[20];
		size = 0;
		capacity = 20;
	}
	
	
	
	
	Stack(int cap){
		elements = new String[cap];
		size = 0; 
		capacity = cap;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setCapacity(int cap) {
		capacity = cap;
	}
	
	public void setSize(int n) {
		size = n;
	}
	
	public void setElements(String [] list) {
		elements = list;
	}
	
	public boolean empty() {
		boolean check = false; 
		
		if (size == 0) {
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}
	
	
	public String top(String [] elements) {
		String last = elements[size -1];
		
		return last;
	}
	
	
	
	public void push(String update) {
		size++;
		elements[size -1] = update;
	}
	
	
	public String pop(String [] elements) {
		size--;
		return elements[size];
	}
	
	
	public int size(String [] elements) {
		int currLength = size;
		return currLength;
	}
	
	
	public String [] getElements() {
		String [] queueList = elements;
		return queueList;
	}
	
	
}
