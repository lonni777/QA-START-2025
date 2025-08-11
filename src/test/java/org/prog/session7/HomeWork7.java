package org.prog.session7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;

//TODO: load allo.ua, search for iPhone (HomeWork-7-05.08.2025)

public class HomeWork7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void initWebDriver(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    @Test
    public void alloIphoneSearchTest() {
        driver.get("https://allo.ua/");

        try {
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Пошук товарів']")));

            searchField.clear();
            searchField.sendKeys("iPhone");
            searchField.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class, 'product-card') or contains(@class, 'goods-tile')]")));

            WebElement firstProduct = driver.findElement(By.xpath(
                    "(//div[contains(@class, 'product-card') or contains(@class, 'goods-tile')]//a)[1]"));

            firstProduct.click();

            System.out.println("load allo.ua, search for iPhone and click first phone");

            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}