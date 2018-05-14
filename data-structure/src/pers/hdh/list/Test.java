package pers.hdh.list;

/**
 * Test class<br/>
 *
 * @author hdonghong
 * @date 2018/05/05
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
//        test(list);
        testRecursion(list);
    }

    public static void test(LinkedList list) {
        list.add(2, 666);
        list.set(0, 233);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }

    public static void testRecursion(LinkedList list) {
        list.addByRecursion(2, 666);
        list.setByRecursion(0, 233);
        System.out.println(list);

        list.removeByRecursion(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.getByRecursion(i) + "->");
        }
    }
}
