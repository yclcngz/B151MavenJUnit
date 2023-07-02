package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
       driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String b10 = "C:\\Users\\kalem\\Downloads\\b10 all test cases, code.docx";
        boolean b10IsDowlond = Files.exists(Paths.get(b10));
        System.out.println("b10IsDowlond = " + b10IsDowlond);
        Assert.assertTrue(b10IsDowlond);
    }
}
