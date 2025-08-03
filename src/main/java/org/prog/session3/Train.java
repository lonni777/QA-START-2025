package org.prog.session3;

public class Train implements ITransport{
    @Override
    public void transport(int passengers) {
        System.out.println("Train ride with " + passengers + " passengers");
    }
}
