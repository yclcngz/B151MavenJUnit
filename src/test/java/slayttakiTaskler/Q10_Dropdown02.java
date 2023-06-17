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
import java.util.List;

public class Q10_Dropdown02 {

                          //   https://www.amazon.com/ adresine gidin.
                          // Test 1
                          // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

                          // -Test 2
                          // 1.Kategori menusunden Books secenegini secin
                          // 2. Arama kutusuna Java yazin ve aratin
                          // 3. Bulunan sonuc sayisini yazdirin
                          //  Sonucun Java kelimesini icerdigini test edin


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test01() {
        WebElement ddm = driver.findElement(By.xpath("//*[@name='url']"));
        Select select = new Select(ddm);
       int actualkategoriSayisi = select.getOptions().size();
        System.out.println(actualkategoriSayisi); // 28
        int exoextedKatgrSayisi = 45;
        Assert.assertNotEquals(exoextedKatgrSayisi,actualkategoriSayisi);
    }

    @Test
    public void test02() {
        WebElement ddm = driver.findElement(By.xpath("//*[@name='url']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucSayisi = sonucYazisi.getText().split(" ")[3];
        System.out.println(sonucSayisi);

        String actual = sonucYazisi.getText();
        String expected = "Java";

        Assert.assertTrue(actual.contains(expected));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
