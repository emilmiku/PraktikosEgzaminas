package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


    public void clickFirstEditButton() {
        firstEditButton.click();
    }

    public void clickEditButtonByFirstNumber(String firstNumber) {
        WebElement editButton = driver.findElement(
                By.xpath("//tr[td[text()='" + firstNumber + "']]//a[contains(@href, '/update')]")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", editButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", editButton);
    }

    public void clickLastEditButton() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", lastEditButton);

        lastEditButton.click();
    }


    public void clickDeleteButtonByFirstNumber(String firstNumber) {
        WebElement deleteButton = driver.findElement(
                By.xpath("//tr[td[text()='" + firstNumber + "']]//a[contains(@href, '/delete')]")
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", deleteButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", deleteButton);
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
