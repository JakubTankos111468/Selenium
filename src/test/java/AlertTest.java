import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/redalert.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        driver.findElement(By.id("alert1")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert2")).click();
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals("Second alert!", alert2.getText());
        alert2.dismiss();
        Assert.assertEquals("Negative",driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert3")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Yuri");

        alert3.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Yuri"));

    }
    @After
    public void tearDown() {
    }
}
