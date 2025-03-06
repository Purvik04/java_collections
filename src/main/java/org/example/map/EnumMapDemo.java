package org.example.map;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {

        //EnumMap is a specialized Map implementation designed for use with enum type keys
        //EnumMap is not synchronized
        //EnumMap does not allow null keys
        //EnumMap is faster than HashMap
        //no hashing and collision rehashing
        //oridnal() method is used to get the index of the key in the array of EnumMap
        Map<Day, String> map = new EnumMap<>(Day.class);

        map.put(Day.TUESDAY, "1");
        map.put(Day.WEDNESDAY, "2");
        map.put(Day.MONDAY, "0");
//        map.put(null, "null"); //NullPointerException
        System.out.println(map);
    }
}

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}