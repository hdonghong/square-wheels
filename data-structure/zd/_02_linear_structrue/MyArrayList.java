package _02_linear_structrue;

/**
 * MyArrayList class<br/>
 * 顺序表
 * @author hdonghong
 * @date 2018/04/10
 */
public class MyArrayList<T> {

    private T[] data;// 元素集合
    private int last;// 指向最后一个元素的下标
    private int capacity;// 集合容量
    private static final int DEFAULT_LIST_CAPACITY = 10;// 默认初始容量

    public MyArrayList() {
        data = (T[]) new Object[capacity = DEFAULT_LIST_CAPACITY];
        last = -1;
    }

    public boolean full() {
        return this.last == this.capacity-1;
    }

    // 查找
    public int find(T value) {
        int i = 0;
        while (i <= this.last && this.data[i] != value)
            i++;
        return i > this.last ? -1 : i;
    }

    // 插入
    public void insert(T value, int index) {
        if (full()) {
            throw new RuntimeException("表空间已满");
        }
        if (index < 0 || index > this.last+1) {
            throw new IndexOutOfBoundsException("越界访问");
        }
        for (int j = this.last; j >= index; j--)
            this.data[j + 1] = this.data[j];
        this.data[index] = value;
        this.last++;
    }

    // 删除
    public void delete(int index) {
        if (index < 0 || index > this.last) {
            throw new IndexOutOfBoundsException("越界访问");
        }
        for (int j = index; j < this.last; j++) {
            this.data[j] = this.data[j+1];
        }
        this.data[this.last--] = null;
    }

}
