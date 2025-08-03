package org.prog.session8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class SeleniumWaitTests {

    private WebDriver driver;

    @BeforeSuite
    public void initWebDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void myCloudFlareTest() {
        driver.get("https://www.cloudflare.com/");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        webDriverWait.pollingEvery(Duration.ofSeconds(1L))
//                .ignoring(ElementNotInteractableException.class)
//                .withMessage("Cannot find element");

        WebElement acceptBtn = webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(acceptBtn));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", acceptBtn);

        Actions actions = new Actions(driver);
        actions.doubleClick();

        System.out.println("done!");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
