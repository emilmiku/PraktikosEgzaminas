package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCalculationPage extends BasePage {

    public EditCalculationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='number1']")
    private WebElement firstNumberInput;

    @FindBy(css = "button[type='submit']")
    private WebElement updateButton;

    public void updateFirstNumber(String number) {
        firstNumberInput.clear();
        firstNumberInput.sendKeys(number);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public void clearFirstNumber() {
        firstNumberInput.clear();
    }

    public String getFirstNumberValidationMessage() {
        return firstNumberInput.getAttribute("validationMessage");
    }
}
