package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alert extends TestBase {

    @Test
    public void test01() {

        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
         String expected = "You clicked a button";
        System.out.println("Alert ustundeki yazi : "+getTextAlert());
        Assert.assertEquals(expected,getTextAlert());

        //Ve alert'ü kapatalım
        acceptAlert();
    }

    @Test
    public void test02() {

        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karşsindaki buttona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();

        //Çıkan alertte iptal'e basalım
        dismissAlert();

        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);
    }

    @Test
    public void test03() {

        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();

        //çıkan alerte ismimizi girelim
        sendKeysAlert("Yucel");
        acceptAlert();

        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Yucel"));

    }
}
