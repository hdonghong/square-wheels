package impl;

import java.util.Iterator;

/**
 * PolynomialAddition class<br/>
 * 9)多项式相加
 * 一条单链表可以表示一个一元多项式，每个结点包含三个域：指数域、系数域和后继结点链。
 * 给定两个多项式，实现两个多项式的相加算法。
 *
 * @author hdonghong
 * @date 2018/05/01
 */
public class PolynomialAddition {

    public static LList<Polynomial> addPolynomial(LList<Polynomial> a, LList<Polynomial> b) {
        // 重写toString，方便输出看
        LList<Polynomial> result = new SubSortedList<>();

        if (a == null || a.size() == 0) {
            return b;
        } else if (b == null || b.size() == 0) {
            return a;
        }
        // 按指数排序单项式
        LList<Polynomial> sortedA = new SortedDoublyLinkedList<>();
        LList<Polynomial> sortedB = new SortedDoublyLinkedList<>();
        sortedA.addAll(a);
        sortedB.addAll(b);

        int aI = 0;
        int bI = 0;
        // 两个式子相加
        while (aI < sortedA.size() && bI < sortedB.size()) {
            Polynomial polynomialA = sortedA.get(aI);
            Polynomial polynomialB = sortedB.get(bI);

            if (polynomialA.compareTo(polynomialB) < 0) {
                result.insert(new Polynomial(polynomialA.exponent, polynomialA.coefficient));
                ++aI;
            } else if (polynomialB.compareTo(polynomialA) < 0) {
                result.insert(new Polynomial(polynomialB.exponent, polynomialB.coefficient));
                ++bI;
            } else {
                Polynomial polynomial = new Polynomial(polynomialA.exponent,
                        polynomialA.coefficient + polynomialB.coefficient);
                if (polynomial.coefficient != 0) {
                    result.insert(polynomial);
                }
                ++aI;
                ++bI;
            }
        }

        // 处理某个多项式剩余的部分
        while (aI < sortedA.size()) {
            Polynomial polynomialA = sortedA.get(aI++);
            result.insert(new Polynomial(polynomialA.exponent, polynomialA.coefficient));
        }
        while (bI < sortedB.size()) {
            Polynomial polynomialB = sortedB.get(aI++);
            result.insert(new Polynomial(polynomialB.exponent, polynomialB.coefficient));
        }

        // 合并多项式中指数相同的单项式
        for (int i = 0; i < result.size() - 1; i++) {
            Polynomial p = result.get(i);
            Polynomial pNext = result.get(i + 1);
            if (p.exponent == pNext.exponent) {
                p.coefficient += pNext.coefficient;
                result.remove(i + 1);
                if (p.coefficient == 0) {
                    result.remove(i);
                }
                --i;
            }
        }

        return result;
    }

    /** 重写toString，方便输出打印 */
    public static class SubSortedList<E extends Comparable> extends SortedDoublyLinkedList<E> {
        @Override
        public String toString() {
            if (super.isEmpty()) {
                return "[0]";
            }

            String str = "]";
            Iterator<E> it = super.iterator();
            while (it.hasNext()) {
                str = it.next() + str;
                if (it.hasNext()) {
                    str = " + " + str;
                }
            }
            str = "[" + str;
            return str;
        }
    };
}


