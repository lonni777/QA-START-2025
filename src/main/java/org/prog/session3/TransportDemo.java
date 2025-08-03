package org.prog.session3;

public class TransportDemo {

    public static void main(String[] args) {
        Train t = new Train();
        Plane p = new Plane();
        Boat boat = new Boat();

        transport(t, 10);
        transport(p, 100);
        transport(boat, 1);
    }

    public static void transport(ITransport transport, int passengers) {
        transport.transport(passengers);
    }
}
