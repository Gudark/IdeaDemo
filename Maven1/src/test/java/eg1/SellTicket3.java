package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - eg1.SellTicket3
 * <p>Powered by Gudark On 2021/12/27 8:57
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class SellTicket3 {
    static class Ticket {
        private int num;

        public Ticket(int num) {
            this.num = num;
        }

        public void sell() {
            while (true) {
                synchronized (this) {
                    if (num > 0) {
                        num--;
                        System.out.println(Thread.currentThread().getName() + ":售票1张，余票" + num);
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":暂时无余票");
                        break;
                    }
                }
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void returned() {
            num++;
            System.out.println(Thread.currentThread().getName() + ":退票1张，余票" + num);
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            var ticket = new Ticket(20);
            new Thread(ticket::sell, "售票处").start();
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 5; i++){
                        ticket.returned();
                    }
                }
            },  "退票处").start();
        }
    }
}
