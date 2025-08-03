package org.prog.session11.steps;

import io.cucumber.java.en.Given;
import org.prog.session11.DataHolder;
import org.prog.session9.PersonDto;
import org.prog.session9.ResultsDto;
import org.testng.Assert;

import java.sql.*;
import java.util.List;

public class DBSteps {

    public static Connection connection;

    @Given("I store {string} in database")
    public void storePersonsToDB(String alias) throws SQLException {
        ResultsDto resultsDto = (ResultsDto) DataHolder.DATA.get(alias);
        List<PersonDto> personDtos = resultsDto.getResults();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES (?,?,?,?,?)"
        );
        personDtos.forEach(dto -> executeStatement(dto, preparedStatement));
    }

    @Given("I pick a single random person from DB as {string}")
    public void pickRandomPersonFromDB(String alias) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
        if (resultSet.next()) {
            DataHolder.DATA.put(alias,
                    resultSet.getString("FirstName") + " " +
                            resultSet.getString("LastName"));
        } else {
            Assert.fail("No records found");
        }
    }

    private void executeStatement(PersonDto dto, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, dto.getName().getFirst());
            preparedStatement.setString(2, dto.getName().getLast());
            preparedStatement.setString(3, dto.getGender());
            preparedStatement.setString(4, dto.getName().getTitle());
            preparedStatement.setString(5, dto.getNat());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error inserting person: " + dto);
        }
    }
}
