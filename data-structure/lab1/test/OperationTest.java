package test;

import impl.Operation;
import org.junit.Assert;
import org.junit.Test;

/**
 * OperationTest class<br/>
 * 测试类
 * @author hdonghong
 * @date 2018/04/04
 */
public class OperationTest {

    /**
     * 测试：（1）判断已按升序排序。判断整数数组是否已按升序排序
     */
    @Test
    public void testIsSortedIntArr() {
        Assert.assertTrue(Operation.isSorted(new int[] {1, 2, 3, 4}));
        Assert.assertTrue(Operation.isSorted(new int[] {1, 2, 3, 3}));
        Assert.assertFalse(Operation.isSorted(new int[] {1, 2, 4, 3}));
    }

    /**
     * 测试：（1）判断已按升序排序。判断对象数组是否已按升序排序
     */
    @Test
    public void testIsSortedObjArr() {
        Assert.assertTrue(Operation.isSorted(new String[] {"aa", "bb", "cc", "dd"}));
        Assert.assertTrue(Operation.isSorted(new String[] {"aa", "bb", "c", "cc"}));
        Assert.assertFalse(Operation.isSorted(new String[] {"aa", "bb", "dd", "cc"}));
    }

    /**
     * 测试：（2）数组逆置。
     */
    @Test
    public void testReverse() {
        Assert.assertArrayEquals(
                new String[] {"aa"},
                Operation.<String>reverse(new String[] {"aa"}));

        Assert.assertArrayEquals(
                new String[] {"dd", "aa"},
                Operation.<String>reverse(new String[] {"aa", "dd"}));

        Assert.assertArrayEquals(
                new String[] {"dd", "cc", "aa"},
                Operation.<String>reverse(new String[] {"aa", "cc", "dd"}));

        Assert.assertArrayEquals(
                new String[] {"dd", "cc", "bb", "aa"},
                Operation.<String>reverse(new String[] {"aa", "bb", "cc", "dd"}));

    }

    /**
     * 测试：（3）用递归算法求两个整数的最大公因数。
     */
    @Test
    public void testGdc() {
        // 正数
        Assert.assertEquals(2, Operation.gdc(2, 6));
        Assert.assertEquals(1, Operation.gdc(2, 1));
        Assert.assertEquals(2, Operation.gdc(6, 8));
        Assert.assertEquals(8, Operation.gdc(16, 8));

        // 负数
        Assert.assertEquals(-2, Operation.gdc(-2, -6));
        Assert.assertEquals(-1, Operation.gdc(-2, -1));
        Assert.assertEquals(-2, Operation.gdc(-6, -8));
        Assert.assertEquals(-8, Operation.gdc(-16, -8));
    }

    /**
     * 测试：（3）用递归算法实现gcd(a,b),并给下列调用：①求两个整数a，b的最小公倍数
     */
    @Test
    public void testMinComMltp() {
        Assert.assertEquals(6, Operation.minComMltp(6, 2));
        Assert.assertEquals(6, Operation.minComMltp(2, 6));

        Assert.assertEquals(42, Operation.minComMltp(7, 6));
        Assert.assertEquals(42, Operation.minComMltp(6, 7));

        Assert.assertEquals(24, Operation.minComMltp(8, 6));
        Assert.assertEquals(24, Operation.minComMltp(6, 8));
    }

    /**
     * 测试：（3）用递归算法实现gcd(a,b),并给下列调用：②求三个数a,b,c的最大公约数
     */
    @Test
    public void testMaxComFatr() {
        Assert.assertEquals(1, Operation.maxComFatr(6, 2, 3));
        Assert.assertEquals(2, Operation.maxComFatr(6, 2, 8));
        Assert.assertEquals(12, Operation.maxComFatr(36, 12, 48));

    }
}
