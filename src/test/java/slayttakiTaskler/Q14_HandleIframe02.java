package slayttakiTaskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Q14_HandleIframe02 extends TestBase {


    @Test
    public void iframeOdev() {

        //https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // sayfadaki toplam iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("ayfadaki Iframe sayisi : "+iframeSayisi);  // 1

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualtitle = driver.findElement(By.xpath("//h3")).getText();
        System.out.println(actualtitle);
        String exceptedWord = "Editor";
        Assert.assertTrue(actualtitle.contains(exceptedWord));

        // Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        bekle(2);

        // Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        textBox.sendKeys("iframein icindeyim");

        // Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        WebElement metin = driver.findElement(By.xpath("//*[@style='text-align: center;']"));
        Assert.assertTrue(metin.getText().contains("Elemental Selenium"));

    }
}
