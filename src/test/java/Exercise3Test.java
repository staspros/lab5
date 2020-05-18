import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3Test {

    private Object ArithmeticException;

    @Test
    public void TestAbs() throws Exception {
       Assert.assertEquals(10, Math.abs(10),"ошибка модуля");
       Assert.assertEquals(10, Math.abs(-10),"ошибка модуля");
   }

    @Test
    public void TestAddExact() throws Exception {
        Assert.assertEquals(6, Math.addExact(3, 3),"ошибка функции addExact");
        Assert.assertEquals(8, Math.addExact(10, -2),"ошибка функции addExact");
    }

    @Test
    public  void TestFloorDiv() throws Exception{
        Assert.assertEquals(1, Math.floorDiv(4, 3),"ошибка функции floorDiv");
        Assert.assertEquals(0, Math.floorDiv(12, 100),"ошибка функции floorDiv");
        Assert.assertEquals(-3, Math.floorDiv(9, -3),"ошибка функции floorDiv");
    }
}
