package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDown {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {

        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(4);
        select.selectByIndex(5);
        //Eger sadece secili olan option'lari yazdirmak istersem
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));  // Lambda ile cozum
        System.out.println("*************************************************");
        for (WebElement w : select.getAllSelectedOptions()){  // for ile cozum
            System.out.println(w.getText());
        }

        //Seceneklerden 4 tane sectigimi dogruyalalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //Sectigimiz seceneklerden ilkini "JavaScript" oldugunu dogrulayin
        System.out.println("Secilen seceneklerden ilki : " +select.getFirstSelectedOption().getText());
        Assert.assertEquals("JavaScript",select.getFirstSelectedOption().getText());

        //Sectigimiz seceneklerin hepsini kaldiralim
        select.deselectAll();
        bekle(3);

        //senKeys() methodu ile istedigimiz bir secenegi gonderelim
        diller.sendKeys("C#");
        bekle(3);

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm'den br secenek secelim
        selectVisibleText(diller,"Java");

        //index olarak secim yapacagimiz bir method olusturup programming languages ddm'den br secenek secelim
        selectIndex(diller,1);

        //value olarak secim yapacagimiz bir method olusturup programming languages ddm'den br secenek secelim
        selectValue(diller,"js");
    }

    public void selectVisibleText(WebElement ddm, String text){

        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm, int index){

        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByValue(value);

    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }
}
