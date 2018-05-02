import impl.LList;
import impl.Polynomial;
import impl.PolynomialAddition;
import impl.SortedDoublyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试：3x4-6x2+5x-10  +  3x4-10x3-6x2+3x+10
 * 注：3x4表示未知量x系数为3指数为4
 *
 * @author hdonghong
 * @date 2018/05/02
 */
public class PolynomialAdditionTest {
    @Test
    public void addPolynomial() throws Exception {
        LList<Polynomial> sortedA = new PolynomialAddition.SubSortedList<>();
        LList<Polynomial> sortedB = new PolynomialAddition.SubSortedList<>();

        sortedA.insert(new Polynomial(0, -10));
        sortedA.insert(new Polynomial(1, 5));
        sortedA.insert(new Polynomial(2, -6));
        sortedA.insert(new Polynomial(4, 3));
//        多项式中存在指数相同的单项式
        sortedA.insert(new Polynomial(4, -4));
        System.out.println(sortedA);

        sortedB.insert(new Polynomial(0, 10));
        sortedB.insert(new Polynomial(3, -10));
        sortedB.insert(new Polynomial(1, 3));
        sortedB.insert(new Polynomial(2, -6));
        sortedB.insert(new Polynomial(4, 3));
        System.out.println(sortedB);

        System.out.println("相加结果为：\n" + PolynomialAddition.addPolynomial(sortedA, sortedB));
    }

}