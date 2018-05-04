package impl;

import java.util.Stack;

/**
 * Converter class<br/>
 * （1）	使用一个栈，将十进制转换成二进制
 * @author hdonghong
 * @date 2018/05/04
 */
public class Converter {

    /**
     * 10进制转成2进制，仅考虑32位
     * @param number
     * @return
     */
    public static String Ten2Two(int number) {
        StringBuilder result = number < 0 ? new StringBuilder("1") : new StringBuilder("0");
        result.append("0000000000000000000000000000000");

        if (number == Integer.MIN_VALUE) {
            return result.toString();
        }
        number = Math.abs(number);
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            stack.push(number % 2);
            number >>= 1;
        }

        if (stack.size() > 0) {
            result.replace(32 - stack.size(), 32, "");
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
        }

        return result.toString();
    }
}
