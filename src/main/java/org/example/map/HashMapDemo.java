package org.example.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2, "Apple");
        map.put(1, "Orange");
        map.put(4, "Banana");
        map.put(3, "Pineapple");

        System.out.println(map);

        System.out.println(map.get(2)); // Apple
        System.out.println(map.get(5)); // null  O(1) and but in case of collision O(n) for linkedlist and O(logn) for red black tree
        System.out.println(map.containsKey(2)); // true O(1) but in case of collision O(n) for linkedlist and O(logn) for red black tree
        System.out.println(map.containsValue("Banana")); // true O(n)

        Set<Integer> keys = map.keySet();
        System.out.println("using keyset");
        for(int i : keys) {
            System.out.println(i + " " + map.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("using entryset");
        for (Map.Entry<Integer, String> i : entries) {
            i.setValue(i.getValue().toUpperCase());
        }
        System.out.println(map);

        //map.remove(4);
        boolean res = map.remove(4, "Strawberry");
        System.out.println("Removed? : " + res);

    }
}
