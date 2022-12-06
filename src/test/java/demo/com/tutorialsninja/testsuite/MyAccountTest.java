package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.Desktops;
import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.pages.LaptopsAndNotebooks;
import demo.com.tutorialsninja.pages.MyAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest {
    HomePage homePage = new HomePage();
    Desktops desktops = new Desktops();
    LaptopsAndNotebooks laptopsAndNotebooks = new LaptopsAndNotebooks();
    MyAccount myAccount = new MyAccount();


    //**************************************MyAccount***************************************


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Register");

        myAccount.enterFirstName("prime");
        myAccount.enterLastName("testing");
        myAccount.enterEmailAdd("selenium555@gmail.com");
        myAccount.enterPhone("12345678965");
        myAccount.enterPassword("123456");
        myAccount.enterConfirmPass("123456");

        myAccount.clickYesonNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();

        Assert.assertEquals(myAccount.getVerifyMessage(), "Your Account Has Been Created!", "Error Message not displayed");
        myAccount.clickOnContinueButton();

        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Login");

        myAccount.enterEmailAdd("selenium55@gmail.com");
        myAccount.enterPassword("123456");


        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }


}
