package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

/**
 * <p>Project: Maven1 - eg1.Thread2
 * <p>Powered by Gudark On 2021/12/24 10:26
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Thread2 implements Runnable {

    //建立方法一 实现Runnable 接口，并作为 Thread类参数
    public void run() {
        System.out.println("eg1.Thread2.....");
    }

    public static void main(String[] args) {
        var t2 = new Thread(new Thread2());
        t2.start();

        new Thread(() -> {
            System.out.println("eg1.Thread4");
        }).start();
    }
}