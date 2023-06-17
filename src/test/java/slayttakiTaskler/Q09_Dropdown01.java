package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q09_Dropdown01 {

    WebDriver driver;

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın


    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        System.out.println("******************");
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        List<WebElement> allElementddm = select.getOptions();
        int allElementSize = allElementddm.size();
        System.out.println(allElementSize);

        if (allElementSize==4) {
            System.out.println("True");
        }else System.out.println("False");

        System.out.println("**********");

        //2.YOL :
        List <WebElement> tumDdm = select.getOptions();
        int expectedSize = 4;
        int actualSize = tumDdm.size();
        if (actualSize==expectedSize){
            System.out.println("True");
            Assert.assertEquals(actualSize, expectedSize);
        }else{
            System.out.println("false");
            Assert.assertNotEquals(actualSize, expectedSize);
         }

        System.out.println("*************");

        //3.YOL :
        Assert.assertNotEquals(expectedSize,actualSize);
        System.out.println(actualSize==expectedSize);


    }
}
