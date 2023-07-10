package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;

public class C03_TumSayfaResmi extends TestBase {

    @Test
    public void test01() {

        //techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");

        //cikan reklemi kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //ve ekran goruntusu alalim
        tumSayfaResmi();
    }
}
