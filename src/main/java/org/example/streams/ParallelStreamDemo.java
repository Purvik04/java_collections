package org.example.streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {

        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        long start = System.currentTimeMillis();
        list.stream().map(ParallelStreamDemo::factorial).toList();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        list.parallelStream().map(ParallelStreamDemo::factorial).toList();
//        list.parallelStream().map(ParallelStreamDemo::factorial).sequential().toList();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        //used when cpu-intensive or large datasets and tasks are independent like finding fact of one ele don't affect other


        //[1,2,3,4,5] --> [1,3,6, 10, 15]
        List<Integer> list2 = Stream.iterate(1, x -> x + 1).limit(5).toList();
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> list3 = list2.parallelStream().map(x -> sum.addAndGet(x)).toList();
        System.out.println("Wrong output" + list3);

    }

    private static long factorial(int n){
        long res = 1;
        for (int i = 2; i<=n; i++){
            res = res * i;
        }
        return res;
    }
}
