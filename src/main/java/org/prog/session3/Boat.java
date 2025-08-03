package org.prog.session3;

public class Boat implements ITransport {
    @Override
    public void transport(int passengers) {
        System.out.println("Boat sails with " + passengers + " passengers");
    }
}
