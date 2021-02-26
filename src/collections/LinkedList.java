package collections;

import java.util.Comparator;

public class LinkedList<T> implements GenericLinkedListMethods <T> {

	private Node<T> first;

	public LinkedList() {
		first = null;
	}

	public Node<T> getFirstNode(){
		return first;
	}

	@Override
	public boolean addElement(T t) {
		Node<T> newNode = new Node<T>(t);
		if(first==null) {
			first = newNode;
		}else {
			Node<?> current = first;
			while(current.getNextNode()!=null) {
				current = current.getNextNode();
			}
			current.setNextNode(newNode);
		}
		return false;
	}

	@Override
	public boolean searchElement(T t) {
		Node<?> n = null;
		Node<?> current = first;
		while(current!=null && n==null) {
			if(t.equals(current.getData())) {
				n = current;
			}
			current = current.getNextNode();
		}
		if (n != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteElement(Node<?> toDelete) {
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