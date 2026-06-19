package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.bidi.browsingcontext.Locator.css;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);

    }

    @FindBy(css("button[class='btn-register']"))
    private WebElement registrationButton;

    public void clickRegisterButton() {
        registrationButton.click();
    }
}
