/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - Thread4
 * <p>Powered by Gudark On 2021/12/24 10:35
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Thread4 {
    public static void main(String[] args) {
        //方法一 继承Thread类
        var t1 = new Thread() {
            public void run() {
                this.setName("one thread");
                System.out.println(this.getName());
            }
        };
        t1.setName("one_thread");
        t1.start();

        //方法二 实现接口，实现Thread作为参数
        var t2 = new Runnable() {
            public void run() {
                String n = Thread.currentThread().getName();
                System.out.println(n);
            }
        };
        var t_2 = new Thread(t2, "two thread");
        t_2.setName("two_thread");
        t_2.start();

        try {
            TimeUnit.SECONDS.sleep(2);
            Thread.currentThread().setName("main thread");
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
