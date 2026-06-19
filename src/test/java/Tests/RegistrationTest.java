package Tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utils.Waiters;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Registration")
public class RegistrationTest extends BaseTest {
    @Test
    public void positiveRegistrationTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("register");

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        String uniqueUsername = "user" + System.currentTimeMillis();
        String uniqueEmail = "email" + System.currentTimeMillis() + "@test.com";

        registrationPage.enterUsername(uniqueUsername);
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Test123!");
        registrationPage.enterConfirmPassword("Test123!");
        registrationPage.clickRegisterButton();

        waiters.waitUntilUrlContains("login");

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void negativeRegistrationTest_passwordsDoNotMatch() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        Waiters waiters = new Waiters(driver);
        waiters.waitUntilUrlContains("register");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        waiters.waitUntilElementVisible(
                registrationPage.getUsernameInput()
        );

        registrationPage.enterUsername("testuser");
        registrationPage.enterEmail("test@test.com");
        registrationPage.enterPassword("Test123!");
        registrationPage.enterConfirmPassword("Wrong123!");
        registrationPage.clickRegisterButton();

        assertTrue(driver.getPageSource()
                .contains("Passwords do not match"));
    }
}
