package slayttakiTaskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_Maven03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // cookies uyarisini kabul ederek kapatin
        // Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String word = "Google";
        if (actualTitle.contains(word)) {
            System.out.println("Title Test : PASSED");
        }else System.out.println("Title Test : FAILED");
        // Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Nutella", Keys.ENTER);
        // Bulunan sonuc sayisini yazdirin
        String sonucYazizi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String sonucSayisi = sonucYazizi.split(" ")[1];
        // sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisi2 = sonucSayisi.replaceAll("\\.","");
        System.out.println(sonucSayisi2);
        int sonucSayisiSayiOlarak = Integer.parseInt(sonucSayisi2);
        if (sonucSayisiSayiOlarak>10000000) {
            System.out.println("Test : PASSED");
        }else System.out.println("Test : FAILED");
        /*
        String olarak aldigim sonuc sayisini int'e cevirdim( Integer.parseInt(String deger) ) ancak String degerin icinde nokta oldugu icin
        exception atti.Bende replaceAll() methodu ile nokta karakterini silip tekrardan islemi yaptim.
        String bir degeri non-primitiv Integer'a --> Integer.valueOf(String deger) ile cevirebiliyoruz.
         */

        // Sayfayi kapatin
        driver.close();

    }



}
