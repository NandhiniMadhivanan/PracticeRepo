package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.waitHelper;

public class loginPage {
    public WebDriver ldriver;
    public waitHelper WaitHelper;

    public loginPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        WaitHelper = new waitHelper(ldriver);
    }

    //Locators
    @FindBy(xpath = "//input[@name = 'userName']")
    @CacheLookup
    public WebElement userNameText;

    @FindBy(xpath = "//input[@name = 'password']")
    @CacheLookup
    public WebElement passwordText;

    @FindBy(xpath = "//input[@name = 'submit']")
    @CacheLookup
    public WebElement submitButton;


    //Action Methods

    public void setUserName(String username){
        WaitHelper.waitForElement(userNameText, 5);
        userNameText.sendKeys(username);
    }

    public void setPassword(String password){
        WaitHelper.waitForElement(passwordText, 5);
        passwordText.sendKeys(password);
    }

    public void clickSubmit(){
        WaitHelper.waitForElement(submitButton, 5);
        submitButton.click();
    }
}
