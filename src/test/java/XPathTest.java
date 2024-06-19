import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XPathTest {
  private WebDriver driver;
  private final String BASE_URL = "http://localhost/playground/tabulka.php";

  @Before
  public void setUp() {

    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
    driver = new FirefoxDriver();
  }

  @Test
  public void test() {
    driver.get(BASE_URL);
    driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[6]"));
  }

  @After
  public void tearDown() {
    //driver.quit();
  }


}

