package pers.hdh.list;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.Iterator;

/**
 * DhLinkedList class<br/>
 * 链表
 * @author hdonghong
 * @date 2018/03/30
 */
public class DhLinkedList<E> implements DhList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public DhLinkedList() {
        first = new Node(null, last, last);
        last = new Node(null, first, first);
    }

    private static class Node<E> {
        E item;
        Node prev;// 前驱
        Node next;// 后继

        public Node(E item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public void set(int i, E t) {

    }

    @Override
    public int insert(int i, E t) {
        return 0;
    }

    @Override
    public int insert(E t) {
        if (first.item == null) {
            first.item = t;
        } else if (last.item == null){
            last.item = t;
        } else {
            Node newNode = new Node(t, last, first);
            last.next = newNode;
            first.prev = newNode;
            last = newNode;
        }
        return size++;
    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public int remove(E key) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int search(E key) {
        return 0;
    }

    @Override
    public boolean contains(E key) {
        return false;
    }

    @Override
    public int insertDifferent(E t) {
        return 0;
    }

    @Override
    public boolean equals(DhList<E> list) {
        return false;
    }

    @Override
    public void addAll(DhList<E> list) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
