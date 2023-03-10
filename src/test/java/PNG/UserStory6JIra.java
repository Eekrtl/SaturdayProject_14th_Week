package PNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UserStory6JIra extends Utility {
    @Test
    void testCaseTC_MI_P_02() throws AWTException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        hardWait(3);

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement logging = driver.findElement(By.xpath("//button[@type='submit']"));
        logging.click();
        WebElement myInfo = driver.findElement(By.xpath("//*[text()='My Info']"));
        myInfo.click();
        hardWait(2);

        WebElement img = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[2]/div/img"));
        img.click();

        hardWait(300);

        Robot robot = new Robot();
        WebElement plus = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button/i"));
        plus.click();

        robot.setAutoDelay(2000);

        //StringSelection stringSelection1 = new StringSelection("C:\\Users\\HP\\Pictures\\png.png");
        StringSelection stringSelection = new StringSelection("C:\\Users\\HP\\IdeaProjects\\SaturdayProject_14th_Week\\src\\test\\java\\PNG\\png.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        hardWait(2);

        WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
        save.click();

        hardWait(3);

        WebElement greenMessage = driver.findElement(By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']/p"));

        System.out.println(greenMessage.getText());

        Assert.assertTrue(greenMessage.isDisplayed(), "the photo has been updated successfully ");

    }
}
