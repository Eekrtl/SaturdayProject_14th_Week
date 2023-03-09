package SaturdayProject;

import UtilityClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Orange extends DriverClass {

    @Test
    void IdTest_1(){


    }

    @Test
    void IdTest_2(){


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
    void IdTest_8() throws AWTException {

        // We use Robot class to upload and download files
        // We can control windows pop ups with Robot class
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait(2);
        Robot robot = new Robot();

        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement login=driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
        wait(2);

        WebElement myInfo=driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[6]"));
        myInfo.click();
        wait(2);

        WebElement profilepic=driver.findElement(By.xpath("//img[@class='employee-image']"));
        profilepic.click();
        wait(2);

        WebElement chooseAFile=driver.findElement(By.xpath("(//img[@alt=\"profile picture\"])[3]"));
        chooseAFile.click();

        StringSelection stringSelection = new StringSelection("C:\\Users\\umtcn\\OneDrive\\Desktop\\sadsadasdsadsadasd.jpg");

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        wait(2);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        wait(2);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWait Wait1= new WebDriverWait(driver,Duration.ofSeconds(30));


        Wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));



        submit.click();

        WebElement redAlert = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        String Actualtext =redAlert.getText();

        String ExpectedText = "Attachment Size Exceeded";

        Assert.assertEquals(Actualtext,ExpectedText);



    }



}
