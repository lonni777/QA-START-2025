package org.prog.session3.poly;

public class Renault implements ICar {

    @Override
    public void turn(String direction) {
        System.out.println("Renault turns " + direction);
    }

    @Override
    public void accelerate() {
        System.out.println("Renault accelerates?");
    }

    @Override
    public void brake() {
        System.out.println("Renault brakes!");
    }

    @Override
    public void drive() {
        System.out.println("Renault drive");
    }
}
