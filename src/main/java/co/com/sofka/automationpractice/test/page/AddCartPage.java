package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage {

    @FindBy(css = "#homefeatured > .ajax_block_product:nth-child(1) .replace-2x")
    WebElement productOne;

    @FindBy(css = "#homefeatured > .ajax_block_product:nth-child(2) .replace-2x")
    WebElement productTwo;

    @FindBy(id = "add_to_cart")
    WebElement btnAddToCart;

    @FindBy(css = ".button-medium > span")
    WebElement proceedToCheckout;

    @FindBy(css = ".icon-home")
    WebElement home;

    @FindBy(id = "layer_cart_product_price")
    WebElement price;



    public WebElement getProductOne() {
        return productOne;
    }

    public WebElement getProductTwo() {
        return productTwo;
    }

    public WebElement getBtnAddToCart() {
        return btnAddToCart;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WebElement getHome() {
        return home;
    }

    public WebElement getPrice() {
        return price;
    }

    public AddCartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


}
