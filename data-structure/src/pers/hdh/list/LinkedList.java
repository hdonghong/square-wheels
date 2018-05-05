package pers.hdh.list;

/**
 * LinkedList class<br/>
 *
 * @author hdonghong
 * @date 2018/05/05
 */
public class LinkedList<E> {

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

    // 虚拟头节点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    // 获取元素个数
    public int getSize() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表index处插入
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("LinkedList add failed, index = " + index);
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        ++size;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 链表末尾加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获取index处的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("LinkedList get failed, index = " + index);
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改index处的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("LinkedList set failed, index = " + index);
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除index处的节点
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("LinkedList remove failed, index = " + index);
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node result = pre.next;
        pre.next = result.next;
        result.next = null;
        --size;
        return result.e;
    }

    // 删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            result.append(cur + "->");
        }
        return result.append("null").toString();
    }
}
