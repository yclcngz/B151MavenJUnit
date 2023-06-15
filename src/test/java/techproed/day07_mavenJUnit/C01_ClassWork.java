package techproed.day07_mavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

//        2. Signin buttonuna tiklayin
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='signin_button']"));
        signInButton.click();

//        3. Login alanine “username” yazdirin
//        4. Password alanine “password” yazdirin
//        5. Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username", Keys.TAB, "password", Keys.ENTER);
        driver.navigate().back();

//        6. online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

//        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
//        8. tarih kismina “2020-09-10” yazdirin

        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("600", Keys.TAB, "2020-09-10");

//       9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();

//        10.“The payment was successfully submitted.” mesajinin ciktigini
//        control edin
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
        String exceptedSonucYzisi = "The payment was successfully submitted.";

        if (sonucYazisi.equals(exceptedSonucYzisi)) {
            System.out.println("Q02 : PASSED");
        } else System.out.println("Q02 :FAILED");

        //Sayfayi kapatiniz
        driver.close();


    }
}
