/*
 * Blocks of code that run after each feature file
 */
package web.automation.test.integration.steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import web.automation.test.integration.driver.DriverConfig;

public class HooksSteps {

    WebDriver driver;

    public HooksSteps() {
        this.driver = DriverConfig.driver;
    }

    @After
    public void cleanUpAfterScenario() {

        driver.close();
        driver.quit();
    }
}
