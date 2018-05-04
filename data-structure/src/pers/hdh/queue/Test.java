package pers.hdh.queue;

import java.util.Random;

/**
 * Test class<br/>
 *
 * @author hdonghong
 * @date 2018/05/04
 */
public class Test {

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        Queue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue: time = " + testQueue(arrayQueue, opCount) + " s");

        Queue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("LoopQueue: time = " + testQueue(loopQueue, opCount) + " s");


    }
}
