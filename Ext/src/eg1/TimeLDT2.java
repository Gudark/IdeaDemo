/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */
package eg1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * <p>Project: Idea Demo - TimeLDT2
 * <p>Powered by Gudark On 2021/12/11 14:33
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class TimeLDT2 {
    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2021, 12, 11, 14, 36, 56);
        System.out.println(dt1);

        //LocalDateTime对日期和时间进行加减提供了非常简单的链式调用

        // 加7天 减30分钟
        LocalDateTime dt2 = dt1.plusDays(7).minusMinutes(30);
        System.out.println(dt2);//2021-12-18T14:06:56
        //在dt2基础上 减1年 加3个月
        LocalDateTime dt3 = dt2.minusYears(1).plusMonths(3);
        System.out.println(dt3);//2021-03-18T14:06:56

        //对日期和时间调整使用 with（）方法

        //日期变为当月1日
        LocalDateTime dt4 = dt1.withDayOfMonth(1);
        System.out.println(dt4);//2021-12-01T14:36:56
        //月份调整为11月 小时调整为12时
        LocalDateTime dt5 = dt1.withMonth(11).withHour(12);
        System.out.println(dt5);//2021-11-11T12:36:56

        //LocalDateTime 有一个通用的 with()方法可以让我们做更复杂的运算 (TemporalAdjusters)

        //本月第一天的00：00时刻
        LocalDateTime firstDay0 = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay0);//2021-12-01T00:00
        //本月最后一天
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);//2021-12-31
        //下月第一天
        LocalDate firstDayofnextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(firstDayofnextMonth);//2022-01-01
        //本月第一个周一
        LocalDate firstMonday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMonday);//2021-12-06

        //要判断两个 LocalDateTime 的先后，可以使用 isAfter() 和 isBefore()方法，LocalDate 和 LocalTime类似
        //需要注意 LocalDateTime 无法与时间戳进行转换，因为 LocalDateTime 没有时区

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(1999, 9, 9, 9, 9, 9);
        //判断系统当前时间是否晚于给定时间
        System.out.println(now.isAfter(target));//ture
        //判断当前日期是否晚于给定日期
        System.out.println(LocalDate.now().isAfter(LocalDate.of(2020, 2, 20)));//ture
        //判断当前时间是否早于给定时间
        System.out.println(LocalTime.now().isBefore(LocalTime.parse("12:12:12")));//ture
    }
}
