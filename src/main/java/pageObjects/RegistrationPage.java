package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

  public RegistrationPage(WebDriver driver) {
      super(driver);
  }

  @FindBy(css = "input[name='username']")
    private WebElement usernameInput;

  @FindBy(css = "input[name='email']")
    private WebElement emailInput;

  @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

  @FindBy(css = "input[name='passwordConfirm']")
    private WebElement confirmPasswordInput;

  @FindBy(css = "button[class='btn-login'][type='submit']")
    private WebElement registerSubmitButton;

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        registerSubmitButton.click();
    }

}
