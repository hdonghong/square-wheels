package _02_linear_structrue;

/**
 * MyStack class<br/>
 * 数组实现
 * @author hdonghong
 * @date 2018/04/11
 */
public class MyStack<T extends Comparable<T>> {

    private T[] data;
    int top;// 指向栈顶，也可认为是(栈中有多少个元素-1)
    private static final int DEFAULT_LIST_CAPACITY = 10;// 默认初始容量

    public MyStack() {
        this(DEFAULT_LIST_CAPACITY);
    }
    public MyStack(int capacity) {
        data = (T[]) new Comparable[capacity];
        top = -1;
    }

    // 压栈
    public void push(T item) {
        if (top == this.data.length-1) {
            throw new RuntimeException("栈溢出");
        } else {
            this.data[++top] = item;
        }
    }

    // 出栈
    public T pop() {
        if (top == -1) {
            throw new RuntimeException("空栈");
        }
        return this.data[top--];
    }
}
