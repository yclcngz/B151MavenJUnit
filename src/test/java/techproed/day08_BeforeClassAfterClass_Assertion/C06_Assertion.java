package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {


    /*
    Assertionlarda eşitlik için expected,actual olarak kullanılır
     */

    @Test
    public void test01() {

        Assert.assertEquals(2,2);
        System.out.println("Q02_Maven02 basarili bir sekilde calisti");

    }

    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("Q02_Maven02 basarili bir sekilde calisti");
    }

    @Test
    public void test03() {

        Assert.assertNotEquals(5,6);
        System.out.println("Q02_Maven02 basarili bir sekilde calisti");

    }

    @Test
    public void test04() {
       String actualName = "erol";
       String exceptedName = "Erol";

       System.out.println("Q02_Maven02 basarili bir sekilde calisti");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        Assert.assertEquals(exceptedName,actualName);
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
    }

    @Test
    public void test05() {

        int yas = 50;
        int emeklilikYasi = 65;
        Assert.assertTrue(emeklilikYasi<yas);
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
    }

    @Test
    public void test06() {
        int yas = 50;
        int emeklilikYasi = 65;
        Assert.assertTrue(emeklilikYasi>yas);
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");

    }

    @Test
    public void test07() {

        int yas = 50;
        int emeklilikYasi = 65;
        Assert.assertFalse(emeklilikYasi<yas);
        System.out.println("Q02_Maven02 başarılı bir şekilde çalıştı");
    }
}
