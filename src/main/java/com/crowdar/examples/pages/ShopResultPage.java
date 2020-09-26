package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopResultPage extends PageBaseStore {

    private final String RESULT_CSS_SELECTOR = "#center_column > ul > li > div > div.left-block > div > a.product_img_link"; //es el producto seleccionado
    private final String SELECT_PRODUCT_CSS_SELECTOR = "#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"; //es el titulo del producto, donde hace el click

    public ShopResultPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "/index.php?controller=search&orderby=position&orderway=desc&search_query=dresses&submit_search=";
    }

    public void go(){

        navigateToCompleteURL();
    }

    public void selectProduct(){

        driver.findElement(By.cssSelector(SELECT_PRODUCT_CSS_SELECTOR)).click();
        //clickElement(By.cssSelector(SELECT_PRODUCT_CSS_SELECTOR));
    }

    public void verifyShopResultPage(){
        waitForElementVisibility(By.cssSelector(RESULT_CSS_SELECTOR)); //espera a que los elementos sean visible
        Assert.assertTrue(isElementVisible(By.cssSelector(RESULT_CSS_SELECTOR))); //assert: se utiliza para decir que una variable es verdadera.
                                                                                    //assertTrue: comprueba que lo que entre sea TRUE
    }

}
