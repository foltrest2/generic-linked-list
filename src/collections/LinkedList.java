package collections;

public class LinkedList<T extends Comparable<T>> implements GenericLinkedListMethods <T>, Comparable<T> {

	private Node<T> first;

	public LinkedList() {
		first = new Node<T>(null);
	}

	public Node<T> getFirstNode(){
		return first;
	}

	public void setFirst(T t) {
		first.setData(t);
	}

	@Override
	public boolean addElement(T t) {
		Node<T> newNode = new Node<T>(t);
		boolean exists = searchElement(t);
		if (!exists) {
			if(first==null) {
				first = newNode;
				return true;
			}
			if (t.compareTo(first.getData()) < 0) {
				newNode.setNextNode(first);
				first = newNode;
				return true;
			}
			else {
				Node<T> current = first;
				Node<T> before = null;
				while(current.getNextNode()!=null && current.getData().compareTo(newNode.getData())<0) {
					before = current;
					current = current.getNextNode();
				}
				newNode.setNextNode(current);
				before.setNextNode(newNode);
				return true;
			}
		}
		else 
			return false;
	}

	@Override
	public boolean searchElement(T t) {
		Node<T> n = new Node<T>(t);
		Node<T> search = null;
		Node<T> current = first;
		if (first.getData() == null) {
			return false;
		}
		else {
			while(current!=null && search==null) {
				if(n.getData().toString().equals(current.getData().toString())) {
					search = current;
				}
				current = current.getNextNode();
			}
			if (search != null) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public T getItem(int n) {
		Node<T> search = null;
		Node<T> current = first;
		while(n > 0) {
			current = current.getNextNode();
			n--;
		}
		search = current;
		
		return search.getData();
	}
	
	@Override
	public boolean deleteElement(T t) {
		boolean deleted = false;
		Node<T> toDelete = new Node<T>(t);
		Node<T> temp = first, prev = null;

		if (temp != null && temp.getData() == toDelete.getData()) {
			first = temp.getNextNode(); 	
			return deleted = true;
		}
		while (temp != null && temp.getData() != toDelete.getData()) {
			prev = temp;
			temp = temp.getNextNode();
		}
		if (temp == null) {
			return deleted;
		}
		prev.setNextNode(temp.getNextNode()); //Lag, ping 999999
		return deleted;
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
	public int size() {
		int count = 0;
		Node<T> current = first;
		while(current!=null) {
			current = current.getNextNode();
			count++;
		}
		return count;
	}

	@Override
	public int compareTo(T o) {

		return 0;
	}
}