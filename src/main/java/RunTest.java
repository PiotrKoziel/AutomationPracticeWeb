import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/scenarios/",
        monochrome = true,
        tags = {"@Err"
                },
        plugin = {"pretty",
                "html:src/reports/",
                "json:src/reports/report.json",
        }


)
public class RunTest {


}
