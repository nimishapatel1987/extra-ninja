package demo.com.tutorialsninja.testbase;

import demo.com.tutorialsninja.propertyreader.PropertyReader;
import demo.com.tutorialsninja.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    // String browser = "chrome";
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp() {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}