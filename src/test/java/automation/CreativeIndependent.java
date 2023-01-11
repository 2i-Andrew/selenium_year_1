package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreativeIndependent {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void canVisitPage(){
        driver.get("https://thecreativeindependent.com");
        String titleText = driver.findElement(By.id("tci-title")).getText();
        Assertions.assertTrue(titleText.contains("The Creative Independent"));
    }

    @Test
    void canVisitEssaysPage(){
        driver.get("https://thecreativeindependent.com");
        driver.findElement(By.linkText("Essays")).click();
        String elementClass = driver.findElement(By.tagName("html")).getAttribute("class");
        Assertions.assertEquals(elementClass, "dark");
    }

}
