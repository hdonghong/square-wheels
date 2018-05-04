package pers.hdh.queue;

/**
 * LoopQueue class<br/>
 * 循环队列
 * @author hdonghong
 * @date 2018/05/04
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueue(int capacity) {
        data = (E[] )new Object[capacity + 1];
        front = 0;
        tail = 0;
    }
    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }

        // 注意顺序
        tail = getSize();
        front = 0;
        data = newData;
    }

    @Override
    public E dequeue() {
        E ret = getFront();
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() >> 2 && getCapacity() >> 1 != 0) {
            resize(getCapacity() >> 1);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Faled dequeue. Empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        int diff = tail - front;
        return diff > 0 ? diff : data.length + diff;
    }

    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        result.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
