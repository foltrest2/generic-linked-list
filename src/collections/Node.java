package collections;

public class Node <T1>{

	private Node<?> nextNode;
	private T1 data;
	
	
	public Node(T1 data) {
		this.data = data;
	}



	public Node<?> getNextNode() {
		return nextNode;
	}


	public void setNextNode(Node<?> nextNode) {
		this.nextNode = nextNode;
	}


	public T1 getData() {
		return data;
	}


	public void setData(T1 data) {
		this.data = data;
	}
}