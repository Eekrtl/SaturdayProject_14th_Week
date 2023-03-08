package SaturdayProject;

import UtilityClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Orange extends DriverClass {

    @Test
    void IdTest_1(){


    }

    @Test
    void IdTest_2(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));

        WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys("Admin");


        WebElement Password= driver.findElement(By.xpath("//input[@name='password']"));

        Password.sendKeys("abc123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));


        WebElement errormessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String ActualText = errormessage.getText();
        String ExpectedText = "Invalid credentilas";

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(errormessage.isDisplayed(),"The message is displayed");

        System.out.println(ActualText);

        Assert.assertEquals(ActualText,ExpectedText);


        softAssert.assertAll();




    }

    @Test
    void IdTest_3(){


    }

    @Test
    void IdTest_4(){


    }

    @Test
    void IdTest_5(){



    }

    @Test
    void IdTest_6(){


    }

    @Test
    void IdTest_7(){


    }

    @Test
    void IdTest_8(){


    }



}
