package techproed.day15_FilesExists;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {



    @Test
    public void test01() {
        String dosyaYolu = "C:\\Users\\kalem\\OneDrive\\Masaüstü\\sen.txt";
        boolean dosyaVarMi = Files.exists(Paths.get(dosyaYolu));
        System.out.println("dosyaVarMi = " + dosyaVarMi);
        Assert.assertTrue(dosyaVarMi);
    }

    @Test
    public void test02() {
    String okbsFilePath = "C:\\Users\\kalem\\OneDrive\\Masaüstü\\IOKBS_2023.pdf";
    boolean okbsFileisExist = Files.exists(Paths.get(okbsFilePath));
        System.out.println("okbsFileisExist = " + okbsFileisExist);
        Assert.assertTrue(okbsFileisExist);
    }

    @Test
    public void test03() throws InterruptedException {

        String farkliYol = "";
        String isletimSistemininAdi = System.getProperty("os.name");
        System.out.println("isletimSistemininAdi = " + isletimSistemininAdi);
        String bilgsyarmdakiKullnciYolu = System.getProperty("user.home");
        System.out.println("bilgsyarmdakiKullnciYolu = " + bilgsyarmdakiKullnciYolu);

        if (isletimSistemininAdi.contains("Win")) {
           farkliYol = bilgsyarmdakiKullnciYolu;
        } else if (isletimSistemininAdi.contains("mac")) {

            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }

        String ortakYol = "\\OneDrive\\Masaüstü\\sen.txt";
        String dosyaYolu = farkliYol.concat(ortakYol);
        System.out.println("dosyaYolu = " + dosyaYolu);
        boolean senFileIsExtist = Files.exists(Paths.get(dosyaYolu));
        System.out.println("senFileIsExtist = " + senFileIsExtist);
       // Assert.assertTrue(senFileIsExtist);
        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }

        Assert.assertFalse(senFileIsExtist);
        Thread.sleep(3000);

        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(senFileIsExtist);

        /*
            Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
        yukardaki delete işlemini kullanabiliriz
         */
    }

    @Test
    public void test04() {

        /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */

        String dosyaYolu = "C:\\Users\\kalem\\OneDrive\\Masaüstü\\ben.txt";
        File file = new File(dosyaYolu);
        System.out.println("file.exists() = " + file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}












