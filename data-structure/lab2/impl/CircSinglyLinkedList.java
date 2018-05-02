package impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * CircSinglyLinkedList class<br/>
 * 3）声明循环单链表类CircSinglyLinkedList，实现LList接口中的方法。
 *
 * @author hdonghong
 * @date 2018/04/17
 */
public class CircSinglyLinkedList<E extends Comparable> implements LList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i > this.size-1) {
            throw new IndexOutOfBoundsException("i = " + i + ", size is " + size);
        }
        Iterator<E> iterator = iterator();
        int count = 0;
        E result = iterator.next();
        while (iterator.hasNext() && count < i) {
            count++;
            result = iterator.next();
        }
        return result;
    }

    @Override
    public void set(int i, E t) {
        if (i < 0 || i > this.size-1) {
            throw new IndexOutOfBoundsException("i = " + i + ", size is " + size);
        }
        Node<E> p = this.first;
        while (p != null && i-- > 0) {
            p = p.next;
        }
        p.data = t;
    }

    @Override
    public int insert(int i, E t) {
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException("i = " + i + ", size is " + size);
        }
        if (i == 0) {
            if (isEmpty()) {
                this.first = this.last = new Node<>(t);
            } else {
                Node<E> newLastNode = new Node<>(t, this.first);
                this.last.next = newLastNode;
                this.first = newLastNode;
            }
        } else {
            Node<E> p = this.first;
            while (p != null && i-- > 1) {
                p = p.next;
            }
            Node<E> newNode = new Node<>(t, p.next);
            p.next = newNode;
            if (p == this.last) {
                // 如果刚好插入在尾部
                this.last = newNode;
                this.last.next = this.first;
            }
        }
        size++;
        return i;
    }

    @Override
    public int insert(E t) {
        return insert(size, t);
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i > this.size-1) {
            throw new IndexOutOfBoundsException("i = " + i + ", size is " + size);
        }
        if (isEmpty()) {
            throw new RuntimeException("empty list");
        }
        if (i == 0) {
            first = first.next == first ? null : first.next;
            last.next = first;
        } else {
            Node<E> p = this.first;
            while (p != null && --i > 0) {
                p = p.next;
            }
            p.next = p.next.next;
        }

        size--;

        return null;
    }

    @Override
    public int remove(E key) {
        int index;
        if ((index = indexOf(key)) != -1) {
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
    public int indexOf(E key) {
        Iterator<E> iterator = iterator();
        int count = 0;
        while (iterator.hasNext() && count < size) {
            if (key.compareTo(iterator.next()) == 0) {
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public boolean contains(E key) {
        return indexOf(key) != -1;
    }

    @Override
    public int insertDifferent(E t) {
        if (contains(t)) return 0;
        insert(t);
        return 1;
    }

    @Override
    public void addAll(LList<E> list) {
        int count = 0;
        for (E e : list) {
            insert(e);
            if (++count >= list.size()) {
                break;
            }
        }
    }

    @Override
    public E getFirst() {
        return this.first == null ? null : this.first.data;
    }

    @Override
    public E getLast() {
        return this.last == null ? null : this.last.data;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = CircSinglyLinkedList.this.first;
            private int lastRet = -1;

            @Override
            public boolean hasNext() {
                return p != null && size != 0;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new IndexOutOfBoundsException();
                lastRet = (lastRet + 1)%size;
                E result = p.data;
                p =  p.next;
                return result;
            }

            @Override
            public void remove() {
                if (lastRet < 0) {
                    throw new IllegalArgumentException("emm");
                }
                CircSinglyLinkedList.this.remove(lastRet--);
            }
        };
    }

    private class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Iterator<E> iterator = iterator();
        int count = 0;
        while (iterator.hasNext() && count < size) {
            ++count;
            builder.append(iterator.next()).append(",");
        }
        builder.append("]");
        return builder.toString();
    }
}
