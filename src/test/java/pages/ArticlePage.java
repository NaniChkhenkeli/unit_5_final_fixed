package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ArticlePage extends Form {
    private final IElement articleTitle = getElementFactory().getLabel(By.id("firstHeading"), "Article Title");
    private final IButton toolsMenuButton = getElementFactory().getButton(By.xpath("//*[@id='vector-page-tools-dropdown-label']"), "Tools");
    private final IButton pageInfoButton = getElementFactory().getButton(By.xpath("//*[@id='t-info']/a"), "Page Information Button");
    private final IButton downloadPDFButton = getElementFactory().getButton(By.xpath("//*[@id='coll-download-as-rl']"), "Download as PDF Button");
    private final IElement pageInfoContent = getElementFactory().getLabel(By.xpath("//*[@id=\"firstHeading\"]"), "Page Information Content");

    public ArticlePage() {
        super(By.id("content"), "Article Page");
    }

    public String getArticleTitle() {
        return articleTitle.getText();
    }

    public void clickToolsMenuButton() {
        toolsMenuButton.getJsActions().scrollIntoView();
        toolsMenuButton.state().waitForClickable();
        toolsMenuButton.getJsActions().click();
    }

    public void clickDownloadPDFButton() {
        downloadPDFButton.getJsActions().scrollIntoView();
        downloadPDFButton.click();
    }

    public void clickPageInfoButton() {
        pageInfoButton.state().waitForClickable();
        pageInfoButton.click();

    }

    public boolean isPageInfoDisplayed() {
        return pageInfoContent.state().isDisplayed();
    }
}
