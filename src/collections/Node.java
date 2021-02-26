package collections;

public class Node <T>{

	private Node<?> nextNode;
	private T data;
	
	public Node(T data) {
		this.data = data;
	}

	public Node<?> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<?> newNode) {
		this.nextNode = newNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}