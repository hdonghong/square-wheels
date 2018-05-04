import impl.QByCHDoublelyLinkedList;
import impl.Queue;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QByCHDoublelyLinkedListTest {
    @Test
    public void size() throws Exception {
        Queue<Integer> q = new QByCHDoublelyLinkedList<>();
        q.add(2);
        q.add(3);
        q.add(3);
        q.add(3);
        Assert.assertEquals(4, q.size());
    }

    @Test
    public void isEmpty() throws Exception {
        Queue<Integer> q = new QByCHDoublelyLinkedList<>();
        Assert.assertTrue(q.isEmpty());
        q.add(2);
        q.add(3);
        q.add(3);
        q.add(3);
        Assert.assertFalse(q.isEmpty());
    }

    @Test
    public void add() throws Exception {
        Queue<Integer> q = new QByCHDoublelyLinkedList<>();
        q.add(2);
        q.add(3);
        q.add(3);
        q.add(3);
        Assert.assertEquals("[2,3,3,3,]", q.toString());
    }

    @Test
    public void poll() throws Exception {
        Queue<Integer> q = new QByCHDoublelyLinkedList<>();
        q.add(2);
        q.add(3);
        q.add(3);
        q.add(3);
        Assert.assertEquals(2, q.poll().intValue());
        Assert.assertEquals(3, q.poll().intValue());
        Assert.assertEquals(3, q.poll().intValue());
        Assert.assertEquals(3, q.poll().intValue());
    }

    @Test
    public void peek() throws Exception {
        Queue<Integer> q = new QByCHDoublelyLinkedList<>();
        q.add(2);
        Assert.assertEquals(2, q.peek().intValue());
        q.add(3);
        Assert.assertEquals(2, q.peek().intValue());
    }

}