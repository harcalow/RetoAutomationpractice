package co.com.sofka.automationpractice.test.models;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.SHIPPINGVALUE;

public class Prices {
    private String priceProductOne;
    private String priceProductTwo;
    private String totalShipping=SHIPPINGVALUE;

    public String getPriceProductOne() {
        return priceProductOne;
    }

    public void setPriceProductOne(String priceProductOne) {
        this.priceProductOne = priceProductOne;
    }

    public String getPriceProductTwo() {
        return priceProductTwo;
    }

    public void setPriceProductTwo(String priceProductTwo) {
        this.priceProductTwo = priceProductTwo;
    }

    public String getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(String totalShipping) {
        this.totalShipping = totalShipping;
    }
}
