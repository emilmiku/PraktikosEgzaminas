package pageObjects;

import org.openqa.selenium.WebDriver;

public class CalculationHistoryPage extends BasePage {

    public CalculationHistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCalculationVisible(String firstNumber,
                                        String operation,
                                        String secondNumber,
                                        String result,
                                        String username) {

        String pageText = driver.getPageSource(); // paimamamas visas puslapio HTML

        return pageText.contains(firstNumber)
                && pageText.contains(operation)
                && pageText.contains(secondNumber)
                && pageText.contains(result)
                && pageText.contains(username);
    }

    public boolean isTextVisible(String text) {
        return driver.getPageSource().contains(text);
    }

}
