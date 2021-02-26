package collections;



public class LinkedList<T> implements GenericLinkedListMethods <T> {

	private Node<T> first;

	@Override
	public boolean addElement(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchElement(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteElement(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (first == null) {
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public int size(Node<?> n, int count) {

		if(n == null) {
			return count;
		} else {
			size(n.getNextNode(), count++);
		}
		return count;
	}
}
