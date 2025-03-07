package org.example.queue;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        // thread safe without locks, use CAS

        ConcurrentLinkedDeque<String> dclq = new ConcurrentLinkedDeque<>(); // same just double ended queue

        Thread producer = new Thread(()->{
            while (true){
                clq.add("Task added");
            }
        });

        Thread consumer = new Thread(()->{
            while (true){
                System.out.println(clq.poll());
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
