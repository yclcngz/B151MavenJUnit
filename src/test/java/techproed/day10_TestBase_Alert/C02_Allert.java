package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_Allert extends TestBase {

    /*
            Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klik
         yapıp locate alamıyorsak, bu bir js Alert'tür.
            js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
         driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
         accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız.
         accept() --> onaylar
         dismiss() --> iptal eder
         */



    @Test
    public void acceptAlert() {

        //Bir metod olusturun:acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(sonucYazisi,expectedResult);
    }

    @Test
    public void dismissAlert() {

        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        bekle(2);
        driver.switchTo().alert().dismiss();
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expected = "successfuly";
        Assert.assertFalse(sonucYazisi.contains(expected));
    }

    @Test @Ignore //Calismasini istemedigimiz test notasyonundan sonra kullaniriz
    public void sendKeysAlert() {

        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Yucel");
        driver.switchTo().alert().accept();

        //result mesajında isminizin görüntülendiğini doğrulayın.
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String girilrnYazi = "Yucel";
        Assert.assertTrue(sonucYazisi.contains(girilrnYazi));
        bekle(2);
    }






}
