package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

/**
 * <p>Project: Maven1 - eg1.Thread3
 * <p>Powered by Gudark On 2021/12/24 10:33
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */

public class Thread3 extends Thread {
    //建立方法二 继承 Thread类，重写 run方法
    public void run() {
        System.out.println("eg1.Thread3.....");
    }

    public static void main(String[] args) {
        var t3 = new Thread3();
        t3.setName("线程三");
        t3.start();
    }
}
