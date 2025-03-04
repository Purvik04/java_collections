package org.example.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);
        linkedList.add(4);

        System.out.println(linkedList.size());

        //we can get the element by index
        linkedList.get(2); // O(n) which is O(1) in case of ArrayList

        linkedList.addFirst(0); // O(1) which is O(n) in case of ArrayList
        linkedList.addLast(5); // O(1)

        System.out.println(linkedList);

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        linkedList.removeFirst(); // O(1) which is O(n) in case of ArrayList
        linkedList.removeLast();// O(1)
        
        System.out.println(linkedList);

        Iterator<Integer> integerIterator = linkedList.descendingIterator();


    }
}
