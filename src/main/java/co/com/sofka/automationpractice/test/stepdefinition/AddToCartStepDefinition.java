package co.com.sofka.automationpractice.test.stepdefinition;

import co.com.sofka.automationpractice.test.controllers.AddCartWebController;
import co.com.sofka.automationpractice.test.controllers.CreateAnAccountWebController;
import co.com.sofka.automationpractice.test.controllers.LoginPageWebController;
import co.com.sofka.automationpractice.test.controllers.ShoppingCartSummaryController;
import co.com.sofka.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.automationpractice.test.helpers.TestInfo;
import co.com.sofka.automationpractice.test.models.Prices;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddToCartStepDefinition extends SetupStepDefinition{
    private WebAction webAction;

    private Prices prices;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Given("El usuario ingresa a la página automationpractice y va a sign in y crea un usuario con los datos solicitados y va home a para escoger los productos")
    public void elUsuarioIngresaALaPaginaAutomationpracticeYVaASignInYCreaUnUsuarioConLosDatosSolicitados() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.openOnlineStore();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.goToPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.createAccount();

        createAnAccountWebController.goTheHome();
    }

    @When("El usuario escoge dos productos de su interés y los añade al carrito de compras.")
    public void elUsuarioEscogeDosProductosDeSuInteres() {
        AddCartWebController addCartWebController = new AddCartWebController();
        addCartWebController.setWebAction(webAction);
        addCartWebController.selectProductone();
        addCartWebController.selectProductTwo();
        prices=addCartWebController.getPrices();
    }
    @Then("En el resumen de la lista de compras debe coincidir los valores de la suma de los productos más el envió con el que proporciona la página.")
    public void laPaginaMostraraLosDosProductosConSuValor() {
        ShoppingCartSummaryController shoppingCartSummaryController= new ShoppingCartSummaryController();
        shoppingCartSummaryController.setWebAction(webAction);
         Assert.Hard
                .thatString(shoppingCartSummaryController.totalCalculatedPrice(prices))
                .isEqualTo(shoppingCartSummaryController.getFullPrice());
    }

    @After
    public void cerrarDriver() throws InterruptedException {
        Thread.sleep(2000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }

}
