package org.example.queue;

import java.util.concurrent.*;


public class BlockingQueueDemo {
    public static void main(String[] args) {

        //thread - safe queue
        // wait for queue to become non-empty // wait for space
        //simplify problems like producer - consumer

        //BlockingQueue
            //put-> Block if queue is full until space becomes available
            //take -> Block if queue is empty until an elements becomes available
            //offer -> waits for space to become available, up to the specified timeout

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // A bounded, blocking queue backed by n circular array
        // low memory overhead
        // uses a single lock for enqueue and dequque operation
        // things get congested when more threads

        Thread thread1 = new Thread(new Producer(queue));
        Thread thread2 = new Thread(new Consumer(queue));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BlockingQueue<Integer> llBQ = new LinkedBlockingQueue<>();
        // if no capacity then creates INT.MAX capacity or we can say optionally bounded backed by LinkedList
        // Use two separate locks for enqueue and dequeue operation
        // High concurrency between multiple threads

        BlockingQueue<String> pBQ = new PriorityBlockingQueue<>(); // default capapcity 11
        //unbounded
        // put wont block
        // ele are pritorized by natural order or comparator
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private int value;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        value = 0;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Producer Produce: " + value);
                queue.put(value++);
//                queue.offer(value,20,TimeUnit.MILLISECONDS);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Integer j = queue.take();
                System.out.println("Consumer consumed: "+j);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
