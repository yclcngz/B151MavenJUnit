package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClassAfterClass {

    /*
        Before class ve After class test methodlarımızdan önce bir sefer çalışmasını istediğimiz kodları bu methodlara
    koyarız. Mesala testlerimiz başlamadan önce database bağlantısı yapmak için kullanılabilir yada hangi driver'ı
    kullanacaksak yine bunu BeforeClass'a koyabiliriz. Aynı şekilde testlerimizden sonra database'i sonlandırmak için
    yada raporlarımızı sonlandırmak için de kullanabiliriz
     */
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {

        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test01() {

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("QA", Keys.ENTER);
    }

    @Test
    public void test02() {
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Developer", Keys.ENTER);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
