package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopConfirmPage extends PageBaseStore{

    private final String TITLE_SUMMARY_ID = "cart_title";
    private final String BUTTON_SUMMARY_CSS_SELECTOR = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";
    private final String INPUT_EMAIL_ID = "email";
    private final String INPUT_PASS_ID = "passwd";
    private final String BUTTON_SING_IN_CSS_SELECTOR = "#SubmitLogin";
    private final String BUTTON_ADRESS_CSS_SELECTOR = "#center_column > form > p > button";
    private final String INPUT_CHECKBOX_ID = "cgv";
    private final String BUTTON_SHIPPING_CSS_SELECTOR = "#form > p > button";
    private final String BUTTON_PAY_CSS_SELECTOR = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a";
    private final String BUTTON_CONFIRM_ORDER_CSS_SELECTOR = "#cart_navigation > button";

    public ShopConfirmPage (RemoteWebDriver driver){
        super(driver);
        this.url = "/index.php?controller=order";
    }

    public void go(){

        navigateToCompleteURL();
    }

    public void verifyShopConfirmPage(){

        waitForElementVisibility(By.id(TITLE_SUMMARY_ID));
        Assert.assertTrue(isElementVisible(By.id(TITLE_SUMMARY_ID)));
    }

    public void summary(){

        clickElement(By.cssSelector(BUTTON_SUMMARY_CSS_SELECTOR));
    }

    public void singIn(String email, String pass){

        completeField(By.id(INPUT_EMAIL_ID),email);
        completeField(By.id(INPUT_PASS_ID),pass);
        clickElement(By.cssSelector(BUTTON_SING_IN_CSS_SELECTOR));
    }

    public void checkbox(){

        driver.findElement(By.id(INPUT_CHECKBOX_ID)).click();
    }

    public void address(){

        clickElement(By.cssSelector(BUTTON_ADRESS_CSS_SELECTOR));
    }

    public void shipping(){

        clickElement(By.cssSelector(BUTTON_SHIPPING_CSS_SELECTOR));
    }

    public void payment(){

        clickElement(By.cssSelector(BUTTON_PAY_CSS_SELECTOR));
    }

    public void confirmOrder(){

        clickElement(By.cssSelector(BUTTON_CONFIRM_ORDER_CSS_SELECTOR));
    }

}
