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
import java.util.List;

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

       //1.Method:
       //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year =  driver.findElement(By.xpath("(//select)[2]"));
        WebElement month =  driver.findElement(By.xpath("(//select)[3]"));
        WebElement day = driver.findElement(By.xpath("(//select)[4]"));
       //b. Select objesi olustur
       //c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        Select select1 = new Select(year);
        select1.selectByIndex(5);

        Select select2 = new Select(month);
        select2.selectByValue("6");

        Select select3 = new Select(day);
        select3.selectByVisibleText("14");



    }


    @Test
    public void test02() {

        //2.Method:
        //a. Tüm eyalet isimlerini yazdıralım
        //1.WAY:
        WebElement state = driver.findElement(By.xpath("(//select)[5]"));
        Select select4 = new Select(state);
        List<WebElement> states =  select4.getOptions();
        int stateNo=1;
        for (WebElement w : states){
            if (w.getText().equals("Select a State")){
                continue;
            }else  System.out.println(stateNo +". stateName : "+w.getText());
            stateNo++;
         }
        System.out.println("///////////////////////////////////////////////////////");

        //2.WAY:
        // WebElement state2 =  driver.findElement(By.xpath("(//select)[5]"));
        // Select select5 = new Select(state2);
        //select5.getOptions().forEach(t-> System.out.println(t.getText()));

        //3.WAY:
        // List<WebElement> states2 = driver.findElements(By.xpath("(//select)[5]"));
        //states2.forEach(t-> System.out.println(t.getText()));


    }

    @Test
    public void test03() {

        //3.Method:
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler =  driver.findElement(By.xpath("(//select)[5]"));
        Select select6 = new Select(eyaletler);
        String seciliOlanSecenek = select6.getFirstSelectedOption().getText();
        String excepted = "Select a State";
        Assert.assertEquals(seciliOlanSecenek,excepted);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

