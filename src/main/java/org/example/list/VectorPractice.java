package org.example.list;

import java.util.Vector;

public class VectorPractice {
    public static void main(String[] args) {

        //all methods of Vector are synchronized

        //by defualt double the size when capacity is full
        Vector<String> fruits = new Vector<>(5,3);
        System.out.println(fruits.capacity());
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("Mango");
        System.out.println(fruits.capacity());

        fruits.add("Guava");
        System.out.println(fruits.capacity());

        //by default capacity is 10
        Vector<Integer> numbers = new Vector<>();
        System.out.println(numbers.capacity());

        //if i run below code on ArrayList then it will not give me consistent output(2000) as ArrayList is not thread safe
        //ArrayList<Integer> numbers = new ArrayList<>();
        //vector is thread safe
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numbers.add(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numbers.add(2);
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();

            System.out.println(numbers.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
