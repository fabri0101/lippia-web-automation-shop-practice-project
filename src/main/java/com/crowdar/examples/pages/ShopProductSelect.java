package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShopProductSelect extends PageBaseStore{

    //private final String NOMBRE_PRODUCTO_CSS_SELECTOR = "#center_column > ul > li:nth-child(1) > div > div.right-block > h5";
    private final String NOMBRE_PRODUCTO_2_CSS_SELECTOR = "#short_description_content > p"; //es la descripcion del producto elegido
    private final String SELECT_QUANTITY_ID = "quantity_wanted";
    //private final String SELECT_SIZE_ID = "group_1 > option:nth-child(2)";
    private  String SELECT_COLOR_ID;
    private final String BUTTON_ADD_TO_CART_CSS_SELECTOR = "#add_to_cart > button";
    private final String BUTTON_PROCEED_TO_CHECKOUT_CSS_SELECTOR = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a";
    private final String CLICK_PARA_DESEMFOCAR_ID = "product_reference";

    public ShopProductSelect (RemoteWebDriver driver){
        super(driver);
        this.url = "/index.php?id_product=5&controller=product&search_query=dresses&results=7";
    }

    public void go(){

        navigateToCompleteURL();
    }

    public void selectQuantity(String cantidad) {

        completeField(By.id(SELECT_QUANTITY_ID), cantidad);
        clickElement(By.id(CLICK_PARA_DESEMFOCAR_ID));
    }

    public void selectSize(String talle){

        Select size = new Select(driver.findElement(By.id("group_1"))); // esto sirve cuando tenemos opciones desplegables

        size.selectByVisibleText(talle);
        //clickElement(By.id(SELECT_SIZE_ID));
    }

    public void selectColor(String color) {

        SELECT_COLOR_ID = color;
        clickElement(By.id(SELECT_COLOR_ID));
    }

    public void addToCart() {

        clickElement(By.cssSelector(BUTTON_ADD_TO_CART_CSS_SELECTOR));
    }

    public void proceedToCheckout(){

        clickElement(By.cssSelector(BUTTON_PROCEED_TO_CHECKOUT_CSS_SELECTOR));
    }

    //PREGUNTAR///////////////////////////////////////////////////////////////////////////////////

    //public void verifyShopProduct(){

    //  waitForElementVisibility(By.cssSelector(NOMBRE_PRODUCTO_CSS_SELECTOR));
    //  Assert.assertTrue(isElementVisible(By.cssSelector(NOMBRE_PRODUCTO_CSS_SELECTOR)));
    //}

    //////////////////////////////////////////////////////////////////////////////////////////////

    public void verifyShopProduct2(){

        waitForElementVisibility(By.cssSelector(NOMBRE_PRODUCTO_2_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(NOMBRE_PRODUCTO_2_CSS_SELECTOR)));
    }

}
