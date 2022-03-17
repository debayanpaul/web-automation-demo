package web.automation.test.integration.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Driver Configuration Class */
public class DriverConfig {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            return driver;

        } catch (Exception e) {
            System.out.printf(e.toString());
            return null;
        }
    }
}
