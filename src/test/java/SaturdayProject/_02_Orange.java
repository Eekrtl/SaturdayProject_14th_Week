package SaturdayProject;

import UtilityClass._02_DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class _02_Orange extends _02_DriverClass {


    @Test
    void IdTest_2(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));

        WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys("Admin123");


        WebElement Password= driver.findElement(By.xpath("//input[@name='password']"));

        Password.sendKeys("abc123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));


        WebElement errormessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String ActualText = errormessage.getText();
        String ExpectedText = "Invalid credentilas";



        System.out.println(ActualText);

        Assert.assertEquals(ActualText,ExpectedText);




    }
}
