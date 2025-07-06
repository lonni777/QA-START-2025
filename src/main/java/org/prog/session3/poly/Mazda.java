package org.prog.session3.poly;

//TODO: write overloaded drive to to contain:
//TODO: - amount of passengers  def: 0
//TODO: - is payment for gas split def: no

public class Mazda implements ICar {

    public void driveTo(String destination, String from, String addPassegers, String stoppingAt, String payToGas ){
       System.out.println("Mazda drive from " + from + addPassegers + stoppingAt + payToGas + stoppingAt);
    }

    public void driveTo(String destination) {
        driveTo(destination, "here and now");
    }

    public void driveTo(String destination, String from) {
        driveTo(destination, from, "nowhere");
    }

    public void driveTo(String destination, String from, String stoppingAt) {
        System.out.println("Mazada drives from " + from + " to " + destination);
        System.out.println("Mazada stopping at " + stoppingAt);
    }

    public void manualGearSwitch(int gear) {
        System.out.println("Switch to " + gear);
    }

    @Override
    public void turn(String direction) {
        System.out.println("Mazda turns " + direction);
    }

    @Override
    public void accelerate() {
        System.out.println("Mazda accelerates");
    }

    @Override
    public void brake() {
        System.out.println("Mazda brakes");
    }

    @Override
    public void drive() {System.out.println("Mazda drive to to contain");}
}
