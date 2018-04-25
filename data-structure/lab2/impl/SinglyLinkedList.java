package impl;

import java.util.Iterator;

/**
 * SinglyLinkedList class<br/>
 * 2）在SinglyLinkedList或HSLingkedList类中增加下列成员方法
 *
 * @author hdonghong
 * @date 2018/04/17
 */
public class SinglyLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    /** 由指定数组中的多个对象构造单链表 */
    public SinglyLinkedList(E[] element) {
        if (element == null || element.length < 1) {
            throw new IllegalArgumentException("emmmmm");
        }
        first = last = new Node<>(element[size++]);
        for (; size < element.length; size++) {
            Node<E> temp = new Node<>(element[size]);
            last.next = temp;
            last = last.next;
        }
    }

    /** 以单链表list构造新的单链表，复制单链表 */
    public SinglyLinkedList(SinglyLinkedList<E> list) {
        if (list == null || list.size() < 0) {
            throw new IllegalArgumentException("empty list");
        }
        Node<E> p = list.first;
        first = last = new Node<>(p.data);
        size++;
        while (p.next != null) {
            Node<E> temp = new Node<>(p.next.data);
            last.next = temp;
            last = last.next;
            p = p.next;
            size++;
        }

    }

    /** 将指定单链表list链接在当前单链表之后 */
    public void concat(SinglyLinkedList<E> list) {
        for (E e : list) {
            Node<E> node = new Node<>(e);
            last.next = node;
            last = last.next;
        }
    }

    /** 若查找到指定对象，则返回结点，否则返回null */
    public Node<E> search(E element) {
        Node<E> p = first;
        while (p != null && !p.data.equals(element)) {
            p = p.next;
        }
        return p;
    }

    /** 以查找结果判断单链表是否包含指定对象 */
    public boolean contain(E element) {
        Node<E> p = first;
        while (p != null && !p.data.equals(element)) {
            p = p.next;
        }
        return p != null;
    }

    /** 移去首次出现的指定对象 */
    public boolean remove(E element) {
        if (first.data.equals(element)) {
            return true;
        }
        Node<E> p = first;
        while (p.next != null && !p.next.data.equals(element)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
            return true;
        }
        return false;
    }

    /** 将单链表中的obj对象替换为对象element */
    public boolean replace(Object obj, E element) {
        Node<E> p = first;
        while (p != null && !p.data.equals(obj)) {
            p = p.next;
        }
        if (p != null) {
            p.data = element;
            return true;
        }
        return false;
    }

    /** 比较两条单链表是否相等 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof SinglyLinkedList)) return false;
        Iterator<E> itor1 = iterator();
        Iterator itor2 = ((SinglyLinkedList) obj).iterator();
        while (itor1.hasNext() && itor2.hasNext()) {
            E o1 = itor1.next();
            Object o2 = itor2.next();
            // 空或不等返回false
            if (!(o1 == null ? o2 == null : o1.equals(o2)))
                return false;
        }
        return !(itor1.hasNext() || itor2.hasNext());
    }



/***********************this is saperator line*************************/

    @Override
    public int hashCode() {
        int result;
        result = size;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> p = first;
        while (p != null) {
            builder.append(p.data);
            if (p.next != null) {
                builder.append(",");
            }
            p = p.next;
        }
        builder.append("]");

        return builder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = first;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new IndexOutOfBoundsException("越界了");
                E temp = this.p.data;
                p = p.next;
                return temp;
            }
        };
    }

    public int size() {
        return this.size;
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
}