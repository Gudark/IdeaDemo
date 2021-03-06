package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: Maven1 - eg1.SellTicket2
 * <p>Powered by Gudark On 2021/12/24 19:57
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class SellTicket2 {
    public static void main(String... args) {
        var runnable = new TicketRunnable(20);
        new Thread(runnable, "1号售票点").start();
        new Thread(runnable, "2号售票点").start();
    }

    public static class TicketRunnable implements Runnable {
        //ReentrantLock 重入锁 :独占锁，手动加、解锁，灵活，可响应中断;
        ReentrantLock lock = new ReentrantLock();
        private int num;

        public TicketRunnable(int num) {
            this.num = num;
        }

        //ReentrantLock lock=new ReentrantLock(true);//可实现公平锁；

        public void run() {
            while (true) {
                //synchronized (this) {
                lock.lock();
                if (num > 0) {
                    num--;
                    System.out.println(Thread.currentThread().getName() + ":售票1张，余票" + num);
                } else {
                    System.out.println(Thread.currentThread().getName() + ":暂时无余票");
                    //加入 exit命令可执行后退出
                    System.exit(0);
                    break;
                }
                //}
                lock.unlock();//使用ReentrantLock 锁线程执行结束无法自动关闭？？？（解决）
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}