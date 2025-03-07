package org.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeueDemo {
    public static void main(String[] args) {

        //no need to shifts  ele when removed from first due to circular array ,two pointers maintained
        //size doubled when head and tail meet
        Deque<Integer> dq1 = new ArrayDeque<>(); // when faster iteration, low memory, no null allowed

        Deque<Integer> dq2 = new LinkedList<>(); // when insertion deletion from middle
    }
}
