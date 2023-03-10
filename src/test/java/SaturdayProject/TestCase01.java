package SaturdayProject;

import UtilityClass._02_DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase01 extends _02_DriverClass {

    @Test
    void TestCase_TC_MI_01() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Admin");


        WebElement password = driver.findElement(By.xpath("//input[@type= 'password']"));
        password.sendKeys("admin123");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class= 'oxd-main-menu-item']")));
        WebElement AdminButton = driver.findElement(By.xpath("//a[@class= 'oxd-main-menu-item']"));
        Assert.assertTrue(AdminButton.isEnabled());

    }

    }

