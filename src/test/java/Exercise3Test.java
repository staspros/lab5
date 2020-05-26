import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise3Test {

    @DataProvider
    public Object[][] modulData() {
        int mas1[][] = new int[6][2];
        int a, b;
        for (int i =0; i<3; i++) {
            a = (int) (Math.random() * (Integer.MAX_VALUE-1));
            b = (int) (Math.random() * (Integer.MIN_VALUE+1));
            mas1[i*2][0] = a;
            mas1[i*2][1] = a;
            mas1[i*2 +1][0] = -b;
            mas1[i*2+1][1] = b;
        }
        return new Object[][]
                {
                        {mas1}
                };
        };
    @DataProvider
    public Object[][] ExactData() {
        int mas2[][] = new int[6][2];
        int a, b;
        int n = Integer.MAX_VALUE-1;
        for (int i = 0; i<6; i++) {
            a = (int) (Math.random() * (n) - Integer.MAX_VALUE/2);
            b = (int) (Math.random() * (n) - Integer.MAX_VALUE/2);
            mas2[i][0] = a;
            mas2[i][1] = b;
        }
        return new Object[][]
                {
                        {mas2}
                };
    };

    @DataProvider
    public Object[][] FloorDivData() {
        int mas3[][] = new int[6][2];
        int a, b;
        for (int i = 0; i<3; i++) {
            a = (int)(Math.random() * (Integer.MAX_VALUE-1) +2);
            b = (int)(Math.random() * (Integer.MAX_VALUE-1) +2);
            mas3[i][0] = a;
            mas3[i][1] = b;
        }
        return new Object[][]
                {
                        {mas3}
                };
    }
    @Test(dataProvider = "modulData")
    public void TestAbs(int mass1[][]) throws Exception {
        int n;
        for (int i = 0; i < 6; i++) {
            n = Math.abs(mass1[i][1]);
            Assert.assertEquals(mass1[i][0], n, "ошибка модуля");
            System.out.println("Берем модуль: " + mass1[i][1] );
            System.out.println(mass1[i][0]+ " = " + n );
        }
    }
    @Test (dataProvider = "ExactData")
    public void TestAddExact(int mass2[][]) throws Exception {
        int n, summ;
        for (int i = 0; i < 6; i++) {
            n = Math.addExact(mass2[i][0], mass2[i][1]);
            summ = (mass2[i][0] + mass2[i][1]);
            Assert.assertEquals(summ, n, "ошибка функции addExact");
            System.out.println("Складываем числа: " + mass2[i][0] + " " + mass2[i][1]);
            System.out.println(summ + " = " + n );
        }
    }

    @Test (dataProvider = "FloorDivData")
    public  void TestFloorDiv(int mass3[][]) throws Exception{
        int n, fldiv;
        for (int i = 0; i < 3; i++) {
            n = Math.floorDiv(mass3[i][0], mass3[i][1]);
            fldiv = (mass3[i][0] / mass3[i][1]);
            Assert.assertEquals(fldiv, n, "ошибка функции floorDiv");
            System.out.println("Целочисленное деление чисел: " + mass3[i][0] + " " + mass3[i][1]);
            System.out.println(fldiv + " = " + n );
        }
    }
}
