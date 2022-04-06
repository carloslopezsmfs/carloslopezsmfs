package stepDefinition;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestPage {

    public void test() {
        WebElement username = Hook.driver.findElement(By.name("username"));
        username.sendKeys("audrey_400313");
        WebElement password = Hook.driver.findElement(By.id("password"));
        password.sendKeys("P@ssword1");
        WebElement submitBtn = Hook.driver.findElement(By.xpath("/html/body/form/article/section[2]/section/div[1]/div/input"));
        submitBtn.click();
        Assert.assertTrue(Hook.driver.findElement(By.id("menuTypeAheadField")).isDisplayed());
    }

    @Given("I log in")
    public void iLogIn() {
        test();
    }
}
