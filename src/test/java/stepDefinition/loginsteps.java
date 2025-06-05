package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.homePage;
import pageObjects.loginPage;
import utilities.waitHelper;

public class loginsteps {

    public WebDriver driver;
    public waitHelper WaitHelper;
    public loginPage lp;

    public homePage hp;
    @Given("The user launch the browser")
    public void the_user_launch_the_browser() {
        System.setProperty("webdriver.chrome.driver",".//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new loginPage(driver);
        WaitHelper = new waitHelper(driver);
        hp = new homePage(driver);
    }
    @When("Pass the demouat URL")
    public void pass_the_demouat_url() {
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        driver.manage().window().maximize();
    }
    @When("User enters the {string} and {string}")
    public void user_enters_the_and(String un, String pwd) {
        lp.setUserName(un);
        lp.setPassword(pwd);
    }
    @When("click the login button")
    public void click_the_login_button() {
        lp.clickSubmit();
    }
    @Then("Homepage is displayed")
    public void homepage_is_displayed() {
       Boolean textPresent = driver.getPageSource().contains("Login Successfully");
       if(textPresent == true){
           System.out.println("Homepage displayed successfully");
       }
       else{
           System.out.println("Homepage not logged in");
       }
    }
    @Then("Quit the browser")
    public void quit_the_browser() {
       driver.quit();
    }

    @Then("click on the Flights Link")
    public void click_on_the_flights_link() throws InterruptedException {
        hp.clickFlightLink();
        String pageTitle = driver.getTitle();
        System.out.println("The page displayed is: " +pageTitle);
        Thread.sleep(3000);

        //driver.switchTo().alert().accept();
        String currentURL = driver.getCurrentUrl();
        Boolean status = currentURL.equals("https://demo.guru99.com/test/newtours/reservation.php");
        if(status == true){
            System.out.println("The expected URL is displayed " +currentURL);
        }
        else{
            System.out.println("The expected URL is not displayed");
        }
    }

}
