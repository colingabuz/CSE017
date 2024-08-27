import java.util.Iterator;
import java.util.ListIterator;
public class DoublyLinkedList<E> implements List<E> {
	private Node<E> head, tail;
	private Node <E> previous;
	private int size;
	
	
	public DoublyLinkedList() { // Constructor
		head = tail = null;
		size = 0;
		previous = null;
	}
	
	
	public DoublyLinkedList(E[] elements) { // Constructor
		for(int i=0; i<elements.length; i++)
			add(elements[i]);
	}
	 
	private class Node<E>{ //Inner class
		E value;
		Node<E> next;
		Node <E> previous;
		Node(E item){ //constructor
			value = item;
			next = null;
			previous = null; 
		}
	}
	
	public int size() {
		return size;
	}
	
	public E getFirst() {// method that returns the head of a node
		if(size == 0)
			return null;
		else
			return head.value;
	}	
	
	public E getLast() { // method that returns the tail of a node
		if (size == 0)
			return null;
		else
			return tail.value;
	}
	
	
	//methods to add to the lists
	public void addFirst(E item) { 
		Node<E> newNode = new Node<E>(item);
		newNode.next = head;
		head = newNode;
		size++;
		if (tail == null)
			tail = head;
	}
	
	public void addLast(E item) {
		Node<E> newNode = new Node<>(item);
		if(tail == null)
			head = tail = newNode;
		else {
			newNode.next = tail.next;
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		size++;
	}
		
	public void add(int index, E item) {
		if(index == 0)
			addFirst(item);
		else if (index >= size)
			addLast(item);
		else {
		 Node<E> current = head;
		 for(int i=0; i<index-1; i++){//find index
			 current = current.next;
		 }
		 Node<E> temp = current.next;
		 Node<E> newNode = new Node<>(item);
		 newNode.previous = current;
		 temp.previous = newNode;
		 newNode.next = temp;
		 size++;
		}
	}
	
	
	//methods to remove items from lists
	public E removeFirst() {
		if (size == 0)
		 return null;
		Node<E> temp = head; 
		head = head.next; 
		head.previous = null;
		size--;
		if(head == null) tail = null;
		return temp.value;
	}
	
	
	public E removeLast() {
		if (size == 0)
		 return null;
		Node<E> current = head;
		current = tail.previous;
		Node<E> temp = tail;
		if(head == tail) {
			head = tail = null; 
			size = 0;
		}
		else {
			tail = current; tail.next = null; size--;
		}
		return temp.value;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size)
		 return null;
		Node<E> temp;
		Node<E> current = head;
		Node <E> temp2;
		for (int i=0; i<index-1; i++)
			current = current.next;
		temp = current.next;
		temp2 = temp.next;
		current.next = temp.next;
		temp2.previous = temp.previous;
		size--;
		return temp.value;
	}
	
	//method to clear a list
	public void clear() {
		size = 0;
		head = tail = null;
	}
	// method to output in string format
	public String toString() {
		String output = "[";
		Node<E> current = head;
		for(int i=0; i<size; i++) {
			output += current.value;
			current = current.next;
		if (i < size-1)
			output += ", ";
		}
			output += "]";
		return output;
	}
	// method to see if an index is valid
	private void checkIndex(int index) {
		 if (index >= size || index < 0)
		 throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	
	public E get(int index) { // method to access a node
		if(size == 0)
			return null;
		checkIndex(index);
		Node<E> current = head;
		for(int i=0; i<index; i++)
			current = current.next;
		return current.value;
	}
	
	public E set(int index, E item) { // method to mutate a node
		if (index < 0 || index >= size)
			return null;
		Node<E> current = head;
		for (int i=0; i<index; i++)
			current = current.next;
		E temp = current.value;
		current.value = item;
		return temp;
	}
	
	public int indexOf(Object e) { // method to find an index of a certain object
		Node<E> current = head;
		for (int i=0; i<size; i++) {
		if (current.value.equals(e))
				return i;
			current = current.next;
			}
		return -1;
	}
	
	public int lastIndexOf(Object e) { // method to find the last instance of an object in a list
		for (int i=size-1; i>=0; i--) {
			if (get(i).equals(e))
				return i;
			}
		return -1;
	}
	
	public boolean contains(Object e) { // method to see if an object is in the list
		Node<E> current = head;
		for(int i=0; i<size; i++)
			if(e.equals(current.value))
				return true;
		return false;
	}
	
	
	//iterator methods
	public ListIterator<E> iterator(){
		 return new DoublyLinkedListIterator();
	}
	
	
	public ListIterator<E> iterator(int index){
		return new DoublyLinkedListIterator(index);
	}
	
	//iterator class
	private class DoublyLinkedListIterator implements ListIterator<E>{
		private Node<E> current = head;
		
		
		public DoublyLinkedListIterator() {// constructor to start at first 
			current = head;
		}
		
		public DoublyLinkedListIterator(int index) { // constructor to start at index
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		}
		
		
		public boolean hasNext() { // method to see if there are more nodes
			return current != null;
		}
		
		
		public E next() { // method to connect two nodes
			E temp = current.value;
			current = current.next;
		return temp;
	}
		
		
		public void remove() { // method to remove a node
			if(current == null)
				throw new IllegalStateException();
			   DoublyLinkedList.this.remove(indexOf(current.value));
			}

		public boolean hasPrevious(){ // method to see if there is a previous node	
			return current != null;
		}
		
		public int nextIndex() { // method to see the next index after an object
			Node<E> temp = head;
			for (int i = 0; i < size(); i++) {
				if (temp == current) {
					current = current.next;
					return i;
				}
			}
			return -1; 
		}
		
		
		public void set(E e) { // method to change the value of a node
			current.value = e;
		}
		
		public void add(E e) { // method to add a node
			Node<E> temp = new Node<E>(e);
			Node<E> temp2 = current.next;
			current.next = temp;
			temp.next = temp2; 
			temp2.previous = temp;
			temp.previous = current;
		}
		
		public E previous() {// method to make previous values
			E temp = current.value;
			current = current.previous;
			return temp; 
		}
		
		public int previousIndex() { // method to get previous indices of objects
			Node<E> temp = head; 
			for (int i = 0; i < size(); i++) {
				if (temp == current) {
					current = current.previous;
					return i;
				}
			}
			return -1;
		}
		
	}
	
	public int searchComparisons(E item) { // method to count comparisons
		int comparisons = 0; 
		Iterator <E> iter = iterator();
		while(iter.hasNext()) {
			comparisons++;
			if(iter.next().equals(item)) {
				return comparisons;
			}
		}
		return comparisons;
	}
}
