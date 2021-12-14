/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * <p>Project: Maven1 - Thread1
 * <p>Powered by Gudark On 2021/12/23 20:42
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Thread1 {
    public static void main(String... args) {
        //指定时间关机
        new Thread(() -> {
            var off = LocalDateTime.of(2021, 12, 24, 21, 30, 00);
            try {
                while (true) {
                    //TineUnit类 时间颗粒转换，延时 中间可指定单位
                    TimeUnit.SECONDS.sleep(1);
                    var ldt = LocalDateTime.now();
                    //var bet=Duration.between(ldt,off);
                    if (ldt.compareTo(off) >= 0) {
                        System.out.println("到达指定时间");
                        Runtime.getRuntime().exec("cmd /k /s /t");
                        break;
                    }
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}