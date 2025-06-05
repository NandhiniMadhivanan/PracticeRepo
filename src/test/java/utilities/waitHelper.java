package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class waitHelper {

    public static WebDriver driver;

    public waitHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElement(WebElement element, int timeoutInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElements(List<WebElement> element, int timeoutInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
}
