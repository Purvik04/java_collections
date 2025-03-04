package org.example.map;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeAndEqualsMethod {

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person(1, "John");
        Person p2 = new Person(2, "Doe");
        Person p3 = new Person(1, "John");

        map.put(p1, "Engineer");
        map.put(p2, "Doctor");
        map.put(p3, "Teacher");

        System.out.println(map.size());
        System.out.println(map.get(p1));
        System.out.println(map.get(p3));
    }


    private static class  Person{
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Person other = (Person) obj;
            return id == other.id && name.equals(other.name);
        }

        @Override
        public String toString() {
            return "id: " + id + " name: " + name;
        }
    }
}
