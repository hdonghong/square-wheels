package _02_linear_structrue;

/**
 * MyLinkedList class<br/>
 * 链式表
 * @author hdonghong
 * @date 2018/04/10
 */
public class MyLinkedList<T> {

    private Node<T> head;

    public MyLinkedList() {
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // 求表长
    public int length() {
        Node<T> p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    // 查找，按序号
    public Node<T> findIdx(int index) {
        Node<T> p = head;
        int i = 0;
        while (i < index && p != null) {
            p = p.next;
            i++;
        }
        return i == index ? p : null;
    }

    // 查找，按值
    public Node<T> find(T value) {
        Node<T> p = head;
        while (p != null && p.data != value)
            p = p.next;
        return p;
    }

    // 插入
    public MyLinkedList insert(T value, int index) {
        Node<T> p = findIdx(index);
        if (p == null) {
            throw new RuntimeException("越界");
        } else {
            Node<T> newNode = new Node<>(value, p.next);
            p.next = newNode;
            return this;
        }
    }

    // 删除
    public MyLinkedList<T> delete(int index) {
        if (index == 0 || this.head != null) {
            this.head = this.head.next;
            return this;
        }

        Node<T> p = findIdx(index-1);
        if (p == null) {
            throw new RuntimeException("越界");
        } else if (p.next != null){
            p.next = p.next.next;
        }
        return this;
    }
}
