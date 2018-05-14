import impl.Phone;

import static org.junit.Assert.*;

public class PhoneTest {

    /** 模拟来电，接电话，打电话的流传 */
    public static void main(String[] args) {
        Phone iphone4 = new Phone();

        // 来电
        String number1 = iphone4.rings();
        // 拒接
        iphone4.refuse(number1);

        // 又来电
        String number2 = iphone4.rings();
        // 又拒接
        iphone4.refuse(number2);

        // 还来电
        String number3 = iphone4.rings();
        // 接电吧
        iphone4.receive(number3);

        // 拨打回去
        iphone4.call(number1);
        iphone4.call(number2);

        // 查看未接
        System.out.println(iphone4.showMissedCalls());
        // 查看已接
        System.out.println(iphone4.showReceivedCalls());
        // 查看已拨
        System.out.println(iphone4.showDialedCalls());

    }

}