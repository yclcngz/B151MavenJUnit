package techproed.day10_TestBase_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_Allert extends TestBase {

    /*
            Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klik
         yapıp locate alamıyorsak, bu bir js Alert'tür.
            js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
         driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
         accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız.
         accept() --> onaylar
         dismiss() --> iptal eder
         */



    @Test
    public void acceptAlert() {

        //Bir metod olusturun:acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() {
    }

    @Test
    public void test03() {


    }
}
