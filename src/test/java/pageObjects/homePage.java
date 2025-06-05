package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.waitHelper;

public class homePage {
    public WebDriver ldriver;
    public waitHelper WaitHelper;

    public homePage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        WaitHelper = new waitHelper(ldriver);
    }

    // Locators
    @FindBy(xpath = "//a[contains(text(), 'Flights')]")
    @CacheLookup
    public WebElement flightsLink;

    @FindBy(xpath = "//a[contains(text(), 'Hotels')]")
    @CacheLookup
    public WebElement hotelsLink;

    @FindBy(xpath = "//a[contains(text(), 'Car Rentals')]")
    @CacheLookup
    public WebElement carRentalsLink;

    @FindBy(xpath = "//a[contains(text(), 'Cruises')]")
    @CacheLookup
    public WebElement cruisesLink;

    @FindBy(xpath = "//a[contains(text(), 'Destinations')]")
    @CacheLookup
    public WebElement destinationsLink;

    @FindBy(xpath = "//a[contains(text(), 'Vacations')]")
    @CacheLookup
    public WebElement vacationsLink;

    // All Methods

    public void clickFlightLink(){
        WaitHelper.waitForElement(flightsLink, 5);
        flightsLink.click();
    }

    public void clickHotelsLink(){
        WaitHelper.waitForElement(hotelsLink, 5);
        hotelsLink.click();
    }

    public void clickCarRentalsLink(){
        WaitHelper.waitForElement(carRentalsLink, 5);
        carRentalsLink.click();
    }

    public void clickCruisesLink(){
        WaitHelper.waitForElement(cruisesLink, 5);
        cruisesLink.click();
    }

    public void clickDestinationsLink(){
        WaitHelper.waitForElement(destinationsLink, 5);
        destinationsLink.click();
    }

    public void clickVacationsLink(){
        WaitHelper.waitForElement(vacationsLink,5);
        vacationsLink.click();
    }

}


