package _02_linear_structrue;

import java.util.Queue;

/**
 * MyQueue class<br/>
 * 循环队列，数组实现，容量为n-1
 * @author hdonghong
 * @date 2018/04/18
 */
public class MyQueue<E extends Comparable<E>> {

    E[] data;
    int front;// 下标front为空
    int rear;
    private static final int DEFAULT_LIST_CAPACITY = 10;// 默认初始容量

    public MyQueue() {
        this(DEFAULT_LIST_CAPACITY);
    }
    public MyQueue(int capacity) {
        data = (E[]) new Comparable[capacity];
        front = rear;
    }

    public boolean isFull() {
        return (rear+1) % data.length == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean add(E e) {
        if (isFull()) {
            return false;
        } else {
            rear = (rear+1) % data.length;
            data[rear] = e;
            return true;
        }
    }
    
    public E poll() {
        if (isEmpty()) {
            return null;
        } else {
            front = (front+1) % data.length;
            return data[front];
        }
    }


    
    
}
