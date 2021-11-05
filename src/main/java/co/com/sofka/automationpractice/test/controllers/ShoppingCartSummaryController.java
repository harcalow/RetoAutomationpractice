package co.com.sofka.automationpractice.test.controllers;

import co.com.sofka.automationpractice.test.models.Prices;
import co.com.sofka.automationpractice.test.page.ShoppingCartSummaryPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingCartSummaryController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }


    public String totalCalculatedPrice(Prices price){
        double priceProductOne = Double.parseDouble(price.getPriceProductOne().replace("$", ""));
        double priceProductTwo = Double.parseDouble(price.getPriceProductTwo().replace("$", ""));
        double totalShipping = Double.parseDouble(price.getTotalShipping());
        double total = priceProductOne + priceProductTwo + totalShipping;
        total =Math.round(total *100.0)/100.0 ;
        return "$"+ total;
    }

    public String getFullPrice(){

        String totalPrice = "";
        try{
            ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(webAction.getDriver());
            totalPrice=webAction.getText(shoppingCartSummaryPage.getTotalPrice(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar tomar el valor total", e);
        }
        return totalPrice;
    }


}
