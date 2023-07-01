package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {

    @Test
    public void test01() {

        //Google anasayfasina gidelim
        driver.get("https://www.google.com");

        //Arama kutusunda shift tusuna basili tutarak selenium yazdirin veshift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys("-java",Keys.ENTER).perform();
    }

    @Test
    public void test02() {

        //Google anasayfasina gidelim
        driver.get("https://www.google.com");

        //Arama kutusunda shift tusuna basili tutarak selenium yazdirin veshift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
    }

    @Test
    public void test03() {

        //google sayfasına gidelim
        driver.get("https://www.google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium",Keys.ENTER);

        //Sayfayı bekleyin
        bekle(2);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.CONTROL,"a","x");


        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        bekle(2);
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.CONTROL,"v",Keys.ENTER);

    }
}
