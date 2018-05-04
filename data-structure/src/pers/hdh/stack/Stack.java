package pers.hdh.stack;

/**
 * Stack interface<br/>
 *
 * @author hdonghong
 * @date 2018/05/04
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    int getCapacity();

    void push(E e);

    E pop();

    E peek();


}
