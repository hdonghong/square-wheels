import impl.DoublyLinkedList;
import impl.DoublyLinkedList;
import impl.LList;
import org.junit.Assert;
import org.junit.Test;


public class DoublyLinkedListTest {

    @Test
    public void isEmpty() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        Assert.assertTrue(list.isEmpty());
        list.insert("ss");
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void size() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        Assert.assertEquals(0, list.size());
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void get() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");
        Assert.assertEquals("b", list.get(1));
    }

    @Test
    public void set() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.set(0, "b");
        Assert.assertEquals("b", list.get(0));
    }

    @Test
    public void insert() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        Assert.assertEquals("[a,b,c,]", list.toString());
    }

    @Test
    public void insert1() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert(1, "c");
        Assert.assertEquals("[a,c,b,]", list.toString());
    }

    @Test
    public void remove() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        Assert.assertEquals(1, list.remove("b"));
        Assert.assertEquals("[a,c,]", list.toString());
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void remove1() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.remove(2);
        Assert.assertEquals("[a,b,]", list.toString());
    }

    @Test
    public void clear() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void search() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        Assert.assertEquals(1, list.search("b"));
        Assert.assertEquals(-1, list.search("bb"));
    }

    @Test
    public void contains() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        Assert.assertTrue(list.contains("a"));
        Assert.assertFalse(list.contains("aaaaa"));
    }

    @Test
    public void insertDifferent() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");

        Assert.assertEquals(1, list.insertDifferent("d"));
        Assert.assertEquals(0, list.insertDifferent("d"));
    }

    @Test
    public void addAll() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        list.insert("c");

        LList<String> list2 = new DoublyLinkedList<>();
        list2.insert("a");
        list2.insert("b");
        list2.insert("c");

        list.addAll(list2);
        Assert.assertEquals("[a,b,c,a,b,c,]", list.toString());
    }

    @Test
    public void getFirst() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        Assert.assertEquals("a", list.getFirst());
    }

    @Test
    public void getLast() throws Exception {
        LList<String> list = new DoublyLinkedList<>();
        list.insert("a");
        list.insert("b");
        Assert.assertEquals("b", list.getLast());
    }

    @Test
    public void iterator() throws Exception {
    }


}
