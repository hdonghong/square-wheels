package pers.hdh.stack;

/**
 * Test class<br/>
 *
 * @author hdonghong
 * @date 2018/05/04
 */
public class Test {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
