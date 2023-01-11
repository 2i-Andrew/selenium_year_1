package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        //Visit
//        driver.get("https://delta-dev-designrefresh.bipsolutions.co.uk/delta/");
//
//        //Type Username and Password
//        driver.findElement(By.id("username")).sendKeys("kyle.dearie@admin.bipsolutions.co.uk");
//        driver.findElement(By.id("password")).sendKeys("Password123");
//
//        //Click Sign In
//        driver.findElement(By.name("submit")).click();

        driver.get("https://edgewordstraining.co.uk/webdriver2/docs/cssXPath.html");
        WebElement gripper = driver.findElement(By.cssSelector(".ui-slider-handle"));

        Actions dragDrop = new Actions(driver);
        Action action = dragDrop.moveToElement(gripper)
                .clickAndHold()
                .moveByOffset(100, 0)
                .release()
                .build();

        action.perform();

        //Close and quit
//        driver.close();
    }
}
