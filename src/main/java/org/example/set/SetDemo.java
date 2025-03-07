package org.example.set;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {
        //Collection doesnot contain duplicates
        // faster operation
        //Map -> HashMap, LinkedHashMap , TreeMap , EnumMap
        //set -> HashSet , LinkedHashset, TreeSet, EnumSet

        //hashing functionality and features of list
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(7);
        System.out.println(set);

        //insertion order is maintained
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(12);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(6);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(67);
        System.out.println(linkedHashSet);

        TreeSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(12);
        sortedSet.add(2);
        sortedSet.add(3);
        sortedSet.add(4);
        sortedSet.add(5);
        sortedSet.add(6);
        System.out.println(sortedSet);

        //navigation feature of treeset
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(12);
        navigableSet.add(2);
        navigableSet.add(3);
        System.out.println(navigableSet.descendingSet());
        System.out.println(navigableSet.pollFirst());
        System.out.println(navigableSet);

        System.out.println("-----------------------------------------------");

        Set<Integer> syncSet = Collections.synchronizedSet(set);

        //unmodifiable sets
        Set.of(1,2,3,4,5);
        Collections.unmodifiableSet(syncSet);

    }
}

// concurrentskipListMap and set when we need things sorted and threadsafe and range based operations

