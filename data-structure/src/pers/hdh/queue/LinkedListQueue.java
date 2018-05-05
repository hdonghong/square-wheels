package pers.hdh.queue;

/**
 * LinkedListQueue class<br/>
 *
 * @author hdonghong
 * @date 2018/05/05
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            head = tail = new Node(e);
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        ++size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("out of index");
        }
        Node result = this.head;
        head = head.next;
        result.next = null;
        if (head == null) {
            tail = null;
        }
        --size;
        return result.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("out of index");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCapacity() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Queue: front ");
        for (Node cur = head; cur != null; cur = cur.next) {
            result.append(cur + "->");
        }
        return result.append("null tail").toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
