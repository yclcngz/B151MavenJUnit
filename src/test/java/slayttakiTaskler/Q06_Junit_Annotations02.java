package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q06_Junit_Annotations02 {

    /*
                 - https://www.facebook.com adresine gidin
                 - Cookies’i kabul edin
                 - “Create an Account” button’una basin
                 - “radio buttons” elementlerini locate edin
                 - Secili degilse cinsiyet butonundan size uygun olani
                 seci

     */


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

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        WebElement kadin = driver.findElement(By.xpath("(//input)[16]"));
        WebElement erkek = driver.findElement(By.xpath("(//input)[17]"));
        WebElement ozel = driver.findElement(By.xpath("(//input)[18]"));
        if (!erkek.isSelected()) {
            Thread.sleep(3000);
            erkek.click();
        }


    }
}
