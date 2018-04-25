package impl;

import java.util.Iterator;

/**
 * DoublyLinkedList class<br/>
 * 双链表类
 * @author hdonghong
 * @date 2018/04/25
 */
public class DoublyLinkedList<E extends Comparable> implements LList<E> {

    private Node<E> first;
//    private Node<E> last;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i > size-1) throw new RuntimeException("emmm");
        Iterator<E> iterator = iterator();
        E result = null;
        while (iterator.hasNext() && i-- >= 0) {
            result = iterator.next();
        }
        return result;
    }

    @Override
    public void set(int i, E t) {
        if (i < 0 || i > size-1) throw new RuntimeException("emmm");
        Node<E> p = this.first;
        while (p != null && i-- > 0) {
            p = p.next;
        }
        p.data = t;
    }

    @Override
    public int insert(int i, E t) {
        if (i < 0 || i > size) throw new RuntimeException("emmm");
        if (i == 0) {
            // 首部插入
            Node<E> newNode = new Node<>(t, null, this.first);
            if (!isEmpty()) {
                this.first.prev = newNode;
            }
            this.first = newNode;
        } else {
            Node<E> p = this.first;
            while (p != null && i-- > 1) {
                // 遍历到目标位置的前一位
                p = p.next;
            }
            Node<E> newNode = new Node<>(t, p, p.next);
            p.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }
        size++;

        return 0;
    }

    @Override
    public int insert(E t) {
        return insert(size, t);
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i > size-1) throw new RuntimeException("emmm");

        if (i == 0) {
            this.first = this.first.next;
            if (this.first != null) {
                this.first.prev = null;
            }
        } else {
            Node<E> p = this.first;
            while (p != null && i-- > 1) {
                // 遍历到目标位置的前一位
                p = p.next;
            }
            p.next = p.next.next;
            if (p.next != null) {
                // 不是删除尾部元素
                p.next.prev = p;
            }
        }

        size--;
        return null;
    }

    @Override
    public int remove(E key) {
        int index = search(key);
        if (index != -1) {
            remove(index);
        }
        return index;
    }

    @Override
    public void clear() {
        this.first = null;
        size = 0;
    }

    @Override
    public int search(E key) {
        Iterator<E> iterator = iterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (iterator.next().equals(key)){
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public boolean contains(E key) {
        return search(key) != -1;
    }

    @Override
    public int insertDifferent(E t) {
        if (contains(t)) return 0;
        insert(t);
        return 1;
    }

    @Override
    public void addAll(LList<E> list) {
        if (list != null)
            for (E e : list) {
                insert(e);
            }
    }

    @Override
    public E getFirst() {
        return this.first.data;
    }

    @Override
    public E getLast() {
        if (isEmpty())
            return null;
        Node<E> p = this.first;
        while (p.next != null) {
            p = p.next;
        }
        return p.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = DoublyLinkedList.this.first;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new RuntimeException("emmmm");
                E data = p.data;
                p = p.next;
                return data;
            }
        };
    }

    private class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next()).append(",");
        }
        builder.append("]");
        return builder.toString();
    }
}
