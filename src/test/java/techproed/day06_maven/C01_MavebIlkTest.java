package techproed.day06_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_MavebIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");

//        2. arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

//        3. “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

//        4. Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        //1-16 of 197 results for "Samsung headphones"
        String  sonucSayisi = sonucYazisi.getText().split(" ")[2];
        System.out.println("Sonuc Sayisi : " +sonucSayisi);


//        5. Ilk urunu tiklayalim
        WebElement ilkelement = driver.findElement(By.xpath("(//h2//a)[1]"));
        ilkelement.click();

//        6. Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfadakiTumBsaliklar = driver.findElements(By.xpath("//h1 | //h2"));

        //Lambda ile yazdiralim
        sayfadakiTumBsaliklar.forEach(t-> System.out.println(t.getText()));

        System.out.println("********************************************");

        //for ile yazdirlim
        for (WebElement w : sayfadakiTumBsaliklar){
            System.out.println(w.getText());
        }


    }



}
