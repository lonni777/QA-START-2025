package org.prog.session3;

public class Plane implements ITransport {


    @Override
    public void transport(int passengers) {
        System.out.println("Plane flies with " + passengers + " passengers");
    }
}
