package impl;

import java.util.Iterator;

/**
 * SortedSeqList class<br/>
 * 1）设计一个有序顺序表（元素已排序，递增或递减），实现插入、删除等操作，元素插入位置由其值决定。<br/>
 *
 * @author hdonghong
 * @date 2018/04/06
 */
public class SortedSeqList<T extends Comparable> {
    /** 设置递增或递减的字段，默认为递增 */
    private boolean increase;
    /** 元素 */
    protected T[] elements;
    /** 表中元素数量 */
    protected int size;
    /** 默认初始容量 */
    private static final int DEFAULT_LIST_CAPACITY = 10;

    /**
     * 插入，元素插入位置由其值决定。
     * @param data
     */
    public void insert(T data) {
        if (empty()) {
            this.elements[0] = data;
            size++;
            return;
        }
        ensureCapacity();
        // 区分递增/递减
        int i;
        if (increase) {
            for (i = 0;
                 i < size && data.compareTo(elements[i]) > 0;
                 i++) {}
        } else {
            for (i = 0;
                 i < size && data.compareTo(elements[i]) < 0;
                 i++) {}
        }
        for (int j = size-1;
             j >= i;
             elements[j+1] = elements[j--]) {}
        elements[i] = data;
        size++;
    }

    /**
     * 删除
     * @param data
     */
    public void remove(T data) {
        int index = find(data);
        if (index == -1) {
            throw new RuntimeException("集合中没有此数据");
        }
        for (int i = index;
             i < size-1;
             elements[i] = elements[++i]) {}
        elements[--size] = null;
    }



    public SortedSeqList() {
        this(true);
    }
    public SortedSeqList(boolean increase) {
        this(DEFAULT_LIST_CAPACITY, increase);
    }
    public SortedSeqList(int size, boolean increase) {
        this.size = 0;
        this.increase = increase;
        elements = (T[]) new Comparable[size];
    }

    /** 确保数组有足够的容量 */
    private void ensureCapacity() {
        if (size == elements.length) {
            // 扩容1.5倍
            T[] newElements = (T[]) new Comparable[size + size << 1];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    /** 判断是否空 */
    public boolean empty() {
        return size == 0;
    }

    /**
     * 二分查数据，返回下标，-1表示找不到
     * @param data
     * @return
     */
    public int find(T data) {
        int left = 0;
        int right = size-1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (data.compareTo(elements[mid]) > 0) {
                left = mid + 1;
                continue;
            } else if (data.compareTo(elements[mid]) < 0) {
                right = mid - 1;
                continue;
            } else {
                return mid;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        }
        StringBuffer buffer = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            buffer.append(elements[i]).append(",");
        }
        buffer.replace(buffer.length()-1, buffer.length(), "]");
        return buffer.toString();
    }
}
