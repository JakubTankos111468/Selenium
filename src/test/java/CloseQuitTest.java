import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseQuitTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/zenaalebomuz.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    @After
    public void tearDown() {
        driver.close();
        //driver.quit();
    }
}
