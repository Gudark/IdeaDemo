/*
 * Copyright (c) 2018, 2022, github.com/Gudark All rights reserved.
 *
 */
package eg2;

/**
 * <p>Project: HelloWord - Testfori
 * <p>Powered by Gudark On 2022/1/4 17:02
 * <p>Created by IntelliJ IDEA
 * <p>Description : This is description of class
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Testfori {
    public static void main(String[] args) {
        var s = System.nanoTime();
        System.out.println("开始时间戳：" + s);
        int sum = 0;
        for (int i = 0; i < 100000000; i++) {
        }
        /*for (int i = 0; i < 100000000; ++i) {
        }*/
        //System.out.println("循环次数：" + sum);
        var e = System.nanoTime();
        System.out.println("结束时间戳：" + e);
        long b = e - s;
        System.out.println("循环耗时：" + b);
    }
}
/* 循环100W次
 * for i++ 循环耗时：21018100/28333100
 * for ++i 循环耗时：27379600/28079200*/