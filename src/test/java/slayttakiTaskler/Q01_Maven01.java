package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q01_Maven01 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Class Work Amazon Search Test
        //1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2. arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        //3. “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //4. Bulunan sonuc sayisini yazdiralim
        String sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(sonucYazisi);  // 1-16 of 201 results for "Samsung headphones"
        String sonucSayisi = sonucYazisi.split(" ")[2];
        System.out.println("Sonuc sayisi : "+sonucSayisi);
        //5. Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")).click();
        //6. Sayfadaki tum basliklari yazdiralim
        List<WebElement> tumBasliklar = driver.findElements(By.xpath("//h1 | h2"));
        tumBasliklar.forEach(t-> System.out.println(t.getText()));
        System.out.println("**********************");

        for (WebElement w : tumBasliklar){
            System.out.println(w.getText());
        }




    }

}
