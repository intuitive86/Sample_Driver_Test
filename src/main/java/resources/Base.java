package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

  public WebDriver driver;
  public Properties prop;

  public WebDriver initializeDriver() throws IOException {
    // Create global property file
    prop = new Properties();
    FileInputStream fis = (FileInputStream) getClass().getClassLoader().getResourceAsStream("data.properties");
    prop.load(fis);
    String browserName = prop.getProperty("browser");
    System.out.println(browserName);

    if (browserName.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browserName.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }
}