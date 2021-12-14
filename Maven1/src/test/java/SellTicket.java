/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - SellTicket
 * <p>Powered by Gudark On 2021/12/24 16:09
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class SellTicket {
    public static void main(String[] args) {
        int P = 20;
        var t = new Runnable() {
            public synchronized void run() {
                int p=P;
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (p > 0) {
                        System.out.printf("%s售出一张票，剩余%d张票%n", Thread.currentThread().getName(), --p);
                    } else {
                        System.out.printf("%s票已售完，停止售票!%n", Thread.currentThread().getName());
                        break;
                    }

                }
            }
        };
        var T1=new Thread(t,"1号售票点：");
        var T2=new Thread(t,"2号售票点：");
        var T3=new Thread(t,"3号售票点：");
        var T4=new Thread(t,"4号售票点：");
        T1.start();T2.start();T3.start();T4.start();
    }
}
