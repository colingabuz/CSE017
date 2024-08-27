import java.util.Iterator;

public class ArrayList<E> implements List<E> {
	private E[] elements;
	 private int size;

	 public ArrayList() {
		 elements = (E[]) new Object[10];
		 size = 0;
	 }
	 
	 
	 public ArrayList(E[] objects) {
		 elements = (E[]) new Object[objects.length];
		 	for(int i=0; i<objects.length; i++)
		 		add(objects[i]);
	 }
	 
	 
	 public int size() {
		 return size;
	 }
	 
	 private void ensureCapacity() {
		 if(size >= elements.length) {
			 E[] newElements = (E[])new Object[(int)(size * 1.5)];
			 System.arraycopy(elements, 0, newElements, 0, size);
			 elements = newElements;
		 }
	}
	 
		private void checkIndex(int index) {
		 if (index >= size || index < 0)
			 throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		
		
		public void trimToSize() {
		 if(size != elements.length) {
			 E[] newElements = (E[]) new Object[size];
			 System.arraycopy(elements, 0, newElements, 0, size);
			 elements = newElements;
		  }
		}
	 
		public void clear() {
			 elements = (E[]) new Object[10];
			 size = 0;
		}
		
		public boolean contains(Object e) {
			for(int i=0; i<size; i++)
				if(e.equals(elements[i]))
					return true;
			 return false;
		}
			
			
		public int indexOf(Object e) {
			for(int i=0; i<size; i++)
				if(e.equals(elements[i]))
					return i;
			 return -1;
		}
		
		public int lastIndexOf(Object e) {
			for(int i=size-1; i >= 0; i--)
				if(e.equals(elements[i]))
					return i;
			 return -1;
		}
		
		public void add(int index, E item) {
			if(index < 0 || index > size)
			 throw new IndexOutOfBoundsException("Index:" +index + ", size: " + size);
				ensureCapacity();
			for(int i=size-1 ; i>=index; i--)
				elements[i+1] = elements[i];
				elements[index] = item;
				size++;
		}
		
		
		public E get(int index) {
			checkIndex(index);
				return elements[index];
		}
		
		public E remove(int index) {
		 checkIndex(index);
		 	E item = elements[index];
			 for(int i=index; i<size-1; i++)
				 elements[i] = elements[i+1];
			 	 elements[--size] = null;
			 return item;
		}
		
		
		public E set(int index, E item) {
			checkIndex(index);
			 E oldItem = elements[index];
			 elements[index] = item;
			 return oldItem;
		}
		
		
		public String toString() {
			String output = "[";
			 for(int i=0; i<size; i++) {
			 output += elements[i].toString();
			 if (i<size-1)
			 output += ", ";
			}
		 return output + "]";
		}
		
		public Iterator<E> iterator(){
			 return new ArrayListIterator();
			}
			
		private class ArrayListIterator implements Iterator<E>{
			 private int current = -1;
			 
			 public boolean hasNext() {
				 return current < size;
			 }
			 
			 public E next() {
				 return elements[++current];
			 }
			 
			 
			 public void remove() {
				 if(current < 0)
					 throw new IllegalStateException();
				 	 ArrayList.this.remove(current--);
			 	}
			}
		
		public int searchComparisons(E item) {
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
