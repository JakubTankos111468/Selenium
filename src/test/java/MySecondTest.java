import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySecondTest {
  private WebDriver driver;
  private final String BASE_URL = "http://localhost/playground/registracia.php";

  @Before
  public void setUp() {

    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
    driver = new FirefoxDriver();
  }
  @Test
  public void test() {
    driver.get(BASE_URL);
    //driver.findElement(By.name("email")).sendKeys("DusanCinkota@gmail.com");
    //driver.findElement(By.className("form-control")).sendKeys("DusanCinkota@gmail.com");
    //driver.findElement(By.tagName("input")).sendKeys("DusanCinkota@gmail.com");
    /*driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("DusanCinkota@gmail.com");
    driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("Dušan");
    driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).sendKeys("Cinkota");*/

    driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("DusanCinkota@gmail.com");
    driver.findElement(By.xpath("//form/div[2]/input")).sendKeys("Dusan");
    driver.findElement(By.xpath("//form/div[3]/input")).sendKeys("Cinkota");


  }
  @After
  public void tearDown() {
    //driver.quit();
  }


}

