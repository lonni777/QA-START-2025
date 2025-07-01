package org.prog.session3;

import org.prog.session3.poly.BMW;
import org.prog.session3.poly.ICar;
import org.prog.session3.poly.Mazda;
import org.prog.session3.poly.Renault;

//TODO: Add interface ICamera for phones to take photos. Implement in Adnroid and iPhoine
//TODO: take two photos :)
// homework-3

public class Session3 {

    public static void driveTo(ICar mazda) {
        mazda.accelerate();
        mazda.turn("right");
        mazda.turn("left");
        mazda.turn("right");
        mazda.turn("left");
        mazda.accelerate();
        mazda.turn("right");
        mazda.turn("left");
        mazda.brake();
        mazda.brake();
    }

    public static void main(String[] args) {
        Mazda mazda = new Mazda();
        BMW bmw = new BMW();
        Renault r = new Renault();

        mazda.driveTo("Kyiv");
        System.out.println("===================================");
        mazda.driveTo("Lviv", "Odessa");
        System.out.println("===================================");
        mazda.driveTo("Lviv", "Odessa", "Dnipro");

//        driveTo(mazda);
//        System.out.println("==============================");
//        driveTo(bmw);
//        System.out.println("==============================");
//        driveTo(r);


//        Ford ford = new Ford();
//        CivilianCars civil = new CivilianCars();
//        MilitaryCars military = new MilitaryCars();
//        Lorry lorry = new Lorry();
//
//        ford.turn();
//        civil.turn();
//        military.turn();
//        lorry.turn();
//
//        ford.width = 10;
//        lorry.width = 20;
//        Motorcycle motorcycle = new Motorcycle();
//        military.width = 5;

//        org.prog.session1.Car car = new org.prog.session1.Car();
//        org.prog.session2.Car car2 = new org.prog.session2.Car();


    }


}
