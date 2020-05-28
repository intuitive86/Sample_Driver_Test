package credentials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileCredentials {

  WebDriver driver;


  public ProfileCredentials(WebDriver driver) {
    this.driver = driver;
  }

  private By authorize = By.xpath("//button[@class='btn authorize unlocked']");
  private By apikey = By.xpath("//div[@class='wrapper']//section//input");
  private By authorizecred = By.xpath("//button[@class='btn modal-btn auth authorize button']");
  private By closeauth = By.xpath("//button[@class='btn modal-btn auth btn-done button']");

  public WebElement getAuthorize() {
    return driver.findElement(authorize);
  }
  public WebElement getApiKey() {
    return driver.findElement(apikey);
  }
  public WebElement getAuthCred() {
    return driver.findElement(authorizecred);
  }
  public WebElement getCloseAuth() {
    return driver.findElement(closeauth);
  }
}
}
