package pers.hdh.stack;

/**
 * Stack interface<br/>
 *
 * @author hdonghong
 * @date 2018/05/04
 */
public interface Stack<E> {

    /**
     * 获取元素数量
     * @return 元素数量
     */
    int getSize();

    /**
     * 判断是否空栈
     * @return 空栈返回true
     */
    boolean isEmpty();

    /**
     * 获取栈的容量
     * @return 栈的容量
     */
    int getCapacity();

    /**
     * 压栈
     * @param e 元素
     */
    void push(E e);

    /**
     * 弹栈
     * @return 栈顶元素
     */
    E pop();

    /**
     * 返回栈顶元素值
     * @return 栈顶元素
     */
    E peek();


}
