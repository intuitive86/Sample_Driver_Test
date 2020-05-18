package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {

  public WebDriver driver;
  public Properties prop;

  public WebDriver initializeDriver() throws IOException {
    // Create global property file
    prop = new Properties();
    InputStream fis = getClass().getClassLoader().getResourceAsStream("data.properties");
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
    return driver;
  }
}