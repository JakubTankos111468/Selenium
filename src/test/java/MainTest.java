import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainTest {
    private final String BASE_URL = "http://localhost/playground/";
    public WebDriver driver;

    public String getBASE_URL() {
        return BASE_URL;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
