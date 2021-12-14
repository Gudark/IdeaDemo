/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - CyclicB
 * <p>Powered by Gudark On 2021/12/28 10:41
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class CyclicB {
    CyclicBarrier ccb=new CyclicBarrier(3,()-> System.out.println("大家到齐了，开饭！"));

    void eat(int t){
        System.out.println(Thread.currentThread().getName()+"出发");
        try{
            System.out.println(Thread.currentThread().getName()+t+"s后到达");
            TimeUnit.SECONDS.sleep(t);
            System.out.println(Thread.currentThread().getName()+"到达");
            ccb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var c=new CyclicB();
        var r= new Random();
        new Thread(()->c.eat(r.nextInt(10)),"lisa").start();
        new Thread(()->c.eat(r.nextInt(10)),"john").start();
        new Thread(()->c.eat(r.nextInt(10)),"jim").start();
    }
}
