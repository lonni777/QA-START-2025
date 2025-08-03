package org.prog.session6;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before all");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-");
    }

    @Test(dataProvider = "providerName")
    public void test1(String value, String secondValue) {
        System.out.println("Hello " + value);
        System.out.println(secondValue);
    }

    @DataProvider
    public Object[][] providerName() {
        return new Object[][]{
                {"World1!", "1"},
                {"World2!", "Second value 2"},
                {"World3!", "Second value 3"},
                {"World4!", "Second value 4"},
                {"World5!", "Second value 5"},
                {"World6!", "Second value 6"},
                {"World7!", "Second value 7"},
        };
    }
}
