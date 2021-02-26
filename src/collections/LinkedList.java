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
		Node<T> newNode = new Node<T>(t);
		boolean exists = searchElement(newNode);
		if (exists) {
			if(first==null) {
				first = newNode;
				return true;
			}else {
				Node<?> current = first;
				while(current.getNextNode()!=null && current.getData().toString().compareTo(newNode.getData().toString())<0	) {
					current = current.getNextNode();
				}
				current.setNextNode(newNode);
				return true;
			}
		}
		else 
			return false;
	}

	@Override
	public boolean searchElement(Node<?> n) {
		Node<?> search = null;
		Node<?> current = first;
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

	@Override
	public boolean deleteElement(Node<?> toDelete) {
		boolean deleted = false;
		// Store head node
		Node<?> temp = first, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.getData() == toDelete.getData()) {
			first = temp.getNextNode(); // Changed head
			return deleted = true;
		}

		// Search for the key to be deleted, keep track of
		// the previous node as we need to change temp.next
		while (temp != null && temp.getData() != toDelete.getData()) {
			prev = temp;
			temp = temp.getNextNode();
		}

		// If key was not present in linked list
		if (temp == null)
			return deleted;

		// Unlink the node from linked list
		prev.setNextNode(temp.getNextNode());
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