package UtilityClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_DriverClass {
    public static WebDriver driver;
    static {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
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
}
