package org.prog.session1;

//TODO: Add second car, make it blue, make red car got to Kyiv, blue car go to Odessa
public class AutomationSession1 {

    public static void main(String[] args) {
        Actor leadActor = new Actor();
        Actor supportActor = new Actor();

        leadActor.name = "Michael Brown";
        supportActor.name = "Jane Brown";

        leadActor.say("Hello, my name is Michael Brown");
        supportActor.say("Hello, my name is Jane Brown");

        leadActor.say("This is my first concert");
        supportActor.say("This is my second concert");

        leadActor.walkTo("edge of scene");
        supportActor.walkTo("edge of scene");

        Car car = new Car();
        car.color = "red";
        car.model ="";
    }
}
