package sistemadetestes.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
   protected static WebDriver driver;

   public BaseTest() {
   }

   @BeforeClass
   public static void iniciarDriver() {
      System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
   }

   @AfterClass
   public static void encerrarDriver() {
      if (driver != null) {
         driver.quit();
      }

   }
}
