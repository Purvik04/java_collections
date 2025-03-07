package org.example.set;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        // thread safe
        // copy on write mechanism
        // No duplicate Elements
        // Iterators do not reflect modifications

        //when more read less write and stable while reading
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();

        //when frequent writes
        ConcurrentSkipListSet<Integer> set2 = new ConcurrentSkipListSet<>();

        for (int i = 0 ; i<= 5 ; i++){
            set2.add(i);
            set.add(i);
        }

        System.out.println("Intial cpon: " + set);
        System.out.println("Intial skip: " + set2);

        for (Integer i : set){
            System.out.println("cpon: " + i);
            //add after loop
            set.add(6);
        }

        for (Integer i : set2){
            System.out.println("skip: " + i);
            //direct add while reading
            set2.add(6);
        }

        System.out.println("after cpon: " + set);
        System.out.println("after skip: " + set2);

    }
}
