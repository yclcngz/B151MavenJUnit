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

public class C04_CheckBox_ClassWork {


         // a. Verilen web sayfasına gidin.
         // https://the-internet.herokuapp.com/checkboxes


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);

    }

    @Test
    public void checkBox() throws InterruptedException {

        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 =  driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkBox2 =  driver.findElement(By.xpath("(//input)[2]"));

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(3000);

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
