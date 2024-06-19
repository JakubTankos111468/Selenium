import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstTest {

  private WebDriver driver;
  private final String BASE_URL = "http://localhost/playground/clickmebaby.php";

  @Before
  public void setUp() {

    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
    driver = new FirefoxDriver();
  }
  @Test
  public void test() {
    driver.get(BASE_URL);
    driver.findElement(By.id("clickMe")).click();

  }
  @After
  public void tearDown() {
    //driver.quit();
  }
}

