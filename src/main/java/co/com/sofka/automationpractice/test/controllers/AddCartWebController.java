package co.com.sofka.automationpractice.test.controllers;


import co.com.sofka.automationpractice.test.models.Prices;
import co.com.sofka.automationpractice.test.page.AddCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class AddCartWebController {

    private WebAction webAction;
    private final Prices prices=new Prices();
    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }
    public Prices getPrices() {
        return prices;
    }
    public void selectProductone() {
        try {
            AddCartPage addCartPage = new AddCartPage(webAction.getDriver());
            webAction.clickJS(addCartPage.getProductOne(), true);
            webAction.click(addCartPage.getBtnAddToCart(),5 ,true);
            prices.setPriceProductOne(webAction.getText(addCartPage.getPrice(),true));
            webAction.click(addCartPage.getProceedToCheckout(),5, true);
            webAction.click(addCartPage.getHome(),5, true);

        }catch (WebActionsException e){
            Report.reportFailure("No es posible seleccionar el producto", e);
        }
    }

    public void selectProductTwo() {
        try {
            AddCartPage addCartPage = new AddCartPage(webAction.getDriver());
            webAction.clickJS(addCartPage.getProductTwo(), true);
            webAction.click(addCartPage.getBtnAddToCart(),5 ,true);
            prices.setPriceProductTwo(webAction.getText(addCartPage.getPrice(),true));
            webAction.click(addCartPage.getProceedToCheckout(),5, true);
        }catch (WebActionsException e){
            Report.reportFailure("No es posible seleccionar el producto", e);
        }
    }




}
