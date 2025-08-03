package org.prog.session7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//TODO: load allo.ua, search for iPhone

public class WebTest {

    private WebDriver driver;

    @BeforeSuite
    public void initWebDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void myGoogleTest() {
        driver.get("https://www.google.com");

        WebElement cookiesLink = driver.findElement(By.xpath(
                "//a[contains(@href, 'technologies/cookies')]"));
        if (cookiesLink != null && cookiesLink.isDisplayed()) {
            driver.findElements(By.tagName("button")).get(4).click();
        }

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Ben Affleck");
        search.sendKeys(Keys.ENTER);
        driver.quit();
    }

    @Test
    public void myIframeTest() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
        driver.findElement(By.id("accept-choices")).click();

        System.out.println("Run Button state: " +
                driver.findElement(By.id("runbtn")).isDisplayed());

        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);

        WebElement innerBtn = driver.findElement(By.xpath("//button[@type='button']"));
        System.out.println("innerBtn sstate: " + innerBtn.isDisplayed());

        driver.switchTo().defaultContent();

        System.out.println("Run Button state: " +
                driver.findElement(By.id("runbtn")).isDisplayed());
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
