package org.example.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IndentityHashMapDemo {

    public static void main(String[] args) {
        String s1 = new String("key");
        String s2 = new String("key");

        //hashmap uses hashcode and euqals method of specific object if avl
        // otherwise object class to compare the keys and values
        HashMap<String,Integer> map = new HashMap<>();
        map.put(s1, 100);
        map.put(s2, 200);
        System.out.println(map); //only one entry will be there because hashcode and equals of String class is overridden


        //identityhashmap uses IdenityHashcode and  == operator to compare the keys and values
        IdentityHashMap<String,Integer> map1 = new IdentityHashMap<>();
        map1.put(s1, 100);
        map1.put(s2, 200);
        System.out.println(map1); //two entries will be there because Object class hashcode works wit objects memory
                                  // and == operator checks the reference of the object

    }
}
