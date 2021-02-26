package collections;

public interface GenericLinkedListMethods <T>{
	
	public boolean addElement(T t);
	public boolean searchElement(T t);
	public boolean deleteElement(Node<?> n);
	public boolean isEmpty();
	public int size(Node<?> n, int count);
	
}
