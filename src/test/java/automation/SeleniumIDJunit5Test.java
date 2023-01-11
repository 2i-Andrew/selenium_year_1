package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIDJunit5Test {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
//    void tearDown(){
//        driver.quit();
//    }
    @Test
    void selIDETest(){
        driver.get("http://www.edgewordstraining.co.uk/webdriver2/");
        driver.manage().window().setSize(new Dimension(1325, 646));
        driver.findElement(By.linkText("Login To Restricted Area")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("edgewords");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("edgewords123");
        driver.findElement(By.linkText("Submit")).click();
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Add A Record To the Database"));
        driver.findElement(By.cssSelector(".last span")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("h1")).click();
        }
}

