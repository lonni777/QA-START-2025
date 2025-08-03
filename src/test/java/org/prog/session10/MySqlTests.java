package org.prog.session10;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.prog.session11.steps.RestSteps;
import org.prog.session9.PersonDto;
import org.prog.session9.ResultsDto;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

//TODO: Option 1 - add to database City, Street, House Number columnts to Persons
//TODO: Option 1 - write that data from API to DB
//TODO: Option 1 - print City, Street and House number for each person in BD

//TODO: Option 2 - Create table with phone name and price for this model
//TODO: Option 2 - Load allo.ua, search for Iphone, and store its price to DB

public class MySqlTests {

    private Connection connection;

    @BeforeSuite
    public void beforeSuite() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testWriteToDB() throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                "VALUES ('Bill', 'Smith', 'male', 'Mr', 'US')");
    }

    @Test
    public void testReadFromDB() throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("FirstName") + " ");
            System.out.println(resultSet.getString("LastName"));
        }
    }

    @Test
    public void testWriteToDBFromAPI() throws SQLException, ClassNotFoundException {
        ResultsDto resultsDto = getUsers(3);
        List<PersonDto> personDtos = resultsDto.getResults();
//            Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES (?,?,?,?,?)"
        );

        personDtos.forEach(dto -> executeStatement(dto, preparedStatement));

//            for (PersonDto personDto : personDtos) {
//                executeStatement(personDto, preparedStatement);
//            }

//            for (PersonDto personDto : personDtos) {
//                try {
//                    statement.execute("INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
//                            "VALUES ('" + personDto.getName().getFirst() +
//                            "', '" + personDto.getName().getLast() +
//                            "', '" + personDto.getGender() +
//                            "', '" + personDto.getName().getTitle() +
//                            "', '" + personDto.getNat() +
//                            "')");
//                } catch (Exception e) {
//                    System.out.println("Failed to store " + personDto.getName());
//                }
//            }
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

    private ResultsDto getUsers(int amount) {
        Response respones = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("api/")
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", amount)
                .queryParam("noinfo")
                .get();
        respones.prettyPrint();
        return respones.as(ResultsDto.class);
    }
}
