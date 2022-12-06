package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.Desktops;
import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.pages.LaptopsAndNotebooks;
import demo.com.tutorialsninja.pages.MyAccount;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {
    HomePage homePage = new HomePage();
    Desktops desktops = new Desktops();
    LaptopsAndNotebooks laptopsAndNotebooks = new LaptopsAndNotebooks();
    MyAccount myAccount = new MyAccount();

    //****************************************DesktopTest******************************************************
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.verifyZtoAforDropDroDown();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully () throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();
        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.SortByNameZtoAfromDropdown();
        desktops.clickOnHPlp3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktops.getVerifyTextHp(), expectedMessage, "Error Message not displayed");
        desktops.selectDeliveryDate();
        //desktops.changeQuantity("1");
        desktops.clickOnAdToCart();
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(desktops.getVerifyShoppingCart(), expectedMessage, "Error Message not displayed");
        desktops.clickOnShppingCart();
        Thread.sleep(3000);
        //Assert.assertEquals(desktops.getVerifyShoppingCart(), "Shopping Cart", "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyProductName(), "HP LP3065", "Error Message not displayed");
        //  String expectedMessage4 = "2022-11-30";
        // Assert.assertEquals(desktops.getVerifyDeliveryDate(), expectedMessage, "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyModel(), "Product Code: Product 21", "Error Message not displayed");
        Thread.sleep(2000);
        //Assert.assertEquals(desktops.getVerifyTotal(), "£74.73", "Error Message not displayed");

    }
}
