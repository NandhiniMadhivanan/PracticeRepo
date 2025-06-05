package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinition"},
        dryRun = false,
        monochrome = true,
        tags = "@mytag"
)
public class testRunner extends AbstractTestNGCucumberTests {
}
