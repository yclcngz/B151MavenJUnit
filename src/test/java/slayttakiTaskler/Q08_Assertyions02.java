package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q08_Assertyions02 {


            //http://automationpractice.com/index.php sayfasina gidelim
            //Sign in butonuna basalim
            //Email kutusuna @isareti olmayan bir mail yazip enter’a
            //bastigimizda “Invalid email address” uyarisi ciktigini test edeli


    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test01() {
   /*
   sayfada problem var giris yapmadi sing in butonu yok o nedenle devamini yapamadim

    */
    }
}
