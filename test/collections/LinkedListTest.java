package collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



class LinkedListTest {
	private LinkedList<Object> lk = new LinkedList<>();

	public void setupScenary_1(){
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		lk.setFirst(n1);
		lk.getFirstNode().setNextNode(n2);
		lk.getFirstNode().getNextNode().setNextNode(n3);
	}
	public void setupScenary_2(){
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		lk.setFirst(n1);
		lk.getFirstNode().setNextNode(n2);
		lk.getFirstNode().getNextNode().setNextNode(n3);
		lk.deleteElement(n1);
	}

	@Test
	void size_test() {
		setupScenary_1();
		assertEquals("Fail size test", 3, lk.size());
		assertEquals("Fail size test", 1, lk.getFirstNode().getData());
	}
	
	@Test
	void empty_test() {
		assertNull("Fail empty test", lk.getFirstNode());
	}
	
	@Test
	void delete_test() {
		setupScenary_1();
		assertEquals("Fail size test", 2, lk.getFirstNode().getData());
	}

}
