package org.prog.session8.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3SchoolsPage {

    private final WebDriver driver;

    public W3SchoolsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
    }

    public void acceptCookiesIfPresent() {
        driver.findElement(By.id("accept-choices")).click();
    }

    public void switchToResultFrame(){
        driver.switchTo().frame(getResultsFrame());
    }

    public void findIframeButtonAndReturn(){
        WebElement innerBtn = driver.findElement(By.xpath("//button[@type='button']"));
        System.out.println("innerBtn state: " + innerBtn.isDisplayed());
        driver.switchTo().defaultContent();
    }

    private WebElement getResultsFrame(){
        return driver.findElement(By.id("iframeResult"));
    }
}
