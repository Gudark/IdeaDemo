package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: Maven1 - eg1.ReentrantL
 * <p>Powered by Gudark On 2021/12/28 11:30
 * <p>Created by IntelliJ IDEA
 * <p>Description : This is description of class
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ReentrantL {
        Lock lock=new ReentrantLock();

        void m1(){
            lock.lock();
            for (int i = 0; i < 10; i++) {
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            lock.unlock();
        }

        void m2(){
            lock.lock();
            System.out.println("m2......");
            lock.unlock();
        }

    public static void main(String[] args) {
        var rl=new ReentrantL();
        new Thread(rl::m1,"T1").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl::m2,"T2").start();
    }
}
