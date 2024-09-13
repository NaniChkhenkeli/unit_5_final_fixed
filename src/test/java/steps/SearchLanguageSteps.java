package steps;

import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ArticlePage;

public class SearchLanguageSteps {
    private final ArticlePage articlePage = new ArticlePage();

    @Then("the article page for {string} should be open")
    @Step("Verify the article page for {string} is open")
    public void verifyArticlePage(String expectedTitle) {
        Assert.assertEquals(articlePage.getArticleTitle(), expectedTitle, "The article page title is not as expected.");
    }
}
