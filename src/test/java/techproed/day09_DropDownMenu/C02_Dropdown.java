package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Dropdown {

    /*
    DROPDOWN --> Altbaşlıkların olduğu açılır menü listesidir.
    Dropdown'u handle(outomate) etmek için
        1-Dropdown menüyü ilk olarak locate ederiz
        2-Select objesi oluştururuz
        3-Select objesinin ddm webelementinin içeriğine ve seçeneklerine erişim sağlaması için
        SELECT sınıfına argüman olarak locate ettiğimiz webelementi koyarız.
        SYNTAX:
                Select select = new Select(ddm webelementi)
        4-Select class'ı, sadece <select> tag'i ile oluşturulmuş dropdown menülere uygulanabilir.
        5-select objesi ddm'yü handle edebilmek için 3 method kullanır
            -selectByVisibleText() -> Ddm deki elemente görünür metin ile ulaşmak için kullanılır.
            -selectByIndex() -> Index ile ulaşmak için kullanılır(Index 0(sıfır)'dan başlar)
            -selectByValue() -> Elementin değeri ile ulaşmak için kullanılır(option tag'larındaki değer(value) ile)
        6-getOptions() -> Locate ettiğimiz ddm'deki tüm seçenekleri bize verir.(List'e atıp loop ile yazdırabiliriz)
        7-getFirstSelectedOption() -> Ddm'deki seçili kalan seçeniği bize verir. Birden fazla seçenek seçildiyse,
        bu seçilenlerin ilkini verir.
        8-Ddm'ye sendKeys() methodu ile de ddm menudeki seçeneklerden birini kullanarak gönderebiliriz
     */

     /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

     */


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {



    }


    @Test
    public void test02() {


    }

    @Test
    public void test03() {



    }
}

