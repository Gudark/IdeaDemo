package eg1;
/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>Project: Maven1 - eg1.Timer1
 * <p>Powered by Gudark On 2021/12/27 16:16
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Timer1 {
    public static void main(String[] args) throws ParseException {
        var t = new Timer();
        //schedule(TimerTask task,Date time) 在指定时间执行指定任务
        t.schedule(new TimerTask() {
            // run() 此计时器任务要执行的操作
            public void run() {
                System.out.printf("%1$tF %1$tT%n", System.currentTimeMillis());
            }
        }, 5000, 1000);//延迟 5s 后首次执行，之后间隔 1s 执行
        var dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //var dtf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        t.schedule(new TimerTask() {
            public void run() {
                //取消此计时器任务
                t.cancel();
                //SimpleDateFormat 可执行；使用 DateTimeFormatter则报错，必须加入（Date）???
            }
            //上面使用 DateTimeFormatter时，Pattern返回String，此处parse返回 CharSequence，因此需要（Date）强制转换
        }, (Date) dtf.parse("2021-12-26 19:00:00"));//命令不执行？？？

        Timer t2 = new Timer();
        TimerTask tt = new TimerTask() {
            public void run() {
                System.out.println("hello world Timer");//命令不执行？？？
                t2.cancel();
            }
        };
        t2.schedule(tt, 1000);
    }
}
