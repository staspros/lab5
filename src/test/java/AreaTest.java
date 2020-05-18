import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaTest {
   private Area object_area = new Area();
   @Test
    public void TestArea() throws Exception {
       Assert.assertEquals(6, object_area.area(2, 3));
   }
}
