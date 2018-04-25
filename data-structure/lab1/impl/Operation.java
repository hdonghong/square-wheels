package impl;

/**
 * Operation<br/>
 * 实验一、算法设计与分析<br/>
 * @author hdonghong
 * @date 2018/04/04
 */
public class Operation {

    /**
     * 判断整数数组是否已按升序排序
     * @param table 整数数组
     * @return 升序返回true
     */
    public static boolean isSorted(int[] table) {
        int i;
        for (i = 0;
             i < table.length-1 && table[i] <= table[i+1];
             i++);
        return i == table.length-1;
    }
    /**
     * 判断对象数组是否已按升序排序
     * @param table 对象数组
     * @return
     */
    public static boolean isSorted(Comparable[] table) {
        int i;
        for (i = 0;
             i < table.length-1 && table[i].compareTo(table[i+1]) <= 0;
             i++);
        return i == table.length-1;
    }

    /**
     * 将一个已知数组中所有元素的次序颠倒为相反次序<br/>
     * 求算法的时间复杂度和空间复杂度
     * @param table 已知数组
     * @param <T> 数组类型
     * @return 次序颠倒后的数组
     */
    public static<T> T[] reverse(T[] table) {
        for (int i = -1, n = table.length; ++i < n >> 1;) {
            T temp = table[i];
            table[i] = table[n-1-i];
            table[n-1-i] = temp;
        }
        return table;
    }

    /**
     * 递归算法实现gcd(a, b)求两个整数a，b最大公因数
     * @return 两个整数a，b的最小公倍数
     */
    public static int gdc(int a, int b) {
        return b != 0 ? gdc(b, a%b): a;
    }
    /**
     * 求两个整数a，b的最小公倍数
     * @return
     */
    public static int minComMltp(int a, int b) {
        return a * b / gdc(a, b);
    }
    /**
     * 求三个数a,b,c的最大公约数
     * @return 三个数a,b,c的最大公约数
     */
    public static int maxComFatr(int a, int b, int c) {
        return gdc(gdc(a, b), c);
    }

}
