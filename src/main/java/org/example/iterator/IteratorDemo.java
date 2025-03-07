package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i : list){
            System.out.println(i);
        }
        // for each internally implemented as below
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //concurrent modification excpetion due to in for loop
//        for (int i : list){
//            if (i % 2 == 0){
//                list.remove(i);
//            }
//        }


        //allows modfication while iterating even though ArrayList dont need copyOnWriteArrayList
        it = list.iterator();
        while (it.hasNext()){
            Integer num =  it.next();
            if (num % 2 == 0){
                it.remove();
            }
        }

        //more methods like hasPrevious set etc
        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()){
            integerListIterator.next();
            integerListIterator.set(1);
        }
        System.out.println(list);

        integerListIterator.set(2);

        while (integerListIterator.hasPrevious()){
            System.out.println(integerListIterator.previous());
        }

    }
}
