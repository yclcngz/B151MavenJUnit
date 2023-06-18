package slayttakiTaskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class Q12_HandleAlert extends TestBase {

            //https://testcenter.techproeducation.com/index.php?page=javascript-alerts
            //adresine gidin.
            //Bir metod olusturun: acceptAlert
            //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result
            //mesajının “You successfully clicked an alert” oldugunu test edin.
            //Bir metod olusturun: dismissAlert
            //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result
            //mesajının “You clicked: Cancel” oldugunu test edin.
            //Bir metod olusturun: sendKeysAlert
            //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK
            //butonuna tıklayın ve result mesajında isminizin görüntülendiğini
            //doğrulayın


    @Test
    public void accepAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result
        //mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        acceptAlert();

        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedSonucYazisi = "You successfully clicked an alert";
        Assert.assertEquals(expectedSonucYazisi,sonucYazisi);
    }

    @Test
    public void dismissAlertt() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result
        //mesajının “You clicked: Cancel” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        dismissAlert();

        String sonucYazisi2 = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedSonucYazisi2 = "You clicked: Cancel";
        Assert.assertEquals(expectedSonucYazisi2,sonucYazisi2);
    }

    @Test
    public void sendKeysAlert() {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK
        //butonuna tıklayın ve result mesajında isminizin görüntülendiğini
        //doğrulayın
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        sendKeysAlert("Yucel");
        acceptAlert();
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedSonucYazisi = "Yucel";
        Assert.assertTrue(sonucYazisi.contains(expectedSonucYazisi));



    }
}
