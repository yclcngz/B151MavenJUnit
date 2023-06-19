package techproed.day12_windowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    @Test
    public void test01() {

        //Aşağıdaki bilgileri kullanarak authentication yapınız:

        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin

        //    Başarılı girişi doğrulayın.
       driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       bekle(3);

        //Başarılı bir girişten sonra Congratulations! yazısının çıktığını doğrulayın
        WebElement text =  driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();

        //Başlığın Elemental Selenium olmadığını doğrulayın
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals("Elemental Selenium",actualTitle);


        //DDM'den java seçelim

        WebElement ddm = driver.findElement(By.xpath("//*[@class='dropdown-language']"));

        /*
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");

         */

        selectVisibleText(ddm,"Java");


    }
}
