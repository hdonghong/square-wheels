package test;


import impl.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * SinglyLinkedListTest class<br/>
 *
 * @author hdonghong
 * @date 2018/04/17
 */
public class SinglyLinkedListTest {
    @Test
    public void concat() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        Assert.assertEquals("[a,bb,cc]", list.toString());

        SinglyLinkedList<String> anotherList = new SinglyLinkedList<>(list);
        anotherList.concat(list);
        Assert.assertEquals("[a,bb,cc,a,bb,cc]", anotherList.toString());
    }

    @Test
    public void indexOf() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        Assert.assertNotNull(list.indexOf("a"));
        Assert.assertNotNull(list.indexOf("bb"));
        Assert.assertNotNull(list.indexOf("cc"));
        Assert.assertNull(list.indexOf("abc"));
    }

    @Test
    public void contain() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        Assert.assertTrue(list.contain("a"));
        Assert.assertTrue(list.contain("bb"));
        Assert.assertTrue(list.contain("cc"));
        Assert.assertFalse(list.contain("abc"));
    }

    @Test
    public void remove() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc", "ddd"});
        Assert.assertTrue(list.remove("ddd"));
        Assert.assertTrue(list.remove("bb"));
        Assert.assertFalse(list.remove("not-existed-data"));
    }

    @Test
    public void replace() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        Assert.assertTrue(list.replace("cc", "be-replaced"));
        Assert.assertEquals("[a,bb,be-replaced]", list.toString());
    }

    @Test
    public void equals() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>(new String[]{"aaaa", "bb", "cc"});

        Assert.assertEquals(list, list2);
        Assert.assertNotEquals(list, list3);
    }

    @Test
    public void testToString() throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(new String[]{"a", "bb", "cc"});
        Assert.assertEquals("[a,bb,cc]", list.toString());

        SinglyLinkedList<String> anotherList = new SinglyLinkedList<>(list);
        Assert.assertEquals("[a,bb,cc]", anotherList.toString());
    }

}
