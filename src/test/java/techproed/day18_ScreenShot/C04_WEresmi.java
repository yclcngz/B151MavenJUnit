package techproed.day18_ScreenShot;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {
    /*
    Bir webelementin resmini almak icin once webwlwmwnti lacate edip bir webelemente assing ederiz ve bu webelementi direk getScreenShot() methodunu
    kullanarak resmini belirttigimiz dosyaya kaydederiz
     */


    @Test
    public void test01() throws IOException {

        //Amzon sayfasina gidelim
        driver.get("https://www.amazon.com");

        bekle(2);
        //ipone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //cikan sonuc yazisinin resmini alalim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/elementResmi/WEscreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
