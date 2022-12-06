package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.pages.Desktops;
import demo.com.tutorialsninja.pages.LaptopsAndNotebooks;
import demo.com.tutorialsninja.pages.MyAccount;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage();
    Desktops desktops = new Desktops();
    LaptopsAndNotebooks laptopsAndNotebooks = new LaptopsAndNotebooks();
    MyAccount myAccount = new MyAccount();
    ///Homepage


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnDesktopLink();
        homePage.selectMenu("Show All Desktops");
        // String expectedMessage = "Desktops";
        Assert.assertEquals(homePage.getVerifyText(), "Desktops", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.clickOnLaptopNotebooksLink();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(homePage.getVerifyText1(), expectedMessage, "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.clickOnComponantsLink();
        homePage.selectMenu("Show All Components");
        String expectedMessage = "Components";
        Assert.assertEquals(homePage.getVerifyText2(), expectedMessage, "Error Message not displayed");

    }


}