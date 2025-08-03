package org.prog.session11;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session11.steps.DBSteps;
import org.prog.session11.steps.WebSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.prog.session11.steps"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() throws ClassNotFoundException, SQLException {
        WebSteps.driver = new ChromeDriver();
        Class.forName("com.mysql.cj.jdbc.Driver");
        DBSteps.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        if (WebSteps.driver != null) {
            WebSteps.driver.quit();
        }
        if (DBSteps.connection != null) {
            DBSteps.connection.close();
        }
    }
}
