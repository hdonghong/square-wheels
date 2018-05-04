package impl;

/**
 * Queue interface<br/>
 * (2) 循环单链表、循环双链表结构设计队列的队列接口
 * @author hdonghong
 * @date 2018/05/04
 */
public interface Queue<E> {

    int size();

    boolean isEmpty();

    boolean add(E e);

    E poll();

    E peek();

}
