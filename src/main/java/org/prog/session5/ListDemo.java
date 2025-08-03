package org.prog.session5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new LinkedList<>();


        // [a,b,c,d,e,f,g]
        //       ^
        // g 6 -> 7
        // f 5 -> 6
        // e 4 -> 5

        // [a,b,c,d,e,f,g]
        //       ^
        // c : new neighbour!
        // d : new neighbour!
        // h : meet c and d!

    }
}
