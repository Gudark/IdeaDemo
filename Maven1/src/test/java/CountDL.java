/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - CountDL
 * <p>Powered by Gudark On 2021/12/27 19:06
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class CountDL {
    public static void main(String[] args) {
        var dl = new Countdl();

        //一个线程实现功能添加元素
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                dl.add();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        //一个线程统计
        new Thread(() -> {
            System.out.println("t2");
            while (!dl.count()) ;
            System.out.println("已经有5个了");
        }, "t2").start();
    }

    static class Countdl {
        private volatile List list = new ArrayList<>();

        public void add() {
            list.add("add" + list.size());
            System.out.printf("%d=%s%n", list.size(), list.get(list.size() - 1));
        }

        public boolean count() {
            boolean f = false;
            if (list.size() >= 5) {
                System.out.println(Thread.currentThread().getName() + "线程启动");
                f = true;
            }
            return f;
        }
    }
}
