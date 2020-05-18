package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

  public WebDriver driver;
  public Properties prop;

  public WebDriver initializeDriver() throws IOException {
    // Create global property file
    prop = new Properties();
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
        "src/main/java/resources/data.properties");
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
    return driver();
  }
}