package SaturdayProject;

import UtilityClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase04 extends DriverClass {

    @Test
    void firstNameUpdate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Info']")));

        WebElement myInfo = driver.findElement(By.xpath("//span[text()='My Info']"));
        myInfo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
        WebElement firstName1 = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName1.click();

        Actions actions = new Actions(driver);
        Action clearFirstName = actions.moveToElement(firstName1).doubleClick().click().sendKeys(Keys.BACK_SPACE).build();
        clearFirstName.perform();

        firstName1.sendKeys("TJ");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(3000);
        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        saveButton.click();

        WebElement actualName = driver.findElement(By.cssSelector("h6.oxd-text.oxd-text--h6.--strong"));
        Assert.assertTrue(actualName.getText().contains("TJ"),"Failed to get the name.");

    }
}


