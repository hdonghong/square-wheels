package pers.hdh.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * DhArrayList class<br/>
 * 顺序表
 * @author hdonghong
 * @date 2018/03/28
 */
public class DhArrayList<E> implements DhList<E> {

    private E[] data;
    private int size;

    public DhArrayList() {
        this(10);
    }
    public DhArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }
    public DhArrayList(DhList<E> list) {
        this();
        addAll(list);
    }

    private void grow() {
        int newCapacity = data.length + (data.length >> 1);
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(this.data, 0, newData, 0, this.size);
        this.data = newData;
    }
    private void ensureEnableCapacity() {
        if (size == this.data.length) {
            grow();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i > size-1) {
            throw new IndexOutOfBoundsException("i = " + i);
        }
        return this.data[i];
    }

    @Override
    public void set(int i, E t) {
        if (i < 0 || i > size-1) {
            throw new IndexOutOfBoundsException("i = " + i);
        }
        this.data[i] = t;
    }

    @Override
    public int insert(int i, E t) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("i = " + i);
        }
        ensureEnableCapacity();// 确保足够容量
        System.arraycopy(data, i, data, i+1, ++size);
        data[i] = t;
        return i;
    }

    @Override
    public int insert(E t) {
        if (t == null) throw new NullPointerException();
        ensureEnableCapacity();// 确保足够容量
        data[size++] = t;
        return size-1;
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i > size-1) {
            throw new IndexOutOfBoundsException("i = " + i);
        }
        E t = data[i];
        System.arraycopy(data, i+1, data, i, --size);
        data[size] = null;
        return t;
    }

    @Override
    public int remove(E key) {
        int i = search(key);
        if (i == -1) return i;
        remove(i);
        return i;
    }

    @Override
    public void clear() {
        data = (E[])new Object[10];
        size = 0;
    }

    @Override
    public int search(E key) {
        if (!contains(key)) {
            return -1;
        }
        int i = 0;
        for (; i < size; i++) {
            if (data[i].equals(key)) break;
        }
        return i;
    }

    @Override
    public boolean contains(E key) {
        if (key == null) throw new NullPointerException();
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(key))
                return true;
        }
        return false;
    }

    @Override
    public int insertDifferent(E t) {
        if (!contains(t)) return insert(t);
        else return -1;
    }

    @Override
    public boolean equals(DhList<E> list) {
        if (list == this) return true;
        if (list == null) return false;
        if (!list.getClass().equals(this.getClass())) return false;
        if (list.size() != this.size) return false;

        for (int i = 0; i < size; i++) {
            if (!list.get(i).equals(this.data[i]))
                return false;
        }

        return true;
    }

    @Override
    public void addAll(DhList<E> list) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException(list.toString());
        for (E t : list) {
            insert(t);
        }
    }

    @Override
    public String toString() {
        if (this == null) return null;

        StringBuffer buffer = new StringBuffer("[");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) buffer.append(",");
            buffer.append(this.data[i]);
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i < DhArrayList.this.size;
            }

            @Override
            public E next() {
                return hasNext() ?
                        DhArrayList.this.data[i++] : null;
            }
        };
    }

    /*    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }*/
}
