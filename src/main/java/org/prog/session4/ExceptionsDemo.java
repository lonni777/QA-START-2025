package org.prog.session4;

public class ExceptionsDemo {
    public static int counter = 0;

    public static void main(String[] args) {
        System.out.println("---------------------");
        smth1(false);
        System.out.println("---------------------");
        smth1(true);
        System.out.println("---------------------");
    }

    public static void smth1(boolean err) {
        smth2(err);
    }

    public static void smth2(boolean err) {
        smth3(err);
    }

    public static void smth3(boolean err) {
        smth4(err);
    }

    public static void smth4(boolean err) {
        if (err) {
            throw new RuntimeException();
        } else {
            System.out.println("No error this time!");
        }
    }
}
