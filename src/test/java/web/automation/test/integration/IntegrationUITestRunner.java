package web.automation.test.integration;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/*Junit Runner Class*/
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"web.automation.test.integration.steps"})
public class IntegrationUITestRunner {
}
