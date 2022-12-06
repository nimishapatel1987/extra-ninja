package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.Desktops;
import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.pages.LaptopsAndNotebooks;
import demo.com.tutorialsninja.pages.MyAccount;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebookTest extends BaseTest {

    HomePage homePage = new HomePage();
    Desktops desktops = new Desktops();
    LaptopsAndNotebooks laptopsAndNotebooks = new LaptopsAndNotebooks();
    MyAccount myAccount = new MyAccount();

    //*************************************LaptopsAndNotbooks*************************************************
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully () {

        laptopsAndNotebooks.clickOnLaptoptopLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully () {
        laptopsAndNotebooks.changeCurrency();
        laptopsAndNotebooks.clickOnLaptoptopLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.sortByPriceHighToLowfromDropdown();
        laptopsAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooks.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();

        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");
        laptopsAndNotebooks.clickOnUpdateCart();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyCarttext(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopsAndNotebooks.clickOnCheckoutCart();
        laptopsAndNotebooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");

        laptopsAndNotebooks.clickOnGuestCheckout();
        laptopsAndNotebooks.clickOnContinueTab();
        laptopsAndNotebooks.enterName("Prime");
        laptopsAndNotebooks.enterLastName("testing");
        laptopsAndNotebooks.enterEmail("prime1246@gmail.com");
        laptopsAndNotebooks.enterTelephone("123456789012");
        laptopsAndNotebooks.enterAddress("selenium");
        laptopsAndNotebooks.enterCity("adtala");
        laptopsAndNotebooks.enterPostcode("365430");
        laptopsAndNotebooks.enterCountry("India");
        laptopsAndNotebooks.enterState("Gujarat");

        laptopsAndNotebooks.clickOnCheckout();
        laptopsAndNotebooks.enterText("thanks");

        laptopsAndNotebooks.clickOnTerms();
        laptopsAndNotebooks.clickContinue();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }

}
