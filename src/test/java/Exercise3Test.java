import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise3Test {

    @DataProvider
    public Object[][] modulData() {
        int mas1[] = new int[6];
        int a;
        //генерирует 3 случайных положительных чиисла от 0 до Integer.MAX_VALUE включительно
        for (int i =0; i<3; i++) {
            a = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1)));
            mas1[i] = a;
        }
        // генерирует 3 случайных отрицательных чиисла от Integer.MIN_VALUE до 0 не включительно
        for (int i =3; i<6; i++) {
            a = (int) (Math.random() * (0-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            mas1[i] = a;
        }
        return new Object[][]
                {
                        {mas1}
                };
        };

    @DataProvider
    public Object[][] ExactData() {
        int mas2[][] = new int[9][2];
        int a, b;
        // генерирует 3 пары случайных положительных чисел от 0 до Integer.MAX_VALUE/2 включительно
        for (int i = 0; i<3; i++) {
            a = (int) ((Math.random() * ((double) Integer.MAX_VALUE/2+1)));
            b = (int) ((Math.random() * ((double) Integer.MAX_VALUE/2+1)));
            mas2[i][0] = a;
            mas2[i][1] = b;
        }
        //генерирует 3 пары случайных чисел (1: отрицательное, от Integer.MIN_VALUE до 0 включительно
        // 2: положительное, от 0 до Integer.MAX_VALUE включительно)
        for (int i = 3; i<6; i++) {
            a = (int) (Math.random() * (1-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            b = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1)));
            mas2[i][0] = a;
            mas2[i][1] = b;
        }
        // генерирует 3 пары случайных отрицательных чисел от Integer.MIN_VALUE/2 до 0 включительно
        for (int i = 6; i<9; i++) {
            a = (int) (Math.random() * (1-(double)Integer.MIN_VALUE/2))+ Integer.MIN_VALUE/2;
            b = (int) (Math.random() * (1-(double)Integer.MIN_VALUE/2))+ Integer.MIN_VALUE/2;
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
        int mas3[][] = new int[9][2];
        int a, b;
        // генерирует 3 пары случайных положительных чисел от 0 до Integer.MAX_VALUE включительно (во второе число ноль не входит)
        for (int i = 0; i<3; i++) {
            a = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1)));
            b = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1-1)))+1;
            mas3[i][0] = a;
            mas3[i][1] = b;
        }
        //генерирует 3 пары случайных чисел (1: положительное, от 0 до Integer.MAX_VALUE включительно
        // 2:отрицательное, от Integer.MIN_VALUE до 0 не включительно )
        for (int i = 3; i<6; i++) {
            a = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1)));
            b = (int) (Math.random() * (0-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            mas3[i][0] = a;
            mas3[i][1] = b;
        }
        // генерирует 3 пары случайных отрицательных чисел от Integer.MIN_VALUE/2 до 0 включительно (во второе число 0 не входит)
        for (int i = 6; i<9; i++) {
            a = (int) (Math.random() * (1-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            b = (int) (Math.random() * (0-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            mas3[i][0] = a;
            mas3[i][1] = b;
        }
        return new Object[][]
                {
                        {mas3}
                };
    }
    @Test(dataProvider = "modulData")
    public void TestAbs(int mass1[]) throws Exception {
        int n;
        for (int i = 0; i < 6; i++) {
            n = Math.abs(mass1[i]);
            if (mass1[i] >= 0) {
                Assert.assertEquals(mass1[i], n, "ошибка функции abs");
                System.out.println("Берем модуль: " + mass1[i]);
                System.out.println(" модуль от данного числа =  " + mass1[i] + " функция abs вернула " + n);
            }
            else {
                Assert.assertEquals(-mass1[i], n, "ошибка функции abs");
                System.out.println("Берем модуль: " + mass1[i] );
                System.out.println(" модуль от данного числа =  " + (-mass1[i]) + " функция abs вернула " + n );
            }
        }
    }

    @Test (dataProvider = "ExactData")
    public void TestAddExact(int mass2[][]) throws Exception {
        int n, summ;
        for (int i = 0; i < 9; i++) {
            n = Math.addExact(mass2[i][0], mass2[i][1]);
            summ = (mass2[i][0] + mass2[i][1]);
            Assert.assertEquals(summ, n, "ошибка функции addExact");
            System.out.println("Складываем числа: " + mass2[i][0] + " , " + mass2[i][1]);
            System.out.println(summ + " = " + n );
        }
    }

    @Test (dataProvider = "FloorDivData")
    public  void TestFloorDiv(int mass3[][]) throws Exception{
        int n, fldiv;
        for (int i = 0; i < 9; i++) {
            n = Math.floorDiv(mass3[i][0], mass3[i][1]);
            if (mass3[i][0] >= 0 && mass3[i][1] < 0) {
            fldiv = (int) Math.floor ((double) mass3[i][0]/ (double) mass3[i][1]) ;
            }
            else {
                fldiv = (mass3[i][0] / mass3[i][1]);
            }
            Assert.assertEquals(fldiv, n, "ошибка функции floorDiv");
            System.out.println("Целочисленное деление чисел: " + mass3[i][0] + " " + mass3[i][1]);
            System.out.println(fldiv + " = " + n );
        }
            }
    }
