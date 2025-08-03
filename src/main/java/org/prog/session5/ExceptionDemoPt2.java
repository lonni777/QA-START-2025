package org.prog.session5;

import org.prog.session1.Car;

import java.io.IOException;

public class ExceptionDemoPt2 {

    public static void main(String[] args) {
        System.out.println("---------------------");
        smth1(false);
        System.out.println("---------------------");
        smth1(true);
        System.out.println("---------------------");
    }

    public static void smth1(boolean err) {
        try {
            System.out.println("Before smth 2");
            smth2(err);
            System.out.println("After smth 2");
//        } catch (IndexOutOfBoundsException | ArithmeticException e) {
//            System.out.println("AR EXCEPTION HERE!");
//        } catch (RuntimeException e) {
//            System.out.println("RT IO EXCEPTION HERE!");
        } catch (Exception e) {
            System.out.println("EXCEPTION HERE!");
        } finally {
            System.out.println("this always runs");
        }
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
