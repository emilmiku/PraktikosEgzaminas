package Tests;

import org.junit.jupiter.api.Test;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utils.Waiters;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {
    @Test
    public void positiveRegistrationTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        String uniqueUsername = "user" + System.currentTimeMillis(); // sugeneruojam unikalu uername
        String uniqueEmail = "email" + System.currentTimeMillis() + "@test.com"; // unikalus passsword

        registrationPage.enterUsername(uniqueUsername);
        registrationPage.enterEmail(uniqueEmail);
        registrationPage.enterPassword("Test123!");
        registrationPage.enterConfirmPassword("Test123!");
        registrationPage.clickRegisterButton();

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void negativeRegistrationTest_passwordsDoNotMatch() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        Waiters waiters = new Waiters(driver);
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
