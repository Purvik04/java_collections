package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {

    public static void main(String[] args) {
        //Queue (interface) -> linkedList , priorityQueue

        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.size());
        //queue.remove(); // NoSuchElementException when empty
        System.out.println(queue.poll());

        //System.out.println(queue.element()); //NoSuchElementException when empty
        System.out.println(queue.peek());

        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(2);
        abq.add(1);
        abq.add(2);
        //abq.add(3) throws IllegalStateException when full
        abq.offer(3); // just return false
    }
}
