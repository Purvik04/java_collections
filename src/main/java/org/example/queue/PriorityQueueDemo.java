package org.example.queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //prioritize ele based on natural sorting
        //custom comparator for customized sorting
        // does not allow null values
        pq.add(15);
        pq.add(5);
        pq.add(7);
        pq.add(18);

        //insetion and deletion 0(n)
        //peek 0(1)
        System.out.println(pq);
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        //min - heap is maintained
        // each node is smaller or equal then its child
    }
}
