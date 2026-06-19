package Tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.CalculationHistoryPage;
import pageObjects.CalculatorPage;
import pageObjects.EditCalculationPage;
import pageObjects.LoginPage;
import utils.TestData;
import utils.Waiters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Edit")
public class EditCalculationTest extends BaseTest {

    @Test
    public void positiveEditCalculationTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        // Sukuriam naują įrašą
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterFirstNumber("10");
        calculatorPage.enterSecondNumber("5");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        // Einam į istoriją
        calculatorPage.clickCalculationsButton();

        waiters.waitUntilUrlContains("numbers");

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        historyPage.clickLastEditButton();

        waiters.waitUntilUrlContains("update");

        EditCalculationPage editPage =
                new EditCalculationPage(driver);

        editPage.updateFirstNumber("20");
        editPage.clickUpdateButton();

        assertTrue(driver.getPageSource().contains("20"));
    }
    @Test
    public void negativeEditCalculationTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(TestData.VALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.enterFirstNumber("777777");
        calculatorPage.enterSecondNumber("5");
        calculatorPage.selectOperation("Addition");
        calculatorPage.clickCalculateButton();

        calculatorPage.clickCalculationsButton();
        waiters.waitUntilUrlContains("numbers");

        CalculationHistoryPage historyPage =
                new CalculationHistoryPage(driver);

        historyPage.clickEditButtonByFirstNumber("777777");

        waiters.waitUntilUrlContains("update");

        EditCalculationPage editPage =
                new EditCalculationPage(driver);

        editPage.clearFirstNumber();
        editPage.clickUpdateButton();

        assertFalse(editPage.getFirstNumberValidationMessage().isEmpty());
    }
}
