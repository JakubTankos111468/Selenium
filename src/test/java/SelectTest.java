import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {
        private WebDriver driver;
        private final String BASE_URL = "http://localhost/playground/vybersi.php";

        @Before
        public void setUp() {

            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        @Test
        public void test() {
            driver.get(BASE_URL);
            new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
            System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
            Assert.assertTrue(driver.findElement(By.xpath("//div/h3")).getText().contains("Pikachu"));
        }
        @After
        public void tearDown() {
            //driver.quit();
        }


    }

