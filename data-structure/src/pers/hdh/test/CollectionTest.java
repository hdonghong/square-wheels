package pers.hdh.test;

import org.junit.Test;
import pers.hdh.list.DhArrayList;
import pers.hdh.list.DhList;

/**
 * CollectionEest class<br/>
 *
 * @author hdonghong
 * @date 2018/03/30
 */
public class CollectionTest {

    @Test
    public void testArrayList() {
        DhList<String> list = new DhArrayList<>();

        list.insert("aaa");
        list.insert("bbb");
        list.insert("ccc");
        list.insert("ddd");
        System.out.println("list.size=" + list.size() + ", list.data=" + list.toString());

        list.insert(0, "插入");
        System.out.println("list.size=" + list.size() + ", list.data=" + list.toString());

        System.out.println("list.get(0)=" + list.get(0));
        System.out.println("list.remove(0)" + list.remove(0));
        System.out.println("list.remove(\"没有的值\")" + list.remove("没有的值"));

        DhArrayList<String> list2 = new DhArrayList<>(list);
        System.out.println("list2.size=" + list2.size() + ", list2.data=" + list2.toString());

        for (String str : list2) {
            System.out.println(str);
        }

        list.clear();
        System.out.println("list.size=" + list.size() + ", list.data=" + list.toString());
    }
}
