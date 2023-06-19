package slayttakiTaskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Q13_HandleIframe01 extends TestBase {

    @Test
    public void iframeTest() {

        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve yazdirin konsolda
        WebElement metin = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(metin.isEnabled());
        System.out.println(metin.getText()); //An iFrame containing the TinyMCE WYSIWYG Editor

        // Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");
        bekle(3);

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement istenenMetin = driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));
        Assert.assertTrue(istenenMetin.isDisplayed());
    }
}
