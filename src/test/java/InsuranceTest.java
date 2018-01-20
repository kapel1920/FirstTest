import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;





public class InsuranceTest {
    private WebDriver driver;
    private String baseUrl;

   @Before
   public void setUp() throws Exception
   {
     System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
     driver = new ChromeDriver();
     baseUrl = "http://www.sberbank.ru/ru/person/";
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.manage().window().maximize();
   }

   @Test
   public void testInsurance() throws Exception {
       driver.get(baseUrl + "/");
       driver.findElement(By.xpath("//ol[contains(@class,'rgs-menu')]/li/*[contains(text(),'Страхование')]")).click();
       driver.findElement(By.xpath("//*[contains(text(),'ДМС')]")).click();


    }

}
