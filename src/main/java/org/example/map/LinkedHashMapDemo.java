package org.example.map;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //insertion oder is maintained if access order argument is flase and by default it is false
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(10, 0.75f);

        linkedHashMap.put("John", 100);
        linkedHashMap.put("Doe", 200);
        linkedHashMap.put("Alex", 300);
        linkedHashMap.put("Smith", 400);

        System.out.println(linkedHashMap);

        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(10, 0.75f, true);
        linkedHashMap1.put("John", 100);
        linkedHashMap1.put("Doe", 200);
        linkedHashMap1.put("Alex", 300);

        System.out.println(linkedHashMap1);

        linkedHashMap1.get("Doe"); //Doe will be moved to the Like LRU cache because of access order is true
        linkedHashMap1.get("John"); //John will be moved to the Like LRU cache because of access order is true
        System.out.println(linkedHashMap1);

    }
}
