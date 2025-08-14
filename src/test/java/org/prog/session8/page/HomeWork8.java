package org.prog.session8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork8 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void initWebDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void alloIphonePriceCheck() {
        try {
            driver.get("https://allo.ua/");
            System.out.println("Сайт allo.ua успішно завантажено");

            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@placeholder='Пошук товарів' or @placeholder='Поиск товаров']")));
            searchField.clear();
            searchField.sendKeys("iPhone 16");
            searchField.sendKeys(Keys.ENTER);
            System.out.println("Смартфон iPhone 16 успішно знайдено");

            WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//div[contains(@class, 'product-card') or contains(@class, 'goods-tile')])[1]")));

            WebElement priceNumberEl = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                    firstProduct, By.xpath(".//span[contains(@class,'sum')]")));
            String priceNumber = priceNumberEl.getText().trim();

            WebElement currencyEl = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                    firstProduct, By.xpath(".//span[contains(@class,'currency')]")));
            String currency = currencyEl.getText().trim();

            System.out.println("Ціна першого товару: " + priceNumber);
            System.out.println("Валюта: " + currency);

            Assert.assertFalse(priceNumber.isEmpty(), "Ціна першого товару порожня");

            Assert.assertEquals(currency, "₴", "Символ валюти не збігається з ₴");

            System.out.println("✓ Тест пройшов успішно — знайдено ціну та правильний символ ₴");

            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Помилка під час виконання тесту: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Тест провалився через помилку: " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
