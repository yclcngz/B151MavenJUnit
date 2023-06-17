package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //üç saniye bekle
        bekle(3);

        //Başlığın Bootcamp içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
