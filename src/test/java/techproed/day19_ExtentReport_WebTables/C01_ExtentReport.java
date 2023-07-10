package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    /*
    EXTENTREPORT;
    1-) ExtentReport kullanabilmek icin oncelikle mvn adresinden 4.0.9 versiyon numarali dependency'i pom.xml dosyamiza ekleriz
    2-)ExtentReports clasindan class seviyesinde obje olustururuz
    3-)ExtentHtmlReporter clasindan class seviyesinde obje olustururuz
    4-)ExtentTest clasindan class seviyesinde obje olustururuz
     */

    ExtentReports extentReports; // --> Raporlamayi baslatmak icin kullanilan clas
    ExtentHtmlReporter extentHtmlReporter; // --> Raporu HTML formatinda duzenler
    ExtentTest extentTest; // --> Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz

    @Test
    public void test01() {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter); //  --> HTML formatinda  raporlamayi baslatacak

        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Yucel");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        //amazon sayfasina gidelim







    }
}
