import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/cucumber.json",
        "rerun:target/cucumber-reports/rerun.txt",
        "junit:target/cucumber-reports/cucumber-results.xml"},
        features = "src/test/resources")
public class RunMainTest {

}