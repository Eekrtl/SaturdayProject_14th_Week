package SaturdayProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase3 {


    /** Validate after login succesfully user login-information display check Personal information Page
     * In the login Panel, enter the username
     * Enter the Password for the ESS-User account in the password field
     * Click "Login" button
     * Check the fields on the "Personal information Page"
     * The user is logged in successfully and the personal information page is displayed
     * Check if the following fields are disabled for entry in Personal Details:
     * ● Employee ID
     * ● SSN No
     * ● SIN No
     * ● Driver License No
     * ● Date of Birth
     */

    public WebDriver driver;
    public static WebDriverWait wait;



    @Test
    void testCaseTC_MI_MIM_01(){

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("dominic");
        WebElement password = driver.findElement(By.xpath("//div[@class='oxd-form-row']//div//input[@name='password']"));
        password.sendKeys("Dominic123!");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-userdropdown-name']")));

        WebElement personalInformation = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        Assert.assertTrue(personalInformation.isDisplayed());

        WebElement myInfo = driver.findElement(By.xpath("//span[text()='My Info']"));
        myInfo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-date-input']//input[@placeholder='yyyy-mm-dd']")));

        WebElement employeeId = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"));
        WebElement driverLicence = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[5]"));
        WebElement ssnNumber = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[7]"));
        WebElement sinNumber = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[8]"));
        WebElement dateOfBirth = driver.findElement(By.xpath("(//div[@class='oxd-date-input']//input[@placeholder='yyyy-mm-dd'])[2]"));

        Assert.assertFalse(dateOfBirth.isEnabled());
        Assert.assertFalse(employeeId.isEnabled());
        Assert.assertFalse(driverLicence.isEnabled());
        Assert.assertFalse(ssnNumber.isEnabled());
        Assert.assertFalse(ssnNumber.isEnabled());

    }
}
