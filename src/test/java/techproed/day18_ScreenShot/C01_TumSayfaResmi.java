package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {

    /*/
    SCREENSHOT
       Seleniumda tum sayfa goruntusunu almak icin TakeScreenShot arayuzunden bir obje olusturup driver'e esitleriz.
       Arayuzler farkli oldugu icin casting yapariz.Ve bu olusturdugumuz obje ile getScreenShotAs methodu ile sayfanin resmini aliriz. Alms oldugumuz resmi
       projemizde nereye kaydedeceksek oranin yolunu belirtiriz
     */


    @Test
    public void test01() throws IOException {
        //techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");

        //cikan reklemi kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //ve ekran goruntusu alalim
        /*
        ILk olarak screenshot aldigimizda nereye kaydetmek istiyorsak oranin yolunu belirtelim
        Ikinci olarak TakesScreenShot Arayuzunden obje olustururuz
        Ucuncu olarak FileUtils classindan copyFile() methodu ile ts objemizi kullanarak getScreenShot() methodu ile
        dosya yolunu belirtecegiz
         */
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot4.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("techproed/ScreenShot/screenShot.png"));

    }

    @Test
    public void test03() throws IOException {

        /*
        Kaydettigimiz ekrangoruntusu herseferinde ayni dosya uzerine yazmamasi icin dosya isminden sonra String bir
        degiskene tarih formeti atayabiliriz
         */

        //techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");

        //cikan reklemi kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //ve ekran goruntusu alalim
        /*
        SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir Strig'e assen ederiz, ve bunu dosya isminden once belirtiriz

         */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }

    @Test
    public void test04() throws IOException {

        //Amzon sayfasina gidelim
        driver.get("https://www.amazon.com");


        //ve ekran goruntusu alalim

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


    }
}
