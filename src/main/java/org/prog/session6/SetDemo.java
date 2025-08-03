package org.prog.session6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set.size());
    }
}
