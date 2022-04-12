package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hook {

    static WebDriver driver;

    static WebDriverManager wdm;

    @Before
    public static void setUp() {
        System.setProperty("wdm.defaultBrowser", "chrome");
        wdm = WebDriverManager.getInstance().proxy("");
        driver = wdm.create();
    }

    @After
    public void tearDown() {
        wdm.quit();
        System.clearProperty("wdm.defaultBrowser");
    }
}
