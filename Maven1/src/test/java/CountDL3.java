/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - CountDL3
 * <p>Powered by Gudark On 2021/12/28 8:57
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class CountDL3 {

    //主线程收尾

    static void work(){
        for (int i = 0; i < 5; i++) {
            try{
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        latch.countDown();
    }

    static CountDownLatch latch=new CountDownLatch(5);

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("收尾开始");
            try{
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("真正程序的结局");
        },"END").start();

        new Thread(CountDL3::work,"t1:").start();
        new Thread(CountDL3::work,"t2:").start();
        new Thread(CountDL3::work,"t3:").start();
        new Thread(CountDL3::work,"t4:").start();
        work();
        System.out.println("main - 结束");
    }
}
