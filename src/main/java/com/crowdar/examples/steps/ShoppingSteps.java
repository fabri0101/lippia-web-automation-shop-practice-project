package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.ShopConfirmPage;
import com.crowdar.examples.pages.ShopProductSelect;
import com.crowdar.examples.pages.ShopResultPage;
import com.crowdar.examples.pages.StoreHomePage;
import io.cucumber.java.en.*;


public class ShoppingSteps extends PageSteps {

    //PRIMER ESCENARIO//////////////////////////////////////////////////////////////////////////////////////////

    @Given("el cliente hace click en el buscador de productos")
    public void elClienteHaceClickEnElBuscadorDeProductos() {
        Injector._page(StoreHomePage.class).go();
    }

    @When("el cliente ingresa un (.*) en el buscador")
    public void elClienteIngresaUnProductoEnElBuscador(String busqueda) {
        Injector._page(StoreHomePage.class).enterSearch(busqueda);
    }

    @Then("el cliente verifica que es redireccionado a la pantalla de resultados")
    public void elClienteVerificaQueEsRedireccionadoALaPantallaDeResultados() {
        Injector._page(ShopResultPage.class).verifyShopResultPage();
    }

    //SEGUNDO ESCENARIO//////////////////////////////////////////////////////////////////////////////////////////

    @Given("el cliente se encuentra en la pantalla de resultados")
    public void elClienteSeEncuentraEnLaPantallaDeResultados() {
        Injector._page(ShopResultPage.class).go();
    }

    @When("el cliente hace click en un producto")
    public void elClienteHaceClickEnUnProducto() {
        Injector._page(ShopResultPage.class).selectProduct();

    }

    @Then("el cliente es redireccionado al producto que selecciono")
    public void ElClienteEsRedireccionadoAlProductoQueSelecciono() {
        //Injector._page(ShopProductSelect.class).verifyShopProduct();
        Injector._page(ShopProductSelect.class).verifyShopProduct2();
    }

    //TERCER ESCENARIO//////////////////////////////////////////////////////////////////////////////////////////

    @Given("el cliente se encuentra en la pantalla del producto que selecciono")
    public void elClienteSeEncuentraEnLaPantallaDelProductoQueSelecciono() {

        Injector._page(ShopProductSelect.class).go();
    }

    @When("elige la (.*) de productos")
    public void eligeLaCantidadDeProductos(String cantidad) {

        Injector._page(ShopProductSelect.class).selectQuantity(cantidad);
    }

    @And("selecciona el (.*)")
    public void seleccionaElTalle(String talle) {

        Injector._page(ShopProductSelect.class).selectSize(talle);
    }

    @And("elige un (.*)")
    public void eligeUnColor(String color) {

        Injector._page(ShopProductSelect.class).selectColor(color);
    }

    @And("hace click en el boton add to cart")
    public void haceClickEnElBotonAddToCart() {

        Injector._page(ShopProductSelect.class).addToCart();
    }

    @And("hace click en proceed to checkout")
    public void haceClickEnProceedToCheckout() {

        Injector._page(ShopProductSelect.class).proceedToCheckout();
    }

    @Then("el cliente es redireccionado a la pantalla del carrito de compras")
    public void elClienteEsRedireccionadoALaPantallaDelCarritoDeCompras() {

        Injector._page(ShopConfirmPage.class).verifyShopConfirmPage();
    }

    //CUARTO ESCENARIO/////////////////////////////////////////////////////////////////////////////////////////

    @Given("el cliente se encuentra en el carrito de compras")
    public void elClienteSeEncuentraEnElCarritoDeCompras() {

        Injector._page(ShopProductSelect.class).go();
        Injector._page(ShopProductSelect.class).selectQuantity("1");
        Injector._page(ShopProductSelect.class).selectSize("M");
        Injector._page(ShopProductSelect.class).selectColor("color_14");
        Injector._page(ShopProductSelect.class).addToCart();
        Injector._page(ShopProductSelect.class).proceedToCheckout();
        Injector._page(ShopConfirmPage.class).verifyShopConfirmPage();
    }

    @When("el cliente se encuentra en el summary y hace click en proceed to checkout")
    public void elClienteSeEncuentraEnElSummaryYHaceClickEnProceedToCheckout() {

        Injector._page(ShopConfirmPage.class).summary();
    }

    @And("el cliente inicio sesion con (.*) y (.*) y hace click en sing in")
    public void ElClienteInicioSesionConEmailYPassYHaceClickEnSingIn(String email, String pass) {

        Injector._page(ShopConfirmPage.class).singIn(email, pass);
    }

    @And("el cliente se encuentra en address y hace click en proceed to checkout")
    public void elClienteSeEncuentraEnAddressYHaceClickEnProceedToCheckout() {

        Injector._page(ShopConfirmPage.class).address();
    }

    @And("el cliente se encuentra en shipping y acepta los terminos de servicio y hace click en proceed to checkout")
    public void elClienteSeEncuentraEnShippingYAceptaLosTerminosDeServicioYHaceClickEnProceedToCheckout() {

        Injector._page(ShopConfirmPage.class).checkbox();
        Injector._page(ShopConfirmPage.class).shipping();
    }

    @And("el cliente se encuentra en payment y elige la forma de pago")
    public void elClienteSeEncuentraEnPaymentYEligeLaFormaDePago() {

        Injector._page(ShopConfirmPage.class).payment();
    }

    @Then("el cliente confirma la compra haciendo click en I confirm my order")
    public void elClienteConfirmaLaCompraHaciendoClickEnIConfirmMyOrder() {

        Injector._page(ShopConfirmPage.class).confirmOrder();
    }

}
