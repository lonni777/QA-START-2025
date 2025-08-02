package org.prog.session1;

import org.w3c.dom.css.CSSStyleRule;

//TODO: HW4: add String model and make equals & hashCode work by model and color
// Homework-4 2
public class Car {

    public String color;
    public String model;

    public void goTo() {
        System.out.println(color + " car is going somewhere");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.color.equals(car.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public String toString() {
        return "Car : " + color;
    }

    public String getColor() {
        return color;
    }
}