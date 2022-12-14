package demo.com.tutorialsninja.utility;

import com.google.common.base.Function;
import demo.com.tutorialsninja.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class Utility extends ManageBrowser {

    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    //this method will click on elements
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    //find the filed and send data in to field
    public void sendTextToElement(By by, String text) {  //for locator always us By by
        driver.findElement(by).sendKeys(text);

    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
        //WebElement actualTextMessageElement = driver.findElement(by);
        // return actualTextMessageElement.getText();

    }

    //public void verifyExpectedAndActual(By by, String expectedText) {
    //  String actualText = getTextFromElement(by);
    //  Assert.assertEquals(expectedText, actualText);

    //  }

    // public void verifyMessage(String expectedMessage, String actualMessage) {
    //Assert.assertEquals(expectedMessage, actualMessage);

    //}

    //****************   Alert Methods   ******************************************************************************

    //this methos will switch to your alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //this method will accept your alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //this method will cancle your alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //this method will (String) getTextFromAlert
    public void getTextFromAlert() {
        driver.switchTo().alert().getText();
        //String text = driver.switchTo().alert().getText();
        //System.out.println(text);
    }

    //this method will sendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    //***************************************************************************************************************


    //*******************************  Select Class Method  *********************************************************


    //This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);  //all black letter on element are visible text
        //selectByVisibleTextFromDropDown(By.xpath("//label[contains(text(),'Country:')]"), "japan");
    }

    //this method will select option by Value
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    //this method will select option by Index - like 1.2.3
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    //this method will select option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
    //***********************************************************************************************************

    //*********************Window Handle*****************************

    //This method will close all windows
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    //This method will switch to parent window
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    //This method will find that we switch to right window
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
    //**********************************************************************************************************

    //***************Action Methods*******************************************************************************

    //mouseHoverToElement(By by),
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        //WebElement computer = driver.findElement(by);
        //actions.moveToElement(computer).build().perform();

    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        //WebElement software = driver.findElement(by);
        //actions.moveToElement(software).click().build().perform();
    }

    public void dragAndDrop(By by, By by1) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(by), driver.findElement(by1)).build().perform();
        //WebElement draggable = driver.findElement(By.id("draggable"));
        //WebElement droppable = driver.findElement(By.id("droppable"));
        //actions.dragAndDrop(draggable, droppable).build().perform();
    }

    //******************************************************************************************
    public void clearText(By by) {
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(by);
        quantity.clear();
    }

    //************************** Waits Methods *********************************************//
    //Implecitly Wait, Explicit Wait, Fluent Wait

    //This method will use to wait until  VisibilityOfElementLocated
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
}