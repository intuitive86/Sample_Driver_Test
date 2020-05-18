package loginPage;

import java.io.IOException;
import org.testng.annotations.Test;
import resources.Base;

public class InvokeChromeTest extends Base {

 @Test

  public void initialize() throws IOException {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
    driver.close();

  }

}
