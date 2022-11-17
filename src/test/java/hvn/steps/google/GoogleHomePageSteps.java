package hvn.steps.google;


import common.LoggingManager;
import common.utils.PropertyUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import hvn.pages.GoogleHomePage;
import hvn.steps.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashMap;

public class GoogleHomePageSteps extends BaseSteps {
    private RemoteWebDriver driver;

    private GoogleHomePage googleHomePage;

    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptions = new HashMap<>();
        bstackOptions.putIfAbsent("source", "cucumber-java:sample-sdk:v1.0");
        capabilities.setCapability("bstack:options", bstackOptions);
        driver = new RemoteWebDriver(
                new URL("https://trungleauto_qDiu9F:f4pf1M5MfzR1kLPkG2UM@hub-cloud.browserstack.com/wd/hub"), capabilities);
        googleHomePage.getDriver(driver);

    }

    @Given("I'm on the Google search")
    public void openGoogleHomePage() {
//        GoogleHomePage googleHomePage = new GoogleHomePage();
        driver.get("https://google.com");
    }

    @When("I enter {string} into search text box")
    public void searchValue(String keyword) {
        googleHomePage.searchWithKeyword(keyword);
    }

    @And("I click Search button")
    public void clickSearchBtn() {
        googleHomePage.clickSearchBtn();
    }

    @And("I select the first record in search result")
    public void selectFirstRecord() {
        googleHomePage.clickResultIndex(1);
    }

    @Then("I verify that {string} site is at the first in search result")
    public void verifyResult(String site) {
        String actualResult = googleHomePage.getResultNumberInList(1);
        boolean result = actualResult.contains(site);
        LoggingManager.assertTrue(getClassName(), result, site + " is at the first in search result",
                "Failed to verify search result");
    }
    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
