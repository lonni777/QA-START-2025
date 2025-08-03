package org.prog.session1;

public class ComparisonDemo {

    public static void main(String[] args) {
        Car myCar = new Car();
        Car bobsCar = new Car();
        Car aliceCar = new Car();
        Car thatCar = myCar;

        myCar.color = "red";
        bobsCar.color = "red";
        aliceCar.color = "red";

        Car[] cars1 = new Car[3];
        Car[] cars2 = new Car[3];

        cars1[0] = myCar;
        cars1[1] = bobsCar;

        cars2[0] = thatCar;
        cars2[1] = aliceCar;
        System.out.println(cars1[0] == cars2[0]);
    }
}
