package SaturdayProject;

import UtilityClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

/**As a user I should be able to upload photograph on JPG format to the website so that I can be able to change my profile picture.
 Test Steps
 1- Click on the photograph displayed at the top left corner of the page

 2- Click on "Choose a file" button

 3- Choose a image file of type "JPG" that is less than 1 MB

 4- Click on upload

 Test Data
 Name of the image
 Location-path on the machine
 Expected Result
 The "Photograph screen" will be displayed
 You will be able to browse your local machine for images
 The file name is selected in the "Choose a file" box
 The file gets uploaded and the older image is replaced*/
public class TestCase05 extends DriverClass {

    @Test
    void uploadPhotographTest() throws AWTException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")));
        //<a class="oxd-main-menu-item" href="/web/index.php/pim/viewMyDetails" data-v-4de0f1ff="">
        WebElement myInfoButton= driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']"));
        myInfoButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='orangehrm-edit-employee-image']")));
        //<div class="orangehrm-edit-employee-image" data-v-09a26ef1=""><img alt="profile picture" class="employee-image" src="/web/index.php/pim/viewPhoto/empNumber/7" data-v-09a26ef1=""></div>
        WebElement imageButton= driver.findElement(By.cssSelector("div[class='orangehrm-edit-employee-image']"));
        imageButton.click();
        //<button class="oxd-icon-button employee-image-action" type="button" role="none" data-v-654f8522="" data-v-449ec876=""><i class="oxd-icon bi-plus" data-v-013b3fcc="" data-v-654f8522=""></i></button>
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='oxd-icon-button employee-image-action']")));
        WebElement uploadImageButton= driver.findElement(By.cssSelector("button[class='oxd-icon-button employee-image-action']"));
        uploadImageButton.click();
        wait(2);
        //C:\Users\naime\OneDrive\Desktop\ppofThesite.jpg
        Robot robot=new Robot();
        StringSelection stringSelection = new StringSelection("C:\\Users\\naime\\OneDrive\\Desktop\\ppofThesite.jpg");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        wait(2);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        //<button type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space" data-v-7e88b27e="" data-v-6b5ff2de=""><!----> Save <!----></button>
        WebElement submitButton=driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/web/index.php/dashboard/index']")));
        //<a class="oxd-main-menu-item" href="/web/index.php/dashboard/index" data-v-4de0f1ff="">
        WebElement dashBoardButton=driver.findElement(By.cssSelector("a[href='/web/index.php/dashboard/index']"));
        dashBoardButton.click();



    }
}
