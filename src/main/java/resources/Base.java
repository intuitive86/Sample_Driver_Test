package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

  public WebDriver driver;
  public Properties dataProperties;

  public WebDriver initializeDriver() throws IOException {
    // Create global property file
    dataProperties = new Properties();
    InputStream dataPropertiesInputStream = null;
    try{
      InputStream = getClass().getClassLoader().getResourceAsStream("data.properties");
      dataProperties.load(dataPropertiesInputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String browserName = dataProperties.getProperty("browser");
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