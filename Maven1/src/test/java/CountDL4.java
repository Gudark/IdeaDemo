/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - CountDL4
 * <p>Powered by Gudark On 2021/12/28 10:07
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class CountDL4 {

    //指定线程收尾
    // CountDownLatch(int count) 门闩含有计数器，当指定数量线程结束任务时才可打开门闩
    static CountDownLatch latch = new CountDownLatch(5);

    //T* 线程任务
    void work() {
        for (int i = 0; i <= 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.printf("%s - %d%n", Thread.currentThread().getName(), i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //线程任务结束时打开门闩 4 次
        latch.countDown();
    }

    //OVER 收尾线程任务，门闩计数到达时被唤醒，向下执行
    void gameover() {
        System.out.println("结束线程启动......");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }

    public static void main(String[] args) {
        var t = new CountDL4();
        new Thread(t::work, "T1").start();
        new Thread(t::work, "T2").start();
        new Thread(t::work, "T3").start();
        new Thread(t::work, "T4").start();
        new Thread(t::gameover, "OVER").start();
        //main 主线程任务
        for (int i = 0; i <= 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.printf("%s - %d%n", Thread.currentThread().getName(), i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //主线程任务结束时打开门闩 1 次
        latch.countDown();
    }
}