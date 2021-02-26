package collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.Test;

class LinkedListTest {
	private LinkedList<Integer> lk = new LinkedList<>();
	private LinkedList<String> lk2 = new LinkedList<>();

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

	public void setupScenary_6() {
		lk2.setFirst("d");
		lk2.getFirstNode().setNextNode(new Node<String>("g"));
		lk2.getFirstNode().getNextNode().setNextNode(new Node<String>("j"));
	}
	
	public void setupScenary_7() {
		lk.addElement(new Integer(20));
	}

	@Test
	public void size_test() {
		setupScenary_1();
		assertEquals("Fail size test", 3, lk.size());
		assertEquals("Fail size test", new Integer(1), lk.getFirstNode().getData());
	}

	@Test
	public void empty_test() {
		assertNull("Fail empty test", lk.getFirstNode().getData());
	}

	@Test
	public void delete_test_1() {
		setupScenary_2();
		assertEquals("Fail delete test 1", new Integer(1), lk.getFirstNode().getData());
		assertEquals("Fail delete test 1", new Integer(3), lk.getFirstNode().getNextNode().getData());
		assertEquals("Fail size test", 2, lk.size());
	}

	@Test
	public void delete_test_2() {
		setupScenary_3();
		assertEquals("Fail delete test 1", new Integer(1), lk.getFirstNode().getData());
		assertEquals("Fail delete test 1", new Integer(4), lk.getFirstNode().getNextNode().getNextNode().getData());
		assertNull("Fail empty test", lk.getFirstNode().getNextNode().getNextNode().getNextNode());
		assertEquals("Fail size test", 3, lk.size());
	}

	@Test
	public void delete_test_3() {
		setupScenary_4();
		assertEquals("Fail delete test 1", new Integer(2), lk.getFirstNode().getData());
		assertNull("Fail empty test", lk.getFirstNode().getNextNode());
		assertEquals("Fail size test", 1, lk.size());
	}

	@Test
	public void delete_test_4() {
		lk.addElement(new Integer(0));
		assertEquals("Fail delete test", true, lk.deleteElement(new Integer(0)));
	}
	
	@Test
	public void delete_test_5() {
		assertEquals("Fail delete test", false, lk.deleteElement(new Integer(0)));
	}
	
	@Test
	public void delete_test_6() {
		setupScenary_6();
		assertEquals("Fail delete test", true, lk2.deleteElement("d"));
		assertEquals("Fail delete test", true, lk2.deleteElement("j"));
		assertEquals("Fail delete test", 1, lk2.size());
	}
	
	@Test
	public void add_test_1() {
		setupScenary_1();
		lk.getFirstNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(5));
		lk.addElement(4);
		assertEquals("Fail add test1", new Integer(4), lk.getFirstNode().getNextNode().getNextNode().getNextNode().getData());
	}

	@Test
	public void add_test_2() {
		setupScenary_5();
		lk.addElement(1);
		lk.addElement(7);
		lk.addElement(11);
		assertEquals("Fail add test2", new Integer(1), lk.getFirstNode().getData());
		assertEquals("Fail add test2", new Integer(7), lk.getFirstNode().getNextNode().getNextNode().getNextNode().getData());
		assertEquals("Fail add test2", new Integer(11), lk.getFirstNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getData());
	}

	@Test
	public void add_test_3() {
		setupScenary_6();
		lk2.addElement("c");
		lk2.addElement("f");
		lk2.addElement("h");
		assertEquals("Fail add test3", "c", lk2.getFirstNode().getData());
		assertEquals("Fail add test3", "f", lk2.getFirstNode().getNextNode().getNextNode().getData());
		assertEquals("Fail add test3", "h", lk2.getFirstNode().getNextNode().getNextNode().getNextNode().getNextNode().getData());
	}

	@Test
	public void search_test_1() {
		setupScenary_5();
		boolean found = lk.searchElement(8);
		assertEquals("Fail search test", true, found);
	}

	@Test
	public 	void search_test_2() {
		setupScenary_6();
		boolean found = lk2.searchElement("j");
		assertEquals("Fail search test", true, found);
	}

	@Test
	void search_test_3() {
		boolean found = lk.searchElement(1);
		assertEquals("Fail search test", false, found);
	}
	
	@Test
	public void get_item_test_1() {
		setupScenary_3();
		assertEquals("Fail get item test", new Integer(1), lk.getItem(0));
		assertEquals("Fail get item test", new Integer(4), lk.getItem(2));
	}

	@Test
	public void get_item_test_2() {
		setupScenary_5();
		assertEquals("Fail get item test", new Integer(12), lk.getItem(3));
		assertEquals("Fail get item test", new Integer(15), lk.getItem(4));
	}
	
	@Test
	public void get_item_test_3() {
		setupScenary_7();
		assertEquals("Fail get item test", new Integer(20), lk.getItem(0));
	}
}
