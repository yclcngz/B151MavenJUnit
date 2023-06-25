package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //sayfannin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {

        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanin en altina scroll yapalim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);

        //sayfannin en ustune scroll yapalim
        actions.sendKeys(Keys.HOME).perform();

    }

    @Test
    public void test03() {


        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanin altina dogru scroll yapalim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        //sayfannin  ustune dogru scroll yapalim
        actions.scrollByAmount(0,-1500).perform();






    }
}
