package org.prog.session6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.prog.session2.Car2;
import org.prog.session2.CarService;

import java.util.Random;
import java.util.stream.Stream;

public class JunitTests {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("------------------------");
    }

    @AfterEach
    public void setUp() {
        System.out.println("=======================");
    }

    @ParameterizedTest
//    @ValueSource(strings = {"red", "blue", "black"})
    @MethodSource("argumentsStream")
    public void test1(String color) {
        Car2 car = new Car2();
        CarService carService = new CarService();
        car.color = "red";
        carService.paintCar(car, color);
        Assertions.assertEquals(color, car.color, "Car color should be " + color);
    }

    @ParameterizedTest
//    @ValueSource(strings = {"red", "blue", "black"})
    @MethodSource("argumentsStream")
    public void test2(String color) {
        Car2 car = new Car2();
        CarService carService = new CarService();
        car.color = "red";
        carService.paintCar(car, color);
        Assertions.assertEquals(color, car.color, "Car color should be " + color);
    }

    @ParameterizedTest
//    @ValueSource(strings = {"red", "blue", "black"})
    @MethodSource("argumentsStream")
    public void test3(String color) {
        Car2 car = new Car2();
        CarService carService = new CarService();
        car.color = "red";
        carService.paintCar(car, color);
        Assertions.assertEquals(color, car.color, "Car color should be " + color);
    }

    public static Stream<Arguments> argumentsStream() {

        return Stream.of(
                Arguments.of(randomColor(), "asdasd"),
                Arguments.of(randomColor(), 123123, "asdasdasd"),
                Arguments.of(randomColor())
        );
    }

    public static String randomColor() {
        Random random = new Random();
        return switch (random.nextInt(5)) {
            case 0 -> "red";
            case 1 -> "green";
            case 2 -> "blue";
            case 3 -> "yellow";
            case 4 -> "pink";
            default -> "black";
        };
    }
}