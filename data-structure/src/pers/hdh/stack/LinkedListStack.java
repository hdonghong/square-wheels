package pers.hdh.stack;

import pers.hdh.list.LinkedList;

/**
 * LinkedListStack class<br/>
 *
 * @author hdonghong
 * @date 2018/05/05
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getCapacity() {
        return list.getSize();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Stack: top ");
        return result.append(list).toString();
    }
}
