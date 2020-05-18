package loginPage;

import base.Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class InvokeChromeTest extends Base {

 @Test

  public void initialize() throws IOException {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
    driver.close();

  }

}
