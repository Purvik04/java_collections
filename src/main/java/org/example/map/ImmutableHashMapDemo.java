package org.example.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableHashMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("John", 100);
        map.put("Doe",200);

        Map<String,Integer> map2 = Collections.unmodifiableMap(map); // this is immutable map
        //map2.put("Alex", 300); // this will throw UnsupportedOperationException

        //java 9 onwards limited entries can be added in the map (10 entries)
        Map<String,Integer> map3 = Map.of("John", 100, "Doe", 200, "Alex", 300); // this is also immutable map
        // map3.put("Smith", 400); // this will throw UnsupportedOperationException

        //more than 10 entries

        //where constants are defined
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("John", 100), Map.entry("Doe", 200));// this is also immutable map


    }
}
