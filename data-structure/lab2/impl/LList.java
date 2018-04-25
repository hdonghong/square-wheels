package impl;

/**
 * LList interface<br/>
 *
 * @author hdonghong
 * @date 2018/04/17
 */
public interface LList<E extends Comparable> extends Iterable<E> {

    /**
     * 判断线性表是否为空
     * @return 空返回true
     */
    boolean isEmpty();

    /**
     * 返回元素数量
     * @return 元素数量
     */
    int size();

    /**
     * 获取第i个元素
     * @param i i从0开始
     * @return 元素
     */
    E get(int i);

    /**
     * 更改指定i位置的元素值为t
     * @param i i从0开始
     * @param t 元素不能为空
     */
    void set(int i, E t);

    /**
     * 在指定i位置插入元素t
     * @param i i从0开始
     * @param t 元素不能为空
     * @return
     */
    int insert(int i, E t);

    /**
     * 在线性表末尾插入元素t
     * @param t 元素不能为空
     * @return
     */
    int insert(E t);

    /**
     * 移除指定i位置的元素
     * @param i i从0开始
     * @return 被移除的元素的值
     */
    E remove(int i);

    /**
     * 从左向右，移除线性表中第一个与key相等的元素
     * @param key 指定元素
     * @return  被移除的元素的位置，从0开始，返回-1表示找不到
     */
    int remove(E key);

    /**
     * 清空线性表
     */
    void clear();

    /**
     * 从左向右，查找线性表中第一个与key相等的元素
     * @param key 指定元素
     * @return 元素的位置，从0开始，返回-1表示找不到
     */
    int search(E key);

    /**
     * 从左向右，查找线性表中是否存在与key相等的元素
     * @param key 指定元素
     * @return 存在返回true
     */
    boolean contains(E key);

    /**
     * 插入不重复元素
     * @param t 元素
     * @return 元素的位置，1成功，0重复，失败
     */
    int insertDifferent(E t);


    /**
     * 将list中的元素加入this中
     * @param list
     */
    void addAll(LList<E> list);

    /**
     * 获取头结点元素的值
     * @return
     */
    E getFirst();

    /**
     * 获取尾结点元素的值
     * @return
     */
    E getLast();

}
