package techproed.day11_iframe_WindovHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {


    @Test
    public void windowHandle() {

          /*
        Eğer sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle başka sayfaya gittikten sonra
        tekrar ilk açtığınız sayfaya dönmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir değişkene handle değerini assingn ederseniz tekrar ilk açılan sayfaya dönmek istediğinizde
        driver.switchTo().window(ilksayfaHandleDeğeri) ile geçiş yapabilirsiniz.
         */


        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techprowindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW); //WindowType.TAB --> Yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();


        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHabndle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techprowindowHandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);

        //linkedIn sayfasına geçiniz:
         driver.switchTo().window(linkedinWindowHabndle);
    }

    @Test
    public void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techprowindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB); //WindowType.TAB --> Yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();


        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHabndle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techprowindowHandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHabndle);
    }
}
