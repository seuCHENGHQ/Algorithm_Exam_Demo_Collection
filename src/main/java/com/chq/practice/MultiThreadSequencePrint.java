package com.chq.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用ReentrantLock来实现顺序打印
 *
 * @author chenghq
 */
public class MultiThreadSequencePrint {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();
    public static Condition condition3 = lock.newCondition();
    public static int round = 10;
    //state标志着当前应该打印哪个字符，从A开始
    public static volatile int state = 1;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.submit(new Worker("A", lock, condition1, condition2, round, 1));
        pool.submit(new Worker("B", lock, condition2, condition3, round, 2));
        pool.submit(new Worker("C", lock, condition3, condition1, round, 3));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}


/**
 * 这么做的效果比对象的wait notify机制效率高一点，因为实现了针对性的唤醒
 * notify是无法实现针对性的唤醒的，每次只能notifyAll来防止死锁，效率较低
 */
class Worker implements Runnable {
    private String key;
    private ReentrantLock lock;
    private Condition currCondition;
    private Condition nextCondition;
    private int round;
    private int state;

    public Worker(String key, ReentrantLock lock, Condition currCondition, Condition nextCondition, int round, int state) {
        this.key = key;
        this.lock = lock;
        this.currCondition = currCondition;
        this.nextCondition = nextCondition;
        this.round = round;
        this.state = state;
    }

    @Override
    public void run() {
        this.lock.lock();
        try {
            for (int i = 0; i < round; i++) {
                while (MultiThreadSequencePrint.state != state) {
                    //condition的await会释放锁，但是源码中如何实现的
                    /**
                     * await的源码中，可以看出，首先当前线程会释放拿到的lock的锁
                     * 然后该线程会被放到condition的等待队列中
                     * 当其他线程调用该condition.signal的时候，阻塞中的线程就会回到lock的就绪队列中
                     * 等待获取lock，并继续执行
                     */
                    currCondition.await();
                }
                System.out.println(i + "," + key);
                ++MultiThreadSequencePrint.state;
                if (MultiThreadSequencePrint.state > 3) {
                    MultiThreadSequencePrint.state = 1;
                }
                nextCondition.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }
}
