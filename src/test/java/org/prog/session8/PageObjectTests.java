package org.prog.session8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session8.page.GooglePage;
import org.prog.session8.page.W3SchoolsPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PageObjectTests {

    private WebDriver driver;
    private GooglePage googlePage;
    public W3SchoolsPage w3SchoolsPage;

    @BeforeSuite
    public void initWebDriver() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        w3SchoolsPage = new W3SchoolsPage(driver);
    }

    @Test
    public void myGoogleTest() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
        googlePage.searchForSomething();
    }

    @Test
    public void myIframeTest() {
        w3SchoolsPage.loadPage();
        w3SchoolsPage.acceptCookiesIfPresent();
        w3SchoolsPage.switchToResultFrame();
        w3SchoolsPage.findIframeButtonAndReturn();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
