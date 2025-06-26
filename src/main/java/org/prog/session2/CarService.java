package org.prog.session2;

//TODO: Add polish car step to painting process

public class CarService {

    private CarPainter vova = new CarPainter();
    private CarPainter sasha = new CarPainter();

    public void paintCar(Car2 carToPaint, String newCarColor) {
        vova.breakDuration = 5;
        sasha.breakDuration = 10;
        if ("black".equals(newCarColor)) {
            coffeeBreak(sasha);
            vova.prepareCarForPainting(carToPaint);

            coffeeBreak(vova);
            sasha.paintCar(carToPaint, newCarColor);
        } else {
            coffeeBreak(vova);
            sasha.prepareCarForPainting(carToPaint);

            coffeeBreak(sasha);
            vova.paintCar(carToPaint, newCarColor);
        }
    }

    private void coffeeBreak(CarPainter carPainter) {
        System.out.println("coffeBreak for " + carPainter.breakDuration);
    }

    public static void polishCar(Car2 car){
        System.out.println("Polishing " + car.color + " of car");
    }
}