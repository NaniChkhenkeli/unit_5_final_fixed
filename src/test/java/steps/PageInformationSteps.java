package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ArticlePage;

public class PageInformationSteps {

    private final ArticlePage articlePage = new ArticlePage();

    @When("I view the page information")
    @Step("View the page information")
    public void viewPageInformation() {
        articlePage.clickToolsMenuButton();
        articlePage.clickPageInfoButton();
    }

    @Then("the page information should be displayed")
    @Step("Verify the page information is displayed")
    public void verifyPageInformation() {
        Assert.assertTrue(articlePage.isPageInfoDisplayed(), "The page information was not displayed.");
    }
}
