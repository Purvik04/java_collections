package org.example.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {

        // Stack is a subclass of Vector
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.capacity());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.capacity());

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);

        //not just limited to stack functionality but also have vector functionality
        //can add, remove, get, set elements from the middle of the stack also

        //LinkedList can also be used as stack
        LinkedList<Integer> stack2 = new LinkedList<>();
        stack2.addLast(1);
        stack2.addLast(2);
        stack2.addLast(3);
        System.out.println(stack2.getLast());
        System.out.println(stack2.removeLast());

        //ArrayList can also be used as stack but have to do manually
        ArrayList<Integer> stack3 = new ArrayList<>();
        stack3.add(1);
        stack3.add(2);
        stack3.add(3);
        System.out.println(stack3.get(stack3.size()-1)); //peek
        System.out.println(stack3.remove(stack3.size()-1)); //pop
    }
}
