package hvn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import webui.WebDriverManager;
import webui.pages.BasePage;

import java.net.URL;
import java.util.List;

public class GoogleHomePage extends BasePage {


    private RemoteWebDriver webDriver;
//
//    private String selectedProductName;
//
//    public GoogleHomePage(WebDriver webDriver) {
//        this.webDriver = (RemoteWebDriver) webDriver;
//        this.selectedProductName = "";
//    }

    @FindBy(name = "q")
    private WebElement searchTextbox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "#search a h3")
    private List<WebElement> searchResultList;

    @Override
    public WebDriver getDriver(WebDriver driver) {
        return driver;
    }

    public void navigateTo(String url) {
        WebDriverManager.loadUrl(url);
//        WebDriverManager.getWebDriver().loadUrl(url);
        waitForPageLoaded();
    }

    public void searchWithKeyword(String keyword) {
        setText(searchTextbox, keyword, "Unable to input keyword to search textbox");
    }

    public void clickSearchBtn() {
        click(searchBtn, "Unable to click Search button");
    }

    public void clickResultIndex(int recordIndex) {
        click(searchResultList.get(recordIndex - 1), "Unable to select search result #" + recordIndex);
    }

    public String getResultNumberInList(int index) {
        return getText(searchResultList.get(index - 1), "Unable to get result").trim();
    }

}
