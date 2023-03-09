package SaturdayProject;

import UtilityClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class OrangeTestCase7 extends DriverClass {

    @Test
    public void testInvalidPictureUpload() throws AWTException {
        // Create instance of ChromeDriver
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\bootcamp\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Enter username and password and click login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));

        WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys("Admin");
        WebElement Password  = driver.findElement(By.xpath("//input[@name='password']"));
        Password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='My Info']")));
        WebElement myInfo = driver.findElement(By.xpath("//*[text()='My Info']"));
        myInfo.click();



        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//img[@class='employee-image']"))));
        WebElement employeeImage = driver.findElement(By.xpath("//img[@class='employee-image']"));
        employeeImage.click();

        Robot robot = new Robot();
        // Click on the photograph to upload a picture
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button/i"))));
        WebElement plusButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button/i"));
        plusButton.click();


        // Set the file path of the invalid picture to upload
        StringSelection stringSelection = new StringSelection("C:\\Program Files (x86)\\Audacity\\audacity.exe\\");

        // Copy the file path to the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Use Robot class to paste the file path and press "Enter"

        robot.delay(1000); // Wait for the file chooser dialog to appear
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000); // Wait for the file path to be pasted
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Click on the "Upload" button
        // WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement btnSave = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnSave")));
        // btnSave.click();

        // WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
        // WebElement btnSave = wait.pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnSave")));
        // btnSave.click();



        // Verify that the error message is displayed
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"))));
        String errorMsg = driver.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")).getText();
        Assert.assertEquals(errorMsg, "Attachment Size Exceeded");

        // Close the browser
        driver.quit();
    }
}