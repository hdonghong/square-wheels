package impl;

/**
 * Polynomial class<br/>
 * 单项式类
 * @author hdonghong
 * @date 2018/05/02
 */
public class Polynomial implements Comparable {
    /** 指数 */
    int exponent;

    /** 系数 */
    int coefficient;

    @Override
    public int compareTo(Object o) {
        if (!this.getClass().isInstance(o)) {
            throw new ClassCastException("emmmmm");
        }
        Polynomial p = (Polynomial) o;
        return this.exponent - p.exponent;
    }

    @Override
    public String toString() {
        return coefficient+ "x" + exponent;
    }

    /** 指数，系数*/
    public Polynomial(int exponent, int coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
}