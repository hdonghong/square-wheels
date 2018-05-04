import impl.Converter;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void ten2Two() throws Exception {
        // 0
        Assert.assertEquals("00000000000000000000000000000000", Converter.Ten2Two(0));
        // 普通正数
        Assert.assertEquals("00000000000000000000000000001010", Converter.Ten2Two(10));
        // 普通负数
        Assert.assertEquals("10000000000000000000000000001011", Converter.Ten2Two(-11));
        // 特殊正数
        Assert.assertEquals("01111111111111111111111111111111", Converter.Ten2Two(Integer.MAX_VALUE));
        // 特殊负数
        Assert.assertEquals("10000000000000000000000000000000", Converter.Ten2Two(Integer.MIN_VALUE));
        Assert.assertEquals("11111111111111111111111111111111", Converter.Ten2Two(Integer.MIN_VALUE+1));
    }

}