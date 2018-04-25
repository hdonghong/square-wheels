package _02_linear_structrue;

/**
 * DStack class<br/>
 *
 * 用数组实现两个堆栈，要求最大地利用数组空间，使得数组只要有空间入站操作就可以成功<br/>
 * 思路：两个栈指针指向数组左右两头，指针相遇时栈满
 *
 * @author hdonghong
 * @date 2018/04/11
 */
public class DStack<T extends Comparable<T>> {

    private T[] data;
    int topLeft;// 指向左栈顶
    int topRight;// 指向右栈顶
    private static final int DEFAULT_LIST_CAPACITY = 10;// 默认初始容量

    public DStack() {
        this(DEFAULT_LIST_CAPACITY);
    }
    public DStack(int capacity) {
        data = (T[]) new Comparable[capacity];
        topLeft = -1;
        topRight = capacity;
    }

    // 压栈
    public void push(T item, boolean tag) {
        if (topRight - topLeft == 1) {
            throw new RuntimeException("栈溢出");
        }
        // tag作为操作哪个栈的标志，true表示左边
        if (tag) {
            this.data[++topLeft] = item;
        } else {
            this.data[--topRight] = item;
        }
    }

    // 弹栈
    public T pop(boolean tag) {
        // tag作为操作哪个栈的标志，true表示左边
        if (tag) {
            if (topLeft == -1) {
                throw new RuntimeException("空");
            }
            return this.data[topLeft--];
        } else {
            if (topRight == this.data.length) {
                throw new RuntimeException("空");
            }
            return this.data[topRight++];
        }
    }

}
