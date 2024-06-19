import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class KalkulackaTest extends MainTest{

    @Before
    public  void openBaseurl() {
        driver.get(getBASE_URL() + "kalkulacka.php");
    }

    @Test
    public void testSum() {
        checkSum("5", "2","7");
        checkSum("5", "-5","0");
        checkSum("55", "15","70");
    }

    @Test
    public void testDeduct() {
        checkDeduct("8","5","3");
        checkDeduct("10","10","0");
        checkDeduct("100","200","-100");
    }

    @Test
    public void testReset() {
        enterInputs("5","6");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();

        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());
    }

    @Test
    public void testInvalidInputs() {
        enterInputs("blud1","blud2");
        driver.findElement(By.id("count")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
                .getAttribute("class").contains("has-error"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
                .getAttribute("class").contains("has-error"));
    }

    private void checkSum(String firstInput, String secondInput, String expected) {
        enterInputs(firstInput,secondInput);
        driver.findElement(By.id("count")).click();
        Assert.assertEquals(expected, driver.findElement(By.id("result")).getText());
    }

    private void checkDeduct(String firstInput, String secondInput, String expected) {
        enterInputs(firstInput,secondInput);
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals(expected, driver.findElement(By.id("result")).getText());
    }

    private void enterInputs(String firstInput, String secondInput) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).sendKeys(secondInput);
    }
}
