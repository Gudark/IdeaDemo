package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: Maven1 - eg1.ReentrantL2
 * <p>Powered by Gudark On 2021/12/28 20:21
 * <p>Created by IntelliJ IDEA
 * <p>Description : This is description of class
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ReentrantL2 {
    Lock lock=new ReentrantLock();

    void m1(){
        lock.lock();
        System.out.println("线程1启动");
        try{
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    void m2(){
        //尝试获取锁，被中断会进入中断异常处理块中
        try{
            //lockInterruptibly 没有时间限制的尝试获取锁，但是可响应中断
            lock.lockInterruptibly();
            System.out.println("线程2终于打断了线程1");
        } catch (InterruptedException e) {
            System.out.println("线程2：InterruptedException异常");
        }finally{
            //tryLock() 使用lock获取锁，如果线程2获取到了锁，线程2返回true，线程1直接返回false；
            //可以传入时间参数，表示拿不到锁等待一段时间，之后依旧拿不到就返回false
            if(lock.tryLock())
                lock.unlock();
            System.out.println("线程2结束了");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        var rl=new ReentrantL2();
        new Thread(rl::m1,"T1").start();
        Thread t2=new Thread(rl::m2,"T2");
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        //中断t2等待过程，使用 lockInterruptibly 获取锁才可中断
        t2.interrupt();
        //返回当前线程的线程组中活动的线程数量（估计值，遍历内部数据时线程动态改变）
        System.out.println(Thread.activeCount());
    }
}
