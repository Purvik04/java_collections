package org.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

public class ComparatorPractice {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Orange", "Banana", "Pineapple", "Mango"));

        // Sort the list in natural order (alphabetical order)
        // it will use the compareTo method of the String class which is method of the Comparable interface
        fruits.sort(null);
        System.out.println(fruits);

        //either use lambda or create a class that implements Comparator
        fruits.sort((fruit1, fruit2) -> fruit1.length() - fruit2.length());
        fruits.sort(new StringLengthComparator());
        System.out.println(fruits);

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Charlie", 3.8),
                new Student("Alice", 3.2),
                new Student("David", 3.5),
                new Student("Bob", 3.5)
        ));
        System.out.println(students);


        students.sort((o1, o2) -> {
            if(o1.getGpa() - o2.getGpa() < 0)
               return -1;
            else if  (o1.getGpa() - o2.getGpa() > 0)
                return 1;
            else
                return o1.getName().compareTo(o2.getName());
        });

        System.out.println(students);

        //above code can be written as below also
        Comparator<Student> comp = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comp);
        System.out.println(students);



    }
}

class Student{
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return name + " : " + gpa;
    }
}
