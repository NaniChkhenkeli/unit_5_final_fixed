package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PDFDownloadPage extends Form {

    private final IButton downloadButton = getElementFactory().getButton(
            By.xpath("//*[@id='mw-content-text']/form/div/span/span/button"),
            "Download Button"
    );

    public PDFDownloadPage() {
        super(By.id("mw-content-text"), "PDF Download Page");
    }

    public void clickDownloadButton() {
        downloadButton.state().waitForClickable();
        downloadButton.click();
    }
}
