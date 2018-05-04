package pers.hdh.queue;

/**
 * Queue interface<br/>
 *
 * @author hdonghong
 * @date 2018/05/04
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    int getCapacity();

    boolean isEmpty();
}
