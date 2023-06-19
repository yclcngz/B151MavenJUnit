package techproed.day11_iframe_WindovHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {

    /*
             Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline frame yani IFRAME denir.
        Bir sayfada iframe varsa iframe içindeki webelementi handle edebilmek için switchTo() methoduyla iframe'e
        geçiş yapmamız gerekir. Eğer geçiş yapmazsak nosuchelementexception alırız.
        Alert'ten farkı alert çıktığında hiçbir webelementi locate edemeyiz. Iframe olsada locate ederiz fakat
    handle edemeyiz
     */

    @Test
    public void iframe() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        bekle(3);

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String yazi = driver.findElement(By.xpath("(//p)[1]")).getText();
        Assert.assertTrue(yazi.contains("black border"));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String appYazi =  driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Applications lists",appYazi);

        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        driver.switchTo().defaultContent();
       //driver.get(driver.getCurrentUrl()); // --> Sayfayi yeniledik
       //driver.navigate().refresh();
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

      /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frameWe = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frameWe) geçiş yapabiliriz.
         */


    }
}
