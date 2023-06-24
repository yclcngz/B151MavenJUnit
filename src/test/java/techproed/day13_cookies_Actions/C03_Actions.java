package techproed.day13_cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Actions extends TestBase {


    @Test
    public void test01() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git  “Account” secenegine tikla
        WebElement webElwmwntAL = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElwmwntAL).perform();

        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
