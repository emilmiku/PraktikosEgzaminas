package Tests;

import org.junit.jupiter.api.Test;
import pageObjects.CalculationHistoryPage;
import pageObjects.CalculatorPage;
import pageObjects.LoginPage;
import utils.TestData;
import utils.Waiters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteCalculationTest extends BaseTest {

    @Test
    public void positiveDeleteCalculationTest() {

        String firstNumber = "987654";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.enterFirstNumber(firstNumber);
        calculatorPage.enterSecondNumber("222");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        calculatorPage.clickCalculationsButton();
        waiters.waitUntilUrlContains("numbers");

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        historyPage.clickLastDeleteButton();
        driver.switchTo().alert().accept();

        assertFalse(driver.getPageSource().contains(firstNumber));
    }

    @Test
    public void negativeDeleteCalculationTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterFirstNumber("333");
        calculatorPage.enterSecondNumber("444");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        calculatorPage.clickCalculationsButton();

        waiters.waitUntilUrlContains("numbers");

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        historyPage.clickLastDeleteButton();

        driver.switchTo().alert().dismiss();

        assertTrue(driver.getPageSource().contains("333"));
    }
}
