package techproed.day12_windowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();


        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String ilkSayfatxt = driver.findElement(By.xpath("//h3")).getText();
        String expectedTxt = "Opening a new window";
        Assert.assertEquals(expectedTxt,ilkSayfatxt);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String ilkSayfaTitle = driver.getTitle();
        String expectedTitleIlkSayfa = "The Internet";
        Assert.assertEquals(expectedTitleIlkSayfa,ilkSayfaTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);

        /*
            Bir button'a click yaptığımızda kontrolümüz dışında yeni bir sekme yada pencere açılırsa
         yeni açılan pencerenin handle değerini bilmediğim için normal getWindowHandle ile driver'imi yeni pencere
         geçiremem. Bunu getWindowHandles() methoduyla açılan tüm pencereleri bir Set'e assign edip, ilkaçtiğimiz
         pencere değilse ikinci açılan yeni penceredir mantığıyla bir loop için çözebiliriz
         */


        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        Set<String> handelDegerleri = driver.getWindowHandles();
        for (String w : handelDegerleri){

            if (!w.equals(ilkSayfaHandle)) {
                driver.switchTo().window(w);
            }
        }
        String ikinciSayfaTitle = driver.getTitle();
        String ikinciSExpectedTitle = "New Window";
        Assert.assertEquals(ikinciSExpectedTitle,ikinciSayfaTitle);

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        Assert.assertEquals("The Internet",ilkSayfaTitle);
        String ikinciSHandleDegeri = driver.getWindowHandle();

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSHandleDegeri);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);
        bekle(3 );
    }

    @Test
    public void test02() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window",ikinciSayfaTitle);
        bekle(2);
        /*
            getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
        Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
         driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
         */


        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertEquals("The Internet",ilkSayfaTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
    }

    @Test
    public void test03() {


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window",ikinciSayfaTitle);
        bekle(2);


        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertEquals("The Internet",ilkSayfaTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }

    @Test
    public void test04() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        switchToWindow(1);
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window",ikinciSayfaTitle);
        bekle(2);


        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        switchToWindow(0);
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertEquals("The Internet",ilkSayfaTitle);

        //  ikinci sayfaya tekrar geçin.
        switchToWindow2(1);

        //  ilk sayfaya tekrar dönün.
        switchToWindow2(0);
    }
}
