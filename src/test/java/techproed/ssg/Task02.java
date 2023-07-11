package techproed.ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Task02 extends TestBase {

    //https://www.kitapyurdu.com/ adresine gidiniz.
    //Arama motorunda “Java” kelimesini aratınız.
    //Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
    //Sepetinize gidiniz.
    //Eklenen iki ürünün de sepette göründüğünü doğrulayınız.
    //İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
    //“Seçilenleri Daha Sonra Al” fonksiyonunun görünür olmadığını doğrulayınız.
    //Ürünlere ait kontrol kutularını seçili hale getiriniz.
    //Kontrol kutularının seçili olduğunu doğrulayınız.
    //İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
    //İkinci ürünün kontrol kutusunun seçili olmadığını doğrulayınız.
    //“Seçilenleri Daha Sonra Al” fonksiyonunun aktif olduğunu doğrulayınız.

    @Test
    public void test01() {

        //Verilen adrese gidilir
        driver.get("https://www.kitapyurdu.com/");

        //Arama motorunda "java" kelimesi aratilir
        driver.findElement(By.id("search-input")).sendKeys("java", Keys.ENTER);

        //Listedeki birinci ve ikinci ürünü sepete eklenir
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[4]")).click();
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[6]")).click();

        //Sepetinize gidilir
        driver.findElement(By.id("cart-items")).click();

        //Eklenen iki ürünün de sepette göründüğü dogrulanir.
        WebElement birinciKitab = driver.findElement(By.xpath("(//*[@class='alt'])[2]"));
        Assert.assertTrue(birinciKitab.isDisplayed());

        WebElement ikinciKitab = driver.findElement(By.xpath("(//*[@class='alt'])[3]"));
        Assert.assertTrue(ikinciKitab.isDisplayed());

        //İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
        //“Seçilenleri Daha Sonra Al” fonksiyonunun görünür olmadığını doğrulayınız.
        //Ürünlere ait kontrol kutularını seçili hale getiriniz.
        //Kontrol kutularının seçili olduğunu doğrulayınız.
        //İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
        //İkinci ürünün kontrol kutusunun seçili olmadığını doğrulayınız.
        //“Seçilenleri Daha Sonra Al” fonksiyonunun aktif olduğunu doğrulayınız..






    }
}
