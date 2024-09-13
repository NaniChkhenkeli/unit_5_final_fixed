package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SettingsTestData;

public class Hooks {
    private Browser browser;

    @Before
    public void setup() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(SettingsTestData.WIKIPEDIA_URL);
    }

    @After
    public void teardown() {
        if (browser != null) {
            browser.quit();
        }
    }
}
