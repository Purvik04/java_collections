package org.example.map;

import java.math.BigDecimal;
import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        //HashTable is synchronized
        //HashTable does not allow null key and null value
        //legacy class, replaced by ConcurrentHashMap
        //slowe than HashMap due to synchronization
        //only use ll no red-black tree for collision
        //all methods are synchronized including read (get) which is overhead
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "John");
        hashtable.put(2, "Doe");

        System.out.println(hashtable);
    }
}
