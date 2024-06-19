import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RegistraciaTest extends MainTest {
    private final String validEmail = "DusanCinkota@gmail.com";
    private final String validName = "Dusan";
    private final String validSurname = "Cinkota";

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "registracia.php");
    }

    @Test
    public void testMissingAllInputs() {
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testMissingPasword() {
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testMismatchedPassword() {
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("prveHeslo");
        driver.findElement(By.name("password-repeat")).sendKeys("druheHeslo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());
    }

    @Test
    public void testMissingRobotCheckBox() {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("prveHeslo");
        driver.findElement(By.name("password-repeat")).sendKeys("prveHeslo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());
    }


    @Test
    public void testRobotCheckBox() {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("prveHeslo");
        driver.findElement(By.name("password-repeat")).sendKeys("prveHeslo");

        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).isDisplayed());
    }

    @Test
    public void testInputErrorBorder() {
        String expectedClass = "has-error";
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));
        for (WebElement formDiv : formDivs) {
            Assert.assertTrue(formDiv.getAttribute("class").contains(expectedClass));
        }

        Assert.assertTrue(driver.findElement(By.xpath("//div[label[input[@id = 'checkbox']]]"))
                .getAttribute("class")
                .contains(expectedClass));
    }
}
