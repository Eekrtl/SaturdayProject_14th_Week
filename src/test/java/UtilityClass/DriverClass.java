package UtilityClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class DriverClass {
    public static WebDriver driver;
    static {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
//        login();
    }

    public static void quitDriver(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    public static void wait(int second){
        try {
            Thread.sleep(second*1000);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }

    }
//    public static void login(){
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        wait(2);
//
//        WebElement username= driver.findElement(By.name("username"));
//        username.sendKeys("Admin");
//
//        WebElement password= driver.findElement(By.name("password"));
//        password.sendKeys("admin123");
//
//        WebElement login=driver.findElement(By.cssSelector("button[type='submit']"));
//        login.click();
    }
//}

