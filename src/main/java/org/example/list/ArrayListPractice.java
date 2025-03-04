package org.example.list;

import java.lang.reflect.Field;
import java.util.*;

public class ArrayListPractice {
    public static void main(String[] args) {

        // Array of fixed size 3
        int[] arr = new int[3];

        // Array of Dynamic size
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Integer> arrayList1 = new ArrayList<>();

        // value based adding elements to the list
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList);
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains(2));
        System.out.println(arrayList.indexOf(2));

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();

        //index based removing
        arrayList.remove(1);
        System.out.println(arrayList);

        arrayList.add(5);
        System.out.println(arrayList);

        //value based removing, remove first occurrence of the element
        arrayList.remove((Integer) 5);
        System.out.println(arrayList);

        //index based adding
        arrayList.add(1, 2);
        System.out.println(arrayList);

        //index based updating
        arrayList.set(1, 5);
        System.out.println(arrayList);



        try {
            Field field  = ArrayList.class.getDeclaredField("elementData");

            //when we add first element into list, then default capacity is assigned to it which is 10
            field.setAccessible(true);
            Object[] objects = (Object[]) field.get(arrayList1);
            System.out.println("Capacity: of empty list" + objects.length);//capacity is 0

            //capacity is 10
            //when we add 11th element, then capacity is increased to 1.5x of previous capacity
            objects = (Object[]) field.get(arrayList);
            System.out.println("Capacity of list after adding one elements: " + objects.length);

            //grows Automatically but for shrinking, we have to do it manually
            arrayList.trimToSize();
            System.out.println("Capacity of list after trim: " + objects.length);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        List<Integer> list1 = new ArrayList<>();
        System.out.println(list1.getClass().getName());

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        //return fixed size list not ArrayList
        //list2.add(4);  UnsupportedOperationException runtime exception
        //list2.remove(1); UnsupportedOperationException runtime exception
        //all mutative operations are not allowed
        list2.set(1, 5);
        System.out.println(list2.getClass().getName());

        List<Integer> list3 = List.of(1, 2, 3);
        //return fixed size and immutable list
        //add, remove, set operations are not allowed
        System.out.println(list3.getClass().getName());

        Integer[] arr1 = {1, 2, 3};
        List<Integer> list4 = Arrays.asList(arr1);
        System.out.println(list4.getClass().getName());

        //make Arrays.asList() list mutable
        List<Integer> list5 = new ArrayList<>(list2);
        list5.add(4); //no exception
        System.out.println(list5.getClass().getName());

        list5.addAll(list3);
        System.out.println(list5);

        list5.removeIf(n -> (n % 2 == 0));
        System.out.println(list5);

        //just passed 0 to tell that we want to convert list to array of Integer type
        //if we don't any argument, then it will return Object[] array
        Integer[] array = list5.toArray(new Integer[0]);

        //sort in ascending order
        Collections.sort(list5);
        System.out.println("Sorted List5: "+ list5);

        //give null to sort in natural order i.e. ascending order
        //giving comparator as null
        arrayList.sort(null);
        System.out.println("Sorted arrayList: "+ arrayList);

    }
}
