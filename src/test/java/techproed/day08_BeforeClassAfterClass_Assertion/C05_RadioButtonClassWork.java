package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtonClassWork {


   /*   1.Bir class oluşturun : RadioButtonTest
        2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
              - https://www.facebook.com adresine gidin
              - Cookies’i kabul edin
              - “Create an Account” button’una basin
              - “radio buttons” elementlerini locate edin
              - Secili degilse cinsiyet butonundan size uygun olani secin

    */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Test
    public void radioButton() throws InterruptedException {

      // https://www.facebook.com adresine secin
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
      // Cookies’i kabulsecin
      // “Create an Account” button’una secin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        Thread.sleep(3000);
      // “radio buttons” elementlerini locat edin
        WebElement kadin = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
      // Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkek.isSelected()){
            erkek.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
