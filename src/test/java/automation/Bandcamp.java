package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bandcamp {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://bandcamp.com");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void canVisitHomePage(){
        String subHead = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertTrue(subHead.contains("Discover amazing new music and directly support the artists who make it."));
    }

    @Test
    void canVisitAboutUsPage(){
        driver.findElement(By.cssSelector("a:contains('About Us')")).click();
        String heading = driver.findElement(By.tagName("h1")).getText();
        Assertions.assertTrue(heading.contains("About us"));
    }



}
