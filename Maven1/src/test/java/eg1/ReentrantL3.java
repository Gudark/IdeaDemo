/*
 * Copyright (c) 2018, 2022, github.com/Gudark All rights reserved.
 *
 */
package eg1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: HelloWord - ReentrantL3
 * <p>Powered by Gudark On 2022/1/3 21:14
 * <p>Created by IntelliJ IDEA
 * <p>Description : This is description of class
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ReentrantL3 {
    //ReentrantLock 设置为 true公平锁，效率低
    ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        var t = new ReentrantL3();
        new Thread(t::m, "T1").start();
        new Thread(t::m, "T2").start();
        new Thread(t::m, "T3").start();
        new Thread(t::m, "T4").start();
    }

    void m() {
        for (int i = 0; i <= 20; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}
