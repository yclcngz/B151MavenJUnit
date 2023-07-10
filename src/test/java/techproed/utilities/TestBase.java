package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {

     /*
        TestBase class'ından obje oluşturmanın önüne geçmek için bu class'ı abstract yapabiliriz.
    TestBase testBase = new TestBase(); yani bu şekilde obje oluşturmanın önüne geçmiş oluruz.
    Bu class'a extends yaptığımız test class'larından ulaşabiliriz
     */

   protected WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    //HARD WAIT (Bekleme Methodu)
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // Selenium Wait / Expilicit Wait
    //visibilitiOf(element) methodu
    public void visibleWait(WebElement element, int saniye){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // visibilityOfElementLocated(locator) methodu
    public void visibleWait(By locator, int saniye){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    //AlleretWait methodu
    public void alertWait(int saniye) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }


    //FluentWait visible method

    public void visibleFluentWait(WebElement element, int saniye, int milisaniye){
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).until(ExpectedConditions.visibilityOf(element));
    }


        //AcceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //DismissAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //getTextAlert
    public String getTextAlert(){
       return driver.switchTo().alert().getText();
    }

    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }


    //Dropdown visibleTest
    public void selectVisibleText(WebElement ddm, String text){

        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //Dropdown indexTest
    public void selectIndex(WebElement ddm, int index){

        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //Dropdown valueTest
    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //SwichTo Window-1
    public void switchToWindow(int index){
        List<String> pencerelere = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencerelere.get(index));
    }

    //SwichTo Window-2
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }


    //Tum Sayfa Resmi (ScreenShot)

    public void tumSayfaResmi(){

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //WebElement Resmi (Webelemnt ScreenShot)

    public void webElementResmi(WebElement element){

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/elementResmi/WEscreenShot" + tarih + ".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
