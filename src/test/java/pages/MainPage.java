package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class MainPage extends Form {
    private final ITextBox searchBox = getElementFactory().getTextBox(By.id("searchInput"), "Search Input");
    private final IButton languageMenuButton = getElementFactory().getButton(By.xpath("//*[@id='search-input']/div[1]/div"), "Language Menu Button");
    private final IButton searchButton = getElementFactory().getButton(By.xpath("//*[@id='search-form']/fieldset/button"), "Search Button");

    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final String MAIN_PAGE_URL = "https://www.wikipedia.org/";

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        super(By.id("searchInput"), "Main Page");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void open() {
        getBrowser().goTo(MAIN_PAGE_URL);
        getBrowser().waitForPageToLoad();
    }

    public void searchFor(String query) {
        searchBox.clearAndType(query);
    }

    public void selectSearchLanguage(String language) {
        languageMenuButton.click();

        WebElement languageMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search-input']/div[1]/div")));
        String languageXPath = "//select[@id='searchLanguage']/option[text()='" + language + "']";
        WebElement languageOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(languageXPath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", languageOption);
    }

    public void submitSearch() {
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search-form']/fieldset/button")));
        searchButtonElement.click();
    }
}
