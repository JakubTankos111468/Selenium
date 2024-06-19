import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class TitleTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/vybersi.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() throws InterruptedException{
        driver.get(BASE_URL);
        List<WebElement> pages = driver.findElements(By.xpath("//nav/ul/li/a"));
        List<String> pageUrls = new ArrayList<>();
        for (WebElement page :pages){
            pageUrls.add(page.getAttribute("href"));
        }
        for(String pageUrl : pageUrls) {
            driver.get(pageUrl);
            String expectedTitle = pageUrl.substring(pageUrl.lastIndexOf("/"),pageUrl.indexOf(".php"));
            Assert.assertTrue(driver.getTitle().contains(expectedTitle.substring(0,1).toUpperCase() + expectedTitle.substring(1)));
        }

    }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
