package pers.hdh.array;

/**
 * Array class<br/>
 *
 * @author hdonghong
 * @date 2018/05/01
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }
    public Array() {
        this(0);
    }

    /**
     * 获取数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 尾部新增一个元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 首部新增一个元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * i位置新增一个元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed! Full array.");
        }
        if (index < 0 || index > size) {
            resize(data.length << 1);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 变容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * 获取index处的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed! Out of index.");
        }
        return data[index];
    }

    /**
     * 修改index处的元素
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed! Out of index.");
        }
        data[index] = e;
    }

    /**
     * 查看是否包含e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return find(e) != -1;
    }

    /**
     * 查找
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index处的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed! Out of index.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        // Lazy机制  TODO
        if (size == data.length >> 2 && data.length >> 1 != 0) {
            resize(data.length >> 1);
        }

        return ret;
    }

    /**
     * 删除第一个
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个
     * @return
     */
    public E removeLast() {
        return remove(size-1);
    }

    /**
     * 删除e
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size-1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
