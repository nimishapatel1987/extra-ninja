package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooks extends Utility {

    By laptopLink = By.linkText("Laptops & Notebooks");

    public void clickOnLaptoptopLink() {
        clickOnElement(laptopLink);
    }

    public String shortPriceLowToHigh() {
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        // Assert.assertEquals("Product not sorted by price High to Low",
        // originalProductsPrice, afterSortByPrice);

        return null;
    }

    public void changeCurrency() {
       // clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    By allLaptopAndNotebooksLink = By.linkText("Show All Laptops & Notebooks");

    public void clickOnAllLaptopAndNotebooksLink() {
        clickOnElement(allLaptopAndNotebooksLink);
    }

    By sortByPriceHighToLow = By.id("input-sort");

    public void sortByPriceHighToLowfromDropdown() {
        sendTextToElement(sortByPriceHighToLow, "Price (High > Low)");
    }

    By macbookLink = By.linkText("MacBook");

    public void clickOnMacbookLink() {
        clickOnElement(macbookLink);
    }

    By varifyMacbook = By.linkText("MacBook");

    public String getVerifyMacbook() {
        return getTextFromElement(varifyMacbook);
    }

    By addToCart = By.xpath("//button[@id='button-cart']");

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    By varifySusccess = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public String getVerifySuccess() {
        return getTextFromElement(varifySusccess);
    }

    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");

    public void clickOnShoppingCart() {
        clickOnElement(addToCart);
    }

    By varifyCart = By.xpath("//a[contains(text(),'shopping cart')]");

    public String getVerifyCart() {
        return getTextFromElement(varifyCart);
    }

    By varifyProductMacbook = By.xpath("//div[@id='content']//h1");

    public String getVerifyProductMacbook() {
        return getTextFromElement(varifyProductMacbook);
    }

    By updateCart = By.xpath("//button[@id='button-cart']");

    public void clickOnUpdateCart() {
        clickOnElement(updateCart);
    }

    By varifyCartText = By.xpath("//body/div[@id='product-product']/div[1]");

    public String getVerifyCarttext() {
        return getTextFromElement(varifyCartText);
    }

    By varifyTotal = By.xpath("//header/div[1]/div[1]/div[3]/div[1]/button[1]");

    public String getVerifyTotal() {
        return getTextFromElement(varifyTotal);
    }

    By clickonCart = By.xpath("//header/div[1]/div[1]/div[3]/div[1]/button[1]");

    public void clickOnCheckoutCart() {
        clickOnElement(clickonCart);
    }

    By clickonCheckout = By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]");

    public void clickOnFinalCheckout() {
        clickOnElement(clickonCheckout);
    }

    By varifyCheckout = By.xpath("//a[contains(text(),'Checkout')]");

    public String getVerifyCheckout() {
        return getTextFromElement(varifyCheckout);
    }

    By varifyNewCustomer = By.xpath("//div[@class='col-sm-6']//h2");

    public String getVerifyNewCustomer() {
        return getTextFromElement(varifyNewCustomer);
    }

    By guestCheckout = By.xpath("//label[text()[normalize-space()='Guest Checkout']]");

    public void clickOnGuestCheckout() {
        clickOnElement(guestCheckout);
    }

    By continueTab = By.xpath("//input[@id='button-account']");

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    By nameField = By.name("firstname");

    public void enterName(String name) {
        sendTextToElement(nameField, name);
    }

    By lastnameField = By.name("lastname");

    public void enterLastName(String lastname) {
        sendTextToElement(lastnameField, lastname);
    }

    By emaileField = By.id("input-payment-email");

    public void enterEmail(String email) {
        sendTextToElement(emaileField, email);
    }

    By telePhone = By.name("telephone");

    public void enterTelephone(String phone) {
        sendTextToElement(telePhone, phone);
    }

    By addressLine = By.name("address_1");

    public void enterAddress(String street) {
        sendTextToElement(addressLine, street);
    }

    By cityName = By.name("city");

    public void enterCity(String city) {
        sendTextToElement(cityName, city);
    }

    By postCode = By.name("postcode");

    public void enterPostcode(String code) {
        sendTextToElement(postCode, code);
    }

    By countryName = By.id("input-payment-country");

    public void enterCountry(String country) {
        sendTextToElement(countryName, country);
    }

    By zoneName = By.xpath("//select[@id='input-payment-zone']");

    public void enterState(String state) {
        sendTextToElement(zoneName, state);
    }

    By continueCheckout = By.xpath("(//input[@value='Continue'])[2]");

    public void clickOnCheckout() {
        clickOnElement(continueCheckout);
    }

    By passtext = By.xpath("//textarea[@name='comment']");

    public void enterText(String msg) {
        sendTextToElement(passtext, msg);
    }

    By termsCondition = By.xpath("//input[@type='checkbox']");

    public void clickOnTerms() {
        clickOnElement(termsCondition);
    }

    By lastContinue = By.xpath("//input[@id='button-payment-method']");

    public void clickContinue() {
        clickOnElement(lastContinue);
    }

    By warningMsg = By.xpath("//div[contains(@class,'alert alert-danger')]");

    public String getVerifyWarningMsg() {
        return getTextFromElement(warningMsg);
    }
}


