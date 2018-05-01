package impl;

import java.util.Iterator;

/**
 * JosephusProblem class<br/>
 * 7）分别采用循环单链表、双链表或循环双链表求解约瑟夫环问题，并分析各操作效率。
 * @author hdonghong
 * @date 2018/05/01
 */
public class JosephusProblem {

    /**
     * 循环单链表解决
     * @param n 多少人
     * @param e 循环数
     */
    public static LList<Integer> solveByCircSinglyLinkedList(int n, int e) {
        LList<Integer> list = new CircSinglyLinkedList<>();
        LList<Integer> result = new CircSinglyLinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.insert(i);
        }
        Iterator<Integer> it = list.iterator();

        int i = 0;
        while (it.hasNext() && list.size() > 1) {
            Integer data = it.next();
            ++i;
            if (i == e) {
                result.insert(data);
                it.remove();
                i = 0;
            }
        }

        result.insert(list.getFirst());
        return result;
    }

    /** 双链表解决 */
    public static LList<Integer> solveByDoublyLinkedList(int n, int e) {
        LList<Integer> list = new DoublyLinkedList<>();
        LList<Integer> result = new DoublyLinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.insert(i);
        }

        int j = 0;
        for (int i = 0; i < list.size() && list.size() > 1; i = (i+1) % list.size()) {
            ++j;
            if (j == e) {
                result.insert(list.get(i));
                list.remove(i--);
                j = 0;
            }
        }

        result.insert(list.getFirst());
        return result;
    }

    /** 循环双链表 */
    public static LList<Integer> solveByCHDoublelyLinkedList(int n, int e) {
        LList<Integer> list = new CHDoublelyLinkedList<>();
        LList<Integer> result = new CHDoublelyLinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.insert(i);
        }

        int j = 0;
        for (int i = 0; i < list.size() && list.size() > 1; i = (i+1) % list.size()) {
            ++j;
            if (j == e) {
                result.insert(list.get(i));
                list.remove(i--);
                j = 0;
            }
        }

        result.insert(list.getFirst());
        return result;
    }
}
