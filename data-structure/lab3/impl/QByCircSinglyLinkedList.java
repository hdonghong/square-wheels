package impl;

/**
 * QByCircSinglyLinkedList class<br/>
 * (2) 循环单链表实现队列
 * @author hdonghong
 * @date 2018/05/04
 */
public class QByCircSinglyLinkedList<E extends Comparable> implements Queue<E> {

    private CircSinglyLinkedList<E> list;

    public QByCircSinglyLinkedList() {
        list = new CircSinglyLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean add(E e) {
        return list.insert(e) == list.size() - 1;
    }

    @Override
    public E poll() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            ret.append(list.get(i) + ",");
        }
        ret.append("]");
        return ret.toString();
    }
}
