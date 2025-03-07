package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("naman", "heet", "purvik", "venil");

        //1)Collect to list
        names.stream().filter(x-> x.length()>3).collect(Collectors.toList());

        //2)Collect to set
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Set<Integer> collect = nums.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        //3) to Any collections
        ArrayDeque<Integer> collect1 = nums.stream().filter(x -> x % 2 == 0).collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        //4)Joining Strings
        String collect2 = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(collect2);

        //5)summarizing data
        //count sum min max avg
        IntSummaryStatistics collect3 = nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(collect3.getMax());
        System.out.println(collect3.getAverage());
        System.out.println(collect3.getMin());
        System.out.println(collect3.getSum());

        System.out.println(nums.stream().collect(Collectors.averagingInt(x->x)));

        //6) groupby and that will be key
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));

        System.out.println(names.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" "))));
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));

        TreeMap<Integer, Long> collect4 = names.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collect4);

        //7) partitioning by predicate into to groups
        System.out.println(names.stream().collect(Collectors.partitioningBy(x-> x.length()>4)));

        //8) Mapping and collecting
        //applies mapping function before collecting
        System.out.println(names.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));


        List<String> names2 = Arrays.asList("naman", "heet", "purvik", "venil","naman", "heet", "purvik");
        System.out.println(names2.stream().collect(Collectors.toMap(k-> k , v->1, (x,y) -> x+y)));
        System.out.println(names2.stream().collect(Collectors.groupingBy(x->x , Collectors.counting())));

    }
}
