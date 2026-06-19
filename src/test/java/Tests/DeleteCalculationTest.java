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


@Tag("Delete")
public class DeleteCalculationTest extends BaseTest {

    @Test
    public void positiveDeleteCalculationTest() {

        String firstNumber = String.valueOf((int) (System.currentTimeMillis() % 100000));

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

        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickCalculationsButton();

        waiters.waitUntilUrlContains("numbers");

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        historyPage.clickDeleteButtonByFirstNumber(firstNumber);

        driver.switchTo().alert().accept();

        driver.navigate().refresh();

        assertFalse(driver.getPageSource().contains(firstNumber));
    }

    @Test
    public void negativeDeleteCalculationTest() {

        String firstNumber = "333";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterFirstNumber(firstNumber);
        calculatorPage.enterSecondNumber("444");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        calculatorPage.clickCalculationsButton();
        waiters.waitUntilUrlContains("numbers");

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        historyPage.clickDeleteButtonByFirstNumber(firstNumber);

        driver.switchTo().alert().dismiss();

        assertTrue(driver.getPageSource().contains(firstNumber));
    }
}
