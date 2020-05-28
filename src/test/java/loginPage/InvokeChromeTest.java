package loginPage;

import credentials.ProfileCredentials;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import resources.Base;

public class InvokeChromeTest extends Base {

  @Test

  public void authorize() {
    driver.get(dataProperties.getProperty("url"));
    ProfileCredentials p = new ProfileCredentials(driver);
    p.getAuthorize().click();
    p.getApiKey().sendKeys("testKey");
    p.getAuthCred().click();
    p.getCloseAuth().click();

  }

  @AfterTest
  public void teardown() {

    driver.close();

  }
}
