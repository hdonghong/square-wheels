package impl;

/**
 * Queue interface<br/>
 * (2) 循环单链表、循环双链表结构设计队列的队列接口
 * @author hdonghong
 * @date 2018/05/04
 */
public interface Queue<E> {

    /**
     * 获取队列元素数量
     * @return 元素数量
     */
    int size();

    /**
     * 判断是否空队
     * @return 空队为true
     */
    boolean isEmpty();

    /**
     * 增加元素到队尾
     * @param e 元素
     * @return 成功添加返回true
     */
    boolean add(E e);

    /**
     * 出队
     * @return 队首元素
     */
    E poll();

    /**
     * 获取队首元素
     * @return 队首元素
     */
    E peek();

}
