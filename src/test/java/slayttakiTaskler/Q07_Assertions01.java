package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q07_Assertions01 {

    /*

                   https://www.youtube.com adresine gidin
                   Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri
                  yapin
                  => Sayfa başlığının “YouTube” oldugunu test edin
                  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
                  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
                  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayi

     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test01() {
         String actualTitle = driver.getTitle();
         String expectedTitle = "YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

        WebElement imgYoutube = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(imgYoutube.isDisplayed());
    }

    @Test
    public void test02() {
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test03() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertNotEquals(actualTitle,expectedTitle);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
