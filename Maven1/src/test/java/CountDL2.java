/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - CountDL2
 * <p>Powered by Gudark On 2021/12/27 20:36
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class CountDL2 {
    static List<String> list = new ArrayList<>();
    static CountDownLatch latch = new CountDownLatch(1);

    public static void work() {
        String tn = Thread.currentThread().getName();
        System.out.println(tn + ":线程启动");
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("item" + (list.size() + 1));
            System.out.printf("%s:%d=%s%n", tn, list.size(), list.get(list.size() - 1));
            if (list.size() == 5) {
                //开启门闩，此时会提醒线程 T2 向下执行
                latch.countDown();
            }
        }
    }

    public static void check() {
        String tn = Thread.currentThread().getName();
        System.out.println(tn + ":线程启动");
        try {
            //此线程在此处中断，等待
            latch.await();
            System.out.println(tn + "容器中已放入5个元素，线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //T1 任务向容器中添加元素，到5个元素时，打开门闩通知线程T2
        new Thread(CountDL2::work, "T1").start();
        //T2 启动就进入就绪等待，接到通知就开始向下执行
        new Thread(CountDL2::check, "T2").start();
    }
}
