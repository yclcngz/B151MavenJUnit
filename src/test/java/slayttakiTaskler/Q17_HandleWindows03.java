package slayttakiTaskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Q17_HandleWindows03 extends TestBase {

    @Test
    public void test() {

         //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

         //Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals("Windows",driver.getTitle());

         //Click here a tiklayin
        driver.findElement(By.xpath("(//a)[2]")).click();

         //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulay
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        Assert.assertEquals("New Window",driver.getTitle());
        bekle(3);
    }
}
