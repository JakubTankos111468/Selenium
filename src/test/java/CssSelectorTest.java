import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelectorTest {
  private WebDriver driver;
  private final String BASE_URL = "http://localhost/playground/kalkulacka.php";

  @Before
  public void setUp() {

    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
    driver = new FirefoxDriver();
  }
  @Test
  public void test() {
    driver.get(BASE_URL);
    driver.findElement(By.cssSelector("button#count")).click();
    driver.findElement(By.cssSelector("button.btn-success")).click();
    driver.findElement(By.cssSelector("div.container button")).click(); //ak je to potomok, ze je pod nim v strukture
    driver.findElement(By.cssSelector("div.row>button")).click(); //ak je to sused, ze je na rovnakej urovni v strukture



  }
  @After
  public void tearDown() {
    
  }


}

