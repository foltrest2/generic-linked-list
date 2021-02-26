package collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.Test;

class LinkedListTest {
	private LinkedList<Integer> lk = new LinkedList<>();
//	private LinkedList<String> lk2 = new LinkedList<>();

	public void setupScenary_1(){
		lk.setFirst(1);
		lk.getFirstNode().setNextNode(new Node<Integer>(2));
		lk.getFirstNode().getNextNode().setNextNode(new Node<Integer>(3));
	}
	public void setupScenary_2(){
		lk.setFirst(1);
		lk.getFirstNode().setNextNode(new Node<Integer>(2));
		lk.getFirstNode().getNextNode().setNextNode(new Node<Integer>(3));
		lk.deleteElement(2);
	}
	
	public void setupScenary_3(){
		lk.setFirst(1);
		lk.getFirstNode().setNextNode(new Node<Integer>(2));
		lk.getFirstNode().getNextNode().setNextNode(new Node<Integer>(3));
		lk.getFirstNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(4));
		lk.deleteElement(3);
	}
	
	public void setupScenary_4(){
		lk.setFirst(1);
		lk.getFirstNode().setNextNode(new Node<Integer>(2));
		lk.getFirstNode().getNextNode().setNextNode(new Node<Integer>(3));
		lk.deleteElement(1);
		lk.deleteElement(3);
	}
	
	public void setupScenary_5(){
		lk.setFirst(4);
		lk.getFirstNode().setNextNode(new Node<Integer>(6));
		lk.getFirstNode().getNextNode().setNextNode(new Node<Integer>(8));
		lk.getFirstNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(12));
		lk.getFirstNode().getNextNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(15));
	}

	@Test
	void size_test() {
		setupScenary_1();
		assertEquals("Fail size test", 3, lk.size());
		assertEquals("Fail size test", new Integer(1), lk.getFirstNode().getData());
	}
	
	@Test
	void empty_test() {
		assertNull("Fail empty test", lk.getFirstNode().getData());
	}
	
	@Test
	void delete_test_1() {
		setupScenary_2();
		assertEquals("Fail delete test 1", new Integer(1), lk.getFirstNode().getData());
		assertEquals("Fail delete test 1", new Integer(3), lk.getFirstNode().getNextNode().getData());
		assertEquals("Fail size test", 2, lk.size());
	}
	
	@Test
	void delete_test_2() {
		setupScenary_3();
		assertEquals("Fail delete test 1", new Integer(1), lk.getFirstNode().getData());
		assertEquals("Fail delete test 1", new Integer(4), lk.getFirstNode().getNextNode().getNextNode().getData());
		assertNull("Fail empty test", lk.getFirstNode().getNextNode().getNextNode().getNextNode());
		assertEquals("Fail size test", 3, lk.size());
	}
	
	@Test
	void delete_test_3() {
		setupScenary_4();
		assertEquals("Fail delete test 1", new Integer(2), lk.getFirstNode().getData());
		assertNull("Fail empty test", lk.getFirstNode().getNextNode());
		assertEquals("Fail size test", 1, lk.size());
	}
	
	@Test
	void add_test_1() {
		setupScenary_1();
		lk.getFirstNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(5));
		lk.addElement(4);
		assertEquals("Fail add test", new Integer(4), lk.getFirstNode().getNextNode().getNextNode().getNextNode().getData());
	}
	
	@Test
	void add_test_2() {
		setupScenary_5();
		lk.addElement(1);
		lk.addElement(7);
		lk.addElement(11);
		assertEquals("Fail add test", new Integer(1), lk.getFirstNode().getData());
		assertEquals("Fail add test", new Integer(7), lk.getFirstNode().getNextNode().getNextNode().getNextNode().getData());
		assertEquals("Fail add test", new Integer(11), lk.getFirstNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getData());
	}
}
