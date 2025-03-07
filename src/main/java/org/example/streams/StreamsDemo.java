package org.example.streams;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class StreamsDemo {

    public static void main(String[] args) {
        //java 8 onwards

        // --> minimal code, functional programming,
        // --> lambda expression, Stream API

        //lambda expression is a way to represent a method as an object
        //lambda expression does not have a name, return type, and modifiers

        //consumer interface no return type
        Consumer<List<Integer>> printList = x -> {
            for (Integer i : x) {
                System.out.print(i + " ");
            }
            System.out.println();
        };
        printList.accept(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        //supplier interface no input , only return type
        Supplier<Integer> getRandomNumber = () -> (int)(Math.random() * 1000);
        System.out.println(getRandomNumber.get());

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Function<Integer,Integer> square = x -> x * x;
        Consumer<Integer> print = x -> System.out.println(x);
        Supplier<Integer> getNumber = () -> 20;

        if (isEven.test(getNumber.get())) {
            print.accept(square.apply(getNumber.get()));
        }

        //BiFunction, BiPredicate, BiConsumer are used when we have two inputs
        BiPredicate<Integer, Integer> isGreater = (x, y) -> x > y;
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        BiConsumer<Integer, Integer> printSum = (x, y) -> System.out.println(x + y);

        //if we have same input and output type then we can use UnaryOperator(function) and BinaryOperator(bifunction)
        UnaryOperator<Integer> doubleIt = x -> x * 2;
        BinaryOperator<String> concat = (x, y) -> x + y;

        System.out.println(concat.apply("Hello ", "World"));

        //method reference --> use method without invoking & in place of lambda expression
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.forEach(x-> System.out.print(x));
        System.out.println();
        list.forEach(System.out::print);

        //constructor reference
        List<String> names = Arrays.asList("A", "B","C");
        List<Phone> phoneList = names.stream().map(Phone::new).toList();
        System.out.println(phoneList);


    }
}

class Phone{
    String name;

    Phone(String name){
        this.name = name;
    }

}