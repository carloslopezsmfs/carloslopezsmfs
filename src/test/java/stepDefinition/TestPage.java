package stepDefinition;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import static stepDefinition.Hook.driver;

public class TestPage {

    private final String menuFrameOmnex2 = "menu";
    final Logger log = getLogger(lookup().lookupClass());

    public void test() throws InterruptedException {
        /*String url = Hook.driver.getCurrentUrl();
        WebElement inputElement = Hook.driver.findElement(By.name("q"));
        inputElement.sendKeys("test");
        WebElement submitBtn = Hook.driver.findElement(By.name("btnK"));
        submitBtn.click();
        String urlNew = Hook.driver.getCurrentUrl();
        Assert.assertNotEquals(url, urlNew);*/
        /*WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("audrey_400313");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("P@ssword1");
        WebElement submitBtn = driver.findElement(By.xpath("/html/body/form/article/section[2]/section/div[1]/div/input"));
        submitBtn.click();
        Thread.sleep(1000);
        goToMenu();
        Assert.assertTrue(driver.findElement(By.id("menu_whoAmI_myUserSettings")).isDisplayed());*/
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

    private void changeFrame(String frameName) {
        // Get the default content
        driver.switchTo().defaultContent();
        // set the FRAME with the Menu
        driver.switchTo().frame(frameName);
    }

    public void goToMenu() {
        changeFrame(menuFrameOmnex2);
    }

    @Given("I log in")
    public void iLogIn() throws InterruptedException {
        test();
    }
}
