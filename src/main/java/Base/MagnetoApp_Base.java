package Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Test
public class MagnetoApp_Base
{
    protected WebDriver driver;
    @BeforeSuite
   public void LauchBrowserandApp()
   {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.get("https://magento.softwaretestingboard.com/customer/account/");
   }
}
