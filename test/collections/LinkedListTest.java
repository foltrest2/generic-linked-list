package collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
		lk.deleteElement(n2);
	}
	
	public void setupScenary_3(){
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		lk.setFirst(n1);
		lk.getFirstNode().setNextNode(n2);
		lk.getFirstNode().getNextNode().setNextNode(n3);
		lk.getFirstNode().getNextNode().getNextNode().setNextNode(n4);
		lk.deleteElement(n3);
	}
	
	public void setupScenary_4(){
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		lk.setFirst(n1);
		lk.getFirstNode().setNextNode(n2);
		lk.getFirstNode().getNextNode().setNextNode(n3);
		lk.deleteElement(n1);
		lk.deleteElement(n3);
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
	void delete_test_1() {
		setupScenary_2();
		assertEquals("Fail delete test 1", 1, lk.getFirstNode().getData());
		assertEquals("Fail delete test 1", 3, lk.getFirstNode().getNextNode().getData());
		assertEquals("Fail size test", 2, lk.size());
	}
	
	@Test
	void delete_test_2() {
		setupScenary_3();
		assertEquals("Fail delete test 1", 1, lk.getFirstNode().getData());
		assertEquals("Fail delete test 1", 4, lk.getFirstNode().getNextNode().getNextNode().getData());
		assertNull("Fail empty test", lk.getFirstNode().getNextNode().getNextNode().getNextNode());
		assertEquals("Fail size test", 3, lk.size());
	}
	
	@Test
	void delete_test_3() {
		setupScenary_4();
		assertEquals("Fail delete test 1", 2, lk.getFirstNode().getData());
		assertNull("Fail empty test", lk.getFirstNode().getNextNode());
		assertEquals("Fail size test", 1, lk.size());
	}
}
