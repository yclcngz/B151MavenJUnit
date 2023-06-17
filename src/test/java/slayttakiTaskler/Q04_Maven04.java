package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04_Maven04 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1.“https://www.saucedemo.com” Adresine gidin
        driver.navigate().to("https://www.saucedemo.com");
       // 2. Username kutusuna “standard_user” yazdirin
        // 3. Password kutusuna “secret_sauce” yazdirin
        // 4. Login tusuna basin
        driver.findElement(By.xpath("(//input)[1]")).sendKeys("standard_user", Keys.TAB,"secret_sauce", Keys.TAB, Keys.ENTER);
        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[.='Sauce Labs Backpack'])[1]"));
        String ilkUrunName = ilkUrun.getText();
        System.out.println("Ilk Urun Name : " + ilkUrunName);
        ilkUrun.click();
       // 6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
       // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
       // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepettekiUrun = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        if (ilkUrunName.equals(sepettekiUrun)) {
            System.out.println("TEST : PASSED");
        }else System.out.println("TEST : FAILED");
        Thread.sleep(3000);
        // 9. Sayfayi kapati
        driver.close();
    }
}
