package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.MainPage;
import static aquality.selenium.browser.AqualityServices.getBrowser;

public class MainPageSteps {
    private final MainPage mainPage;

    public MainPageSteps() {
        this.mainPage = new MainPage(getBrowser().getDriver());
    }

    @Given("the Main page is open")
    @Step("Open the main page")
    public void openMainPage() {
        mainPage.open();
    }

    @When("I search for {string}")
    @Step("Search for {string}")
    public void searchForArticle(String article) {
        mainPage.searchFor(article);
        mainPage.submitSearch();
    }

    @When("I search for {string} in {string}")
    @Step("Search for {string} in {string}")
    public void searchForInLanguage(String query, String language) {
        mainPage.selectSearchLanguage(language);
        mainPage.searchFor(query);
        mainPage.submitSearch();
    }
}



