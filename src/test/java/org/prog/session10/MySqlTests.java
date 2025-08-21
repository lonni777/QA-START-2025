package org.prog.session10;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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

        // Option 1: Add City, Street, House Number columns to Persons table
        addAddressColumnsToPersonsTable();
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    // Option 1: Add to database City, Street, House Number columns to Persons
    private void addAddressColumnsToPersonsTable() throws SQLException {
        Statement statement = connection.createStatement();

        try {
            // Try to add columns if they don't exist
            statement.execute("ALTER TABLE Persons ADD COLUMN City VARCHAR(100)");
            statement.execute("ALTER TABLE Persons ADD COLUMN Street VARCHAR(100)");
            statement.execute("ALTER TABLE Persons ADD COLUMN HouseNumber VARCHAR(20)");
            System.out.println("Address columns added to Persons table");
        } catch (SQLException e) {
            // Columns might already exist, create table if it doesn't exist
            statement.execute("CREATE TABLE IF NOT EXISTS Persons (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "FirstName VARCHAR(50), " +
                    "LastName VARCHAR(50), " +
                    "Gender VARCHAR(10), " +
                    "Title VARCHAR(10), " +
                    "Nat VARCHAR(10), " +
                    "City VARCHAR(100), " +
                    "Street VARCHAR(100), " +
                    "HouseNumber VARCHAR(20)" +
                    ")");
            System.out.println("Persons table created with address columns");
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

    // Option 1: Write that data from API to DB (including address data)
    @Test
    public void testWriteToDBFromAPIWithAddress() throws SQLException, ClassNotFoundException {
        ResultsDto resultsDto = getUsersWithAddress(3);
        List<PersonDto> personDtos = resultsDto.getResults();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat, City, Street, HouseNumber) VALUES (?,?,?,?,?,?,?,?)"
        );

        personDtos.forEach(dto -> executeStatementWithAddress(dto, preparedStatement));
        System.out.println("Successfully inserted " + personDtos.size() + " persons with address data");
    }

    // Option 1: Print City, Street and House number for each person in BD
    @Test
    public void printCityStreetHouseNumberForEachPerson() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT FirstName, LastName, City, Street, HouseNumber FROM Persons WHERE City IS NOT NULL");

        System.out.println("=== City, Street and House number for each person in BD ===");
        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String city = resultSet.getString("City");
            String street = resultSet.getString("Street");
            String houseNumber = resultSet.getString("HouseNumber");

            System.out.println(String.format("%s %s - City: %s, Street: %s, House Number: %s",
                    firstName, lastName, city, street, houseNumber));
        }
        System.out.println("============================================================");
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

    // Option 1: Execute statement with address data
    private void executeStatementWithAddress(PersonDto dto, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, dto.getName().getFirst());
            preparedStatement.setString(2, dto.getName().getLast());
            preparedStatement.setString(3, dto.getGender());
            preparedStatement.setString(4, dto.getName().getTitle());
            preparedStatement.setString(5, dto.getNat());

            // Extract address information from API response
            if (dto.getLocation() != null) {
                preparedStatement.setString(6, dto.getLocation().getCity());
                preparedStatement.setString(7, dto.getLocation().getStreet().getName());
                preparedStatement.setString(8, String.valueOf(dto.getLocation().getStreet().getNumber()));
            } else {
                preparedStatement.setString(6, "Unknown");
                preparedStatement.setString(7, "Unknown");
                preparedStatement.setString(8, "0");
            }

            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error inserting person with address: " + dto);
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

    // Option 1: Get users with address data from API
    private ResultsDto getUsersWithAddress(int amount) {
        Response response = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("api/")
                .queryParam("inc", "gender,name,nat,location")
                .queryParam("results", amount)
                .queryParam("noinfo")
                .get();
        response.prettyPrint();
        return response.as(ResultsDto.class);
    }
}