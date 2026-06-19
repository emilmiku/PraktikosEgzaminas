package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='number1']")
    private WebElement firstNumberInput;

    @FindBy(css = "input[name='number2']")
    private WebElement secondNumberInput;

    @FindBy(css = "select[name='operation']")
    private WebElement operationDropdown;

    @FindBy(css = "button.btn-calculate[type='submit']")
    private WebElement calculateButton;

    @FindBy(css = "form[action='/numbers'] button")
    private WebElement calculationsButton;

    public void enterFirstNumber(String number) {
        firstNumberInput.sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        secondNumberInput.sendKeys(number);
    }

    public void selectOperation(String operationText) {
        Select select = new Select(operationDropdown);
        select.selectByVisibleText(operationText);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public void clickCalculationsButton() {
        calculationsButton.click();
    }
}
