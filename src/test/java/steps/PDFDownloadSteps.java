package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ArticlePage;
import pages.PDFDownloadPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class PDFDownloadSteps {

    private final ArticlePage articlePage = new ArticlePage();
    private final PDFDownloadPage pdfDownloadPage = new PDFDownloadPage();
    private final String downloadPath = "downloads/";

    @When("I download the article as PDF")
    @Step("Download the article as PDF")
    public void downloadAsPDF() {
        articlePage.clickToolsMenuButton();
        articlePage.clickDownloadPDFButton();
        pdfDownloadPage.clickDownloadButton();
    }

    @Then("the PDF file should be downloaded")
    @Step("Verify the PDF file is downloaded")
    public void verifyPDFDownload() {
        String fileName = "Albert_Einstein.pdf";
        File file = new File(downloadPath + fileName);

        await().atMost(20, TimeUnit.SECONDS)
                .until(file::exists);

        Assert.assertTrue(file.exists(), "PDF file was not downloaded.");
    }
}
