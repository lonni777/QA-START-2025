package org.prog;

//TODO: Homework make goTo accept String as parameter and say "color car goes to destination"

public class Car {

    public String color;

    // Колір - властивjcns машин (Червоний,Синій)
    public Car(String color) {
        this.color = color;
    }

    // Метод про можливості машин
    public void goTo(String city) {
        System.out.println(color + " car is going " + city);
    }
}