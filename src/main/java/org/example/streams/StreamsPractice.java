package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsPractice {
    public static void main(String[] args) {
        //process collections of data in functional and declarative manner
        //simplify data processing
        //Enable functional programming
        //improve redability and maintainibility
        //enable parallelism

        //Streams Creation
        //1) from List :- list.stream()
        //2) from Arrays:-
        String[] arr = new String[]{"abc","cde"};
        Stream<String> stringStream = Arrays.stream(arr);

        //3)using stream.of()
        Stream<String> stream2 = Stream.of("a","b","c");

        //4)Infinite Streams
        Stream<Integer> generate = Stream.generate(()->1);
        //limited Stream
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(100).toList();
        System.out.println(list);


        //list.stream().toList() method return unmodifiableList

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);

        //reduce list to sigle value
        Optional<Integer> reduce = list1.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        //anyMatch allMatch noneMatch
        System.out.println(list1.stream().anyMatch(x->x%2 == 0));
        System.out.println(list1.stream().allMatch(x->x%2 == 0));
        System.out.println(list1.stream().noneMatch(x->x%2 == 0));

        String s = "Hello World";
        System.out.println(s.chars().filter(x-> x == 'l').count());


        //flatMap method
        //Handle streams of collections , list or arrays where each element it self is a collection
        //flaten nested structures to so they can be processed as a single sequence of elements
        //Trnasform and flatten at same time
        List<List<String>> fruits = Arrays.asList(
             Arrays.asList("Apple", "Mango"),
             Arrays.asList("Banana", "guava")
        );

        fruits.stream().flatMap(x-> x.stream()).map(String::toUpperCase).toList();

        List<String> sentence = Arrays.asList(
                "Hello World",
                "How are you?",
                "I am fine."
        );

        List<String> list2 = sentence
                .stream()
                .flatMap(x -> Arrays.asList(x.split(" ")).stream())
                .map(String::toUpperCase)
                .toList();

        //stream cannot be reused for any processing one terminal operation is done
        Stream<String> stream = list2.stream();
        stream.forEach(System.out::println);
//        stream.map(x-> x%2==0); this line gives exception due to stream is closed
    }
}
