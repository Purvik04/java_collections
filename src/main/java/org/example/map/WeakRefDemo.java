package org.example.map;

import java.lang.ref.WeakReference;

public class WeakRefDemo {
    public static void main(String[] args) {
        Student student = new Student("Doe", 25);
        WeakReference<Student> studentWeakReference = new WeakReference<>(new Student("John", 25));
        System.out.println(student);
        System.out.println(studentWeakReference.get());
        System.gc(); //calling garbage collector
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(student);
        System.out.println(studentWeakReference.get());


    }

    private static class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
