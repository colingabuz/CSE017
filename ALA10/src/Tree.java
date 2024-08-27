
import java.util.Collection;
import java.util.Iterator;
public interface Tree<E> extends Collection<E> {
	// abstract methods of the interface Tree
		public boolean search(E item);
		public boolean insert(E item);
		public boolean delete(E item);
		public void inorder();
		public void preorder();
		public void postorder();
		public int size();
		public void clear();

	  // default definitions for the methods
	  // from the interface Collection
		  default boolean add(E item) {
			  return insert(item);
		  }
		  default boolean isEmpty() {
			  return size()==0;
		  }
		  default boolean remove(Object e) {
			  return delete((E) e);
		  }
		  default public boolean contains(Object e) {
				return search((E) e);
		  }
		  default boolean containsAll(Collection<?> c) {
			  for(Object e: c)
				  if (!search((E) e))
					  return false;
			  return true;
		  }
		 
		  default boolean addAll(Collection<? extends E> c)     
		  {
			  boolean changed = false;
			  for(Object e: c)
				  if (!search((E) e)) {
					  insert((E) e);
					  changed = true;
				  }
			  return changed;
		  }
		  default boolean removeAll(Collection<?> c) {
			  boolean changed = false;
			  for(Object e: c)
				  if (search((E) e)) {
					  remove(e);
					  changed = true;
				  }
			  return changed;
		  }
		  default boolean retainAll(Collection<?> c) {
			  boolean changed = false;
			  for(Object e: c)
				  if (!search((E) e)) {
					  remove(e);
					  changed = true;
				  }
			  return changed;
		  }
		  default Object[] toArray() {
			  Object[] objects = new Object[size()];
			  Iterator<E> iter = iterator();
			  int i=0;
			  while(iter.hasNext())
				  objects[i] = iter.next();
			  return objects;
		  }
		 
		  default <T> T[] toArray(T[] array) {
			  Iterator<E> iter = iterator();
			  int i=0;
			  while(iter.hasNext())
				  array[i] = (T) iter.next();
			  return array;
		  }
}
