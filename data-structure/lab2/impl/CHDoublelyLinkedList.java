package impl;

import java.util.Iterator;

/**
 * CHDoublelyLinkedList class<br/>
 * 6）声明循环双链表类CHDoublelyLinkedList，实现LList接口中的方法。
 * @author hdonghong
 * @date 2018/05/01
 */
public class CHDoublelyLinkedList<E extends Comparable> implements LList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public CHDoublelyLinkedList() {
        size = 0;
    }

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
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("emmm");
        }
        Iterator<E> iterator = iterator();
        E result = null;
        while (iterator.hasNext() && i-- >= 0) {
            result = iterator.next();
        }
        return result;
    }

    @Override
    public void set(int i, E e) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("emmm");
        }
        Node<E> p = this.first;
        while (p != null && i-- > 0) {
            p = p.next;
        }
        p.data = e;
    }

    @Override
    public int insert(int i, E e) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("out of index");
        }

        if (i == 0) {
            Node<E> newNode = new Node<>(e, this.last, this.first);
            if (!isEmpty()) {
                this.first.prev = newNode;
                this.last.next = newNode;
            } else {
                this.last = newNode;
            }
            this.first = newNode;
        } else {
            Node<E> p = this.last;
            for (int j = size; j > i; j--) {
                p = p.prev;
            }
            Node<E> newNode = new Node<>(e, p, p.next);
            p.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
            if (i == size) {
                // 处理尾部插入的情况
                newNode.next = this.first;
                this.first.prev = newNode;
                this.last = newNode;
            }
        }
        size++;
        return i;
    }

    @Override
    public int insert(E e) {
        return insert(size, e);
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("emmm");
        }

        E ret = null;
        if (i == 0) {
            if (this.first != null) {
                ret = this.first.data;
                this.first = this.first.next;
                this.last.next = this.first;
                this.first.prev = this.last;
            }
        } else {
            Node<E> p = this.first;
            while (p != null && i-- > 1) {
                // 遍历到目标位置的前一位
                p = p.next;
            }
            if (p.next != null) {
                ret = p.next.data;
                p.next = p.next.next;
                // 不是删除尾部元素
                p.next.prev = p;
            }
        }

        size--;
        return ret;
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
        this.first = this.last = null;
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
        if (contains(t)) {
            return 0;
        }
        insert(t);
        return 1;
    }

    @Override
    public void addAll(LList<E> list) {
        if (list != null) {
            for (E e : list) {
                insert(e);
            }
        }
    }

    @Override
    public E getFirst() {
        return isEmpty() ? null : this.first.data;
    }

    @Override
    public E getLast() {
        return isEmpty() ? null : this.last.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = first;
            private int counter;

            @Override
            public boolean hasNext() {
                counter++;
                return p != null && counter <= size;
            }

            @Override
            public E next() {
                E data = p.data;
                p = p.next;
                return data;
            }

            @Override
            public void remove() {

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
