package org.example.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListPractice {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>();
        // "Copy on Write" means when we try to modify the list
        // like adding or removing elements, it creates a new copy of the list
        // and then performs the modification on the new copy.
        // this ensures that other threads reading the list while it is being modified will not be affected.

        //read operation: fast and direct, since they happen on stable list without interference from modification
        //write operation: A new copy of the list is created for every modification
        // the reference of the list is updated to the new copy so that subsequent read operations can be performed on the new copy

        // this is useful when we have more read operations than write operations

        //list<String> shoppingList = new ArrayList<>();
        List<String> shoppingList = new CopyOnWriteArrayList<>();

        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Butter");

        //loop will run on original snapshot of the list
        for (String item : shoppingList) {
            System.out.println(item);
            //try to modify a list while reading it
            if(item.contains("Milk")) {
                // this will not throw ConcurrentModificationException because java expects stable list for read operations
                // hence we use CopyOnWriteArrayList for cases where we want to modify the list while iterating
                shoppingList.add("Eggs");
                System.out.println("Added Eggs while iterating");
            }
        }
        //after the loop, the list will be updated with the new copy

        System.out.println("Updated Shopping list: " + shoppingList);


        //when write lock for modification
        List<Integer> list = new CopyOnWriteArrayList<>();

        // Writer Thread 1: Adds elements with prefix "Writer1-"
        Thread writer1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                list.add(i);
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Writer Thread 2: Adds elements with prefix "Writer2-"
        Thread writer2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                list.add(i);
                try {
                    Thread.sleep(150); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both writer threads concurrently.
        writer1.start();
        writer2.start();

        // Wait for both threads to finish.
        writer1.join();
        writer2.join();

        // Print the final state of the list.
        System.out.println("Final List: " + list.size());
     }
}
