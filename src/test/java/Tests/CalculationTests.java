package Tests;

import org.junit.jupiter.api.Test;
import pageObjects.CalculatorPage;
import pageObjects.LoginPage;
import utils.TestData;
import utils.Waiters;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationTests extends BaseTest {

    @Test
    public void positiveCreateCalculationTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("5");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        assertTrue(driver.getPageSource().contains("15"));
    }

    @Test
    public void negativeCreateCalculationTest_emptyFirstNumber() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterSecondNumber("5");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        assertTrue(driver.getCurrentUrl().contains("calculator"));
    }
}
