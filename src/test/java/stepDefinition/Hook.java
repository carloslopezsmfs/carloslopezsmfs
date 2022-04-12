package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class Hook {

    static WebDriver driver;

    static WebDriverManager wdm;

    final Logger log = getLogger(lookup().lookupClass());

    @Before
    public static void setUp() {
        System.setProperty("wdm.defaultBrowser", "chrome");
        wdm = WebDriverManager.chromedriver().proxy("");
        driver = wdm.create();
    }

    @After
    public void tearDown() {
        wdm.quit();
        System.clearProperty("wdm.defaultBrowser");
    }

    @Given("I log in")
    public void iLogIn() throws InterruptedException {
        String sutUrl = "https://www.bing.com/";
        driver.get(sutUrl);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", sutUrl, title);
        WebElement element = driver.findElement(By.id("sb_form_q"));
        element.sendKeys("test");
        WebElement element1 = driver.findElement(By.id("search_icon"));
        element1.click();
        String title1 = driver.getTitle();
        Assert.assertNotEquals(title, title1);
    }
}
