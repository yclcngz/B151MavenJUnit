package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {

    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        bekle(2);
        //sayfanın resmini alalım
        tumSayfaResmi();

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);


        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);


        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");


        //sayfanın resmini alalım
        tumSayfaResmi();


        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi2 = driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        webElementResmi(sonucYazisi2);


        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow2(0);
        tumSayfaResmi();

    }
}
