package Tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.CalculationHistoryPage;
import pageObjects.CalculatorPage;
import pageObjects.LoginPage;
import utils.TestData;
import utils.Waiters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("History")
public class CalculationHistoryTest extends BaseTest {

    @Test
    public void positiveSearchExistingCalculationTest() {
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

        waiters.waitUntilUrlContains("calculate");

        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickCalculationsButton();

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        assertTrue(historyPage.isCalculationVisible(
                "10",
                "+",
                "5",
                "15",
                TestData.VALID_USERNAME
        ));
    }

    @Test
    public void negativeSearchExistingCalculationTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickCalculationsButton();

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        assertFalse(historyPage.isTextVisible("ABCDEFG12345"));
    }
}
