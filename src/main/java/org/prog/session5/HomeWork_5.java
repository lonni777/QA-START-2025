import java.util.*;

//TODO: write Map with car owners as keys and owned cars as values
//TODO: assign each car random color using randomColor() from this class

public class HomeWork_5 {

    public static void main(String[] args) {
        Map<String, List<Car>> ownerCarsMap = new HashMap<>();

        ownerCarsMap.put("Ilona", new ArrayList<>());
        ownerCarsMap.put("Nika", new ArrayList<>());
        ownerCarsMap.put("Kira", new ArrayList<>());
        ownerCarsMap.put("Diana", new ArrayList<>());

        ownerCarsMap.get("Ilona").add(new Car("Toyota", randomColor()));
        ownerCarsMap.get("Ilona").add(new Car("BMW", randomColor()));
        ownerCarsMap.get("Nika").add(new Car("Honda", randomColor()));
        ownerCarsMap.get("Nika").add(new Car("Mercedes", randomColor()));
        ownerCarsMap.get("Kira").add(new Car("Audi", randomColor()));
        ownerCarsMap.get("Kira").add(new Car("Volkswagen", randomColor()));
        ownerCarsMap.get("Diana").add(new Car("Ford", randomColor()));
        ownerCarsMap.get("Diana").add(new Car("Nissan", randomColor()));

        for (Map.Entry<String, List<Car>> entry : ownerCarsMap.entrySet()) {
            String owner = entry.getKey();
            List<Car> cars = entry.getValue();

            for (Car car : cars) {
                System.out.println("Owner " + owner + " has: " + car.color + " " + car.model);
                System.out.println("--------------------------------------------------------");
            }
        }
    }

    public static String randomColor() {
        Random random = new Random();
        return switch (random.nextInt(5)) {
            case 0 -> "red";
            case 1 -> "green";
            case 2 -> "blue";
            case 3 -> "yellow";
            case 4 -> "pink";
            default -> "black";
        };
    }

    static class Car {
        String model;
        String color;

        Car(String model, String color) {
            this.model = model;
            this.color = color;
        }
    }
}