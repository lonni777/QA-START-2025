package org.prog.session3.poly;

public class BMW implements ICar {

    @Override
    public void turn(String direction) {
        System.out.println("BMW turns " + direction + " without signaling");
    }

    @Override
    public void accelerate() {
        System.out.println("BMW accelerates");
    }

    @Override
    public void brake() {
        System.out.println("BMW never brakes");
    }

    @Override
    public void drive() {
        System.out.println("BMW drive");
    }
}
