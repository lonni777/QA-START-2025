package org.prog.session5;

import java.util.*;

//TODO: write Map with car owners as keys and owned cars as values
//TODO: assign each car random color using randomColor() from this class

public class MapDemo {

    public static void main(String[] args) {
        // tax id, each tax id can have 1-5 FOPs
        Map<String, List<String>> map = new HashMap<>();
        map.put("17253761525", new ArrayList<>());

        map.get("17253761525").add("FOP #1");
        map.get("17253761525").add("FOP #2");
        map.get("17253761525").add("FOP #3");
        map.get("17253761525").add("FOP #4");

        List<String> list1 = map.get("17253761525");

        for (String someString : list1) {
            System.out.println("Citizen 17253761525 has : " + someString);
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
}
