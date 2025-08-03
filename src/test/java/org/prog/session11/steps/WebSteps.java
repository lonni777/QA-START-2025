package org.prog.session11.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.prog.session11.DataHolder;
import org.prog.session8.page.GooglePage;
import org.testng.Assert;

public class WebSteps {

    public static WebDriver driver;
    private GooglePage googlePage = new GooglePage(driver);

    @Given("I load google page")
    public void iLoadGooglePage() {
        googlePage.loadPage();
    }

    @Given("I accept cookies if they are present")
    public void iAcceptCookiesIfTheyArePresent() {
        if (googlePage.isCookiesPresent()) {
            googlePage.acceptCookiesIfPresent();
        }
    }


    @When("I set search to {string}")
    public void iSetSearchToRandomPersonsName(String alias) {
        if (DataHolder.DATA.containsKey(alias)) {
            googlePage.setSearchFieldValue((String) DataHolder.DATA.get(alias));
        } else {
            googlePage.setSearchFieldValue(alias);
        }
    }

    @Then("Search field contains {string}")
    public void searchFieldContainsRandomPersonsName(String alias) {
        Assert.assertEquals(
                googlePage.getSearchFieldValue(),
                DataHolder.DATA.get(alias),
                "Search field expected to contain random persons name");
    }
}
