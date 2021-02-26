package collections;

public class LinkedList<T> implements GenericLinkedListMethods <T> {

	private Node<?> first;

	public LinkedList() {
		first = null;
	}

	public Node<?> getFirstNode(){
		return first;
	}

	public void setFirst(Node<?> first) {
		this.first = first;
	}

	@Override
	public boolean addElement(T t) {
		Node<?> newNode = new Node<T>(t);
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
		boolean deleted = false;

		if(first!=null) {
			if(toDelete.getData() == first.getData()) {
				first = first.getNextNode();
				deleted = true;
			}else {
				Node<?> current = first;
				while(current.getNextNode()!=null && !(toDelete.getData() == current.getNextNode().getData())) {
					current = current.getNextNode();
				}
				if(current.getNextNode()!=null) { //current is before
					current.setNextNode(current.getNextNode().getNextNode());
					deleted = true;
				}
			}
		}
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
		Node<?> current = first;
		while(current!=null) {
			current = current.getNextNode();
			count++;
		}
		return count;
	}
}