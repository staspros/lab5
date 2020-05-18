import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise3Test {

    @DataProvider
    public Object[][] modulData() {
        return new Object[][]{
                {10, 10},
                {10, -10},
                {129, -129},
                {129, 129}

        };
    }

    @DataProvider
    public Object[][] ExactData() {
        return new Object[][]{
                {6, 3, 3},
                {8, 10, -2},
                {3, 2, 1},
                {-4, -2, -2}
        };
    }

    @DataProvider
    public Object[][] FloorDivData() {
        return new Object[][]{
                {1, 4, 3},
                {0, 12, 100},
                {-3, 9, -3},
                {14, 225, 16}
        };
    }
    @Test(dataProvider = "modulData")
    public void TestAbs(int result, int Abs) throws Exception {
       Assert.assertEquals(result, Math.abs(Abs),"ошибка модуля");
   }

    @Test (dataProvider = "ExactData")
    public void TestAddExact(int result, int a, int b) throws Exception {
        Assert.assertEquals(result, Math.addExact(a, b),"ошибка функции addExact");
    }

    @Test (dataProvider = "FloorDivData")
    public  void TestFloorDiv(int result, int a, int b) throws Exception{
        Assert.assertEquals(result, Math.floorDiv(a, b),"ошибка функции floorDiv");

    }
}
