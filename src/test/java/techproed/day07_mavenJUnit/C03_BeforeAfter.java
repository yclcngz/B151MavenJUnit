package techproed.day07_mavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {

     WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        

    }

    @Test
    public void techproedTest() {
        driver.get("https://www.techproeducation.com");
        
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan once bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her classtan sonra bir kez calisir");
    }
}
