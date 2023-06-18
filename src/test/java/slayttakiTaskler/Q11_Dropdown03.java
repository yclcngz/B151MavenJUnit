package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q11_Dropdown03 {

                    //1.http://zero.webappsecurity.com/ Adresine gidin
                    //2. Sign in butonuna basin
                    //3. Login kutusuna “username” yazin
                    //4. Password kutusuna “password.” yazin
                    //5. Sign in tusuna basin
                    //6. Pay Bills sayfasina gidin
                    //7. “Purchase Foreign Currency” tusuna basin
                    //8. “Currency” drop down menusunden Eurozone’u secin
                    //9. “amount” kutusuna bir sayi girin
                    //10.“US Dollars” in secilmedigini test edin
                    //11.“Selected currency” butonunu secin
                    //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
                    //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@type='button']")).click();

        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password.” yazin
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='text']")).
                sendKeys("username", Keys.TAB,"password", Keys.TAB, Keys.TAB,Keys.ENTER);
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[.='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByIndex(6);

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("20", Keys.ENTER);
        driver.switchTo().alert().accept();

        //10.“US Dollars” in secilmedigini test edin
        WebElement us = driver.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        Assert.assertFalse(us.isSelected());

        //11.“Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();

        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        driver.findElement(By.id("purchase_cash")).click();
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
        String expectedSonucYazizi = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedSonucYazizi,sonucYazisi);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
