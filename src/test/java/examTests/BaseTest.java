package examTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {

        ChromeOptions options = new ChromeOptions(); // jeigu reikes
        options.setAcceptInsecureCerts(true); // jeigu reikes

        driver = new ChromeDriver(options);
        driver.get(); // ideti svetaines url

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }


}
