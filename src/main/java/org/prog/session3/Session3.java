package org.prog.session3;

import org.prog.session3.phones.AndroidPhone;
import org.prog.session3.phones.IPhone;
import org.prog.session3.poly.BMW;
import org.prog.session3.poly.ICar;
import org.prog.session3.poly.Mazda;
import org.prog.session3.poly.Renault;
//TODO: 1
//TODO: Add interface ICamera for phones to take photos. Implement in Adnroid and iPhoine
//TODO: take two photos :)

//TODO: 2
//TODO: write overloaded drive to to contain:
//TODO: - amount of passengers  def: 0
//TODO: - is payment for gas split def: no

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
        mazda.drive();
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
        System.out.println("===================================");
        mazda.driveTo("Kiev-Uzhorod", "Kiev", " with 5 passengers", " stopping in Lviv ", "and passengers is not payment for gas split");
        System.out.println("===================================");


        IPhone IPhone = new IPhone();
        AndroidPhone AndroidPhone = new AndroidPhone();

        AndroidPhone.takePhotos();
        IPhone.takePhotos();
        System.out.println("//==//==//==//==//==//==//==//==//");

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
