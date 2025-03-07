package org.example.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        // java 7 --> segment based locking --> 16 segments --> smaller hashmap
        // only the segment which is being updated is locked
        // read does not require any lock until there is a write operation going on


        //java 8 --> no segment based locking
        //           compare and swap operation --> no lock until resize operation and collision
        //           lock is at the bucket level when there is a collision
        //Thred A saw x = 42
        //Thread A work --> x to 50
        // if x is still 42, then update to 50 else retry
        // this is done using CAS operation and if loop then thread back off of some time and retry
        concurrentHashMap.put(1, "John");
        concurrentHashMap.put(2, "Doe");

        System.out.println(concurrentHashMap.containsValue("Doe"));
    }
}
