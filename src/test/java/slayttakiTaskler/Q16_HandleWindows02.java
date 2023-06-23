package slayttakiTaskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class Q16_HandleWindows02 extends TestBase {
    @Test
    public void test01() {

        // 1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle()); //Techpro Education | Online It Courses & Bootcamps
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        // 2. Yeni bir pencerede Amazon sayfasini acip titleinin "" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle()); //Amazon.com. Spend less. Smile more.
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        bekle(5);

        // 3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        System.out.println(driver.getTitle()); //LinkedIn: Oturum Açın veya Üye Olun
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        bekle(5);
    }




}
