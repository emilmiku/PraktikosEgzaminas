package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculationHistoryPage extends BasePage {

    public CalculationHistoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href*='/update']")
    private WebElement firstEditButton;

    @FindBy(xpath = "(//a[contains(@href, '/update')])[last()]")
    private WebElement lastEditButton;

    @FindBy(xpath = "(//a[contains(@href,'/delete')])[last()]")
    private WebElement lastDeleteButton;

    public void clickFirstEditButton() {
        firstEditButton.click();
    }

    public void clickLastEditButton() {
        lastEditButton.click();
    }

    public void clickLastDeleteButton() {
        lastDeleteButton.click();
    }

    public boolean isCalculationVisible(String firstNumber,
                                        String operation,
                                        String secondNumber,
                                        String result,
                                        String username) {

        String pageText = driver.getPageSource(); // paimamamas visas puslapio HTML

        return pageText.contains(firstNumber) //gaunam teksta
                && pageText.contains(operation)
                && pageText.contains(secondNumber)
                && pageText.contains(result)
                && pageText.contains(username);
    }

    public boolean isTextVisible(String text) {
        return driver.getPageSource().contains(text);
    }

}
