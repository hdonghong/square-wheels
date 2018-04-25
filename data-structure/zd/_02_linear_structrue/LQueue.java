package _02_linear_structrue;

/**
 * LQueue class<br/>
 * 循环队列，链式
 * @author hdonghong
 * @date 2018/04/18
 */
public class LQueue<E> {

    QNode<E> front;
    QNode<E> rear;
    int capacity;

    private class QNode<E> {
        E data;
        QNode<E> next;

        public QNode(E data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void add(E e) {
        QNode<E> qNode = new QNode<>(e);
        if (isEmpty()) {
            front = rear = qNode;
        } else {
            rear.next = qNode;
            rear = rear.next;
        }
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        QNode<E> p = this.front;
        if (front == rear) {
            // 只有一个元素
            front = rear = null;
        } else {
            front = front.next;
        }
        return p.data;
    }
}
