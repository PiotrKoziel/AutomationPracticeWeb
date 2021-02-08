import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/scenarios/",
        monochrome = true,
        tags = {"@Inv"},
        plugin = {"pretty",
                "html:src/reports/report.html",
                "json:src/reports/report.json",
        }


)
public class RunTest {


}
