package techproed.day11_iframe_WindovHandle;

import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {

    /*
             Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline frame yani IFRAME denir.
        Bir sayfada iframe varsa iframe içindeki webelementi handle edebilmek için switchTo() methoduyla iframe'e
        geçiş yapmamız gerekir. Eğer geçiş yapmazsak nosuchelementexception alırız.
        Alert'ten farkı alert çıktığında hiçbir webelementi locate edemeyiz. Iframe olsada locate ederiz fakat
    handle edemeyiz
     */

    @Test
    public void iframe() {

        //https://testcenter.techproeducation.com/index.php?page=iframe


        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim


        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim


        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz

    }
}
