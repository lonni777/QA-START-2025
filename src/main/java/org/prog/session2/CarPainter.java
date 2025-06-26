package org.prog.session2;

//TODO: 1 add method to polish cars
//TODO: 2. Polish method must print "polishing + color of car"

public class CarPainter {

    public int breakDuration;

    public void prepareCarForPainting(Car2 car) {
        car.color = null;
    }

    public void paintCar(Car2 car, String color) {
        if (color == null) {
            car.color = "red";
        } else {
            car.color = color;
        }
    }
}
