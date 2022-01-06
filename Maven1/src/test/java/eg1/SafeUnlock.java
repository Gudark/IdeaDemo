package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * <p>Project: HelloWord - eg1.SafeUnlock
 * <p>Powered by Gudark On 2021/12/30 20:26
 * <p>Created by IntelliJ IDEA
 * <p>Description : This is description of class
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class SafeUnlock {
    public static void testunlock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                safeUnlock(lock);
            }
        }).start();
        sleep(1);

        new Thread(() -> {
            try {
                int i = 8 / 0;
                lock.tryLock(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unsafeUnlock(lock);
                //safeUnlock(lock);
            }
        }).start();
    }

    public static void unsafeUnlock(ReentrantLock lock) {
        lock.unlock();
    }

    public static void safeUnlock(ReentrantLock lock) {
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
