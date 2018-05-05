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
}
