import impl.SortedSeqList;
import org.junit.Assert;
import org.junit.Test;

/**
 * SortedSeqListTest class<br/>
 * 测试有序顺序表
 * @author hdonghong
 * @date 2018/04/11
 */
public class SortedSeqListTest {

    @Test
    public void testInsert() {
        SortedSeqList<Integer> sortedSeqList = new SortedSeqList<>();
        sortedSeqList.insert(2);
        sortedSeqList.insert(1);
        sortedSeqList.insert(3);
        sortedSeqList.insert(5);
        sortedSeqList.insert(1);
        Assert.assertEquals("[1,1,2,3,5]", sortedSeqList.toString());
    }

    @Test
    public void testRemove() {
        SortedSeqList<Integer> sortedSeqList = new SortedSeqList<>();
        sortedSeqList.insert(2);
        sortedSeqList.insert(1);
        sortedSeqList.insert(3);
        sortedSeqList.insert(5);
        sortedSeqList.insert(1);

        sortedSeqList.remove(1);
        Assert.assertEquals("[1,2,3,5]", sortedSeqList.toString());
        sortedSeqList.remove(5);
        Assert.assertEquals("[1,2,3]", sortedSeqList.toString());
        sortedSeqList.remove(2);
        Assert.assertEquals("[1,3]", sortedSeqList.toString());
        sortedSeqList.remove(1);
        sortedSeqList.remove(3);
        Assert.assertEquals("[]", sortedSeqList.toString());
    }
}
