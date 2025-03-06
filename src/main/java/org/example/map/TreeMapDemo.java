package org.example.map;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        //SortedMap is the interface and TreeMap is the class
        //TreeMap is sorted by key and it is not thread safe
        SortedMap<Integer, String> sortedMap = new TreeMap<>((a, b) -> b - a);
        sortedMap.put(99, "One");
        sortedMap.put(77, "Two");
        sortedMap.put(67, "Three");
        sortedMap.put(84, "Four");
        //sortedMap.put(null, "Five");  null key gievs null pointer exception
        System.out.println(sortedMap);

        //some methods not in normal map
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        System.out.println(sortedMap.headMap(77)); //less than 77
        System.out.println(sortedMap.tailMap(77)); //greater than or equal to 77
        System.out.println(sortedMap.subMap(84, 67)); //less than or equals to 84 and greater than 67
        //System.out.println(sortedMap.subMap(67,84)); give exception because our comparator is in descending order

        NavigableMap<Integer, String> navigableMap = new TreeMap<>((a, b) -> a - b);
        navigableMap.putAll(sortedMap);
        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(77)); //strictly less than 77 which is nearest
        System.out.println(navigableMap.ceilingKey(77)); //greater than or equals to 77 which is nearest
        System.out.println(navigableMap.floorKey(77)); //less than or equals to 77 which is nearest
        System.out.println(navigableMap.higherKey(77)); //strictly greater than 77 which is nearest

        System.out.println(navigableMap.higherEntry(77)); //strictly greater than 77 which is nearest
        System.out.println(navigableMap.ceilingEntry(77)); //greater than or equals to 77 which is nearest
        System.out.println(navigableMap.pollFirstEntry()); //remove and return the first entry
        System.out.println(navigableMap.pollLastEntry()); //remove and return the last entry
        System.out.println(navigableMap);
    }
}

//reference map if ony sorting and normal methods

//reference Sortedmap if sorting and methods like firstKey, lastKey, headMap, tailMap, subMap

/*
reference NavigableMap if sorting and
methods like lowerKey, ceilingKey, floorKey, higherKey, higherEntry, ceilingEntry, pollFirstEntry, pollLastEntry
*/