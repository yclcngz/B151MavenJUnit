package slayttakiTaskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Q15_HandleWindows01 extends TestBase {


    @Test
    public void handleWindow() {


        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilksdayfaHandle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String textActual = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",textActual);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet",driver.getTitle());

        //Click Here butonuna basın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
        1.WAY:
        switchToWindow(1);
        Assert.assertEquals("New Window",driver.getTitle());

        2.WAY:
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        Assert.assertEquals("New Window",driver.getTitle());

         */

        //3.WAY:
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals("New Window",driver.getTitle());


        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.getTitle());

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın

        /*1.YOL
        switchToWindow2(0);
        Assert.assertEquals("The Internet",driver.getTitle());

        2.YOL:
        driver.switchTo().window(ilksdayfaHandle);
        Assert.assertEquals("The Internet",driver.getTitle());

         */

        //3.YOL:
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(0));

    }
}
