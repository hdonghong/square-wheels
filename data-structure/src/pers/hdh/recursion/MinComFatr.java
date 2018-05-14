package pers.hdh.recursion;

/**
 * MinComFatr class<br/>
 *
 * @author hdonghong
 * @date 2018/05/06
 */
public class MinComFatr {

    public static int get(int a, int b) {
        return b == 0 ? a : get(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(get(1, 16));
    }
}
