package techproed.day13_cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
       driver.get("https://www.amazon.com");

        //2-tum cookie’leri listeleyin
        /*
        Cookie'leri listemek istersek
                driver.manage().getCookies() methoduyla bir Set yada ArrayList'e atarak listeleyebiliriz
         */
        //driver.manage().getCookies().forEach(System.out::println); --> Lambda ile
        System.out.println("**********************");

        int sayac = 1;
        Set<Cookie> cookieSet = driver.manage().getCookies();
        for (Cookie w : cookieSet){

            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". cookieName : "+w.getName()); // -->Sadece cookie'lerin isimlerini aliriz
            System.out.println(sayac+". cookieValue : "+w.getValue()); // -->Sadece cookie'lerin degerlerini aliriz
            sayac++;
        }




        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Sayfadaki cookie sayisi : "+driver.manage().getCookies().size());
        Assert.assertTrue(cookieSet.size()>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Assert.assertEquals(driver.manage().getCookieNamed("i18n-prefs").getValue(),"USD");

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        System.out.println("**********************");
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test\
        cookieSet = driver.manage().getCookies();
        for (Cookie w : cookieSet){
            System.out.println(w);
        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        int beforeDeleteSize = cookieSet.size();
        System.out.println("beforeDeleteSize = " + beforeDeleteSize);

        cookieSet = driver.manage().getCookies();
        int afterDeleteSize = cookieSet.size();
        System.out.println("afterDeleteSize = " + afterDeleteSize);

        Assert.assertEquals(1,beforeDeleteSize-afterDeleteSize);

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
