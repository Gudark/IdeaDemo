/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.Comparator;
import java.util.function.UnaryOperator;

/**
 * <p>Project: Maven1 - Lambda1
 * <p>Powered by Gudark On 2021/12/23 10:19
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Lambda1 {
    public static void main(String... args) {
        var db = new DbDao() {
            public int pf(int i) {
                return i * i;
            }
        };
        System.out.println(db.pf(19));
        var db2 = (DbDao) a -> a * a;
        DbDao db3 = e -> e * e;
        System.out.println(db2.pf(3));
        System.out.println(db3.pf(6));
        //接口UnaryOperator 接收对象并返回相同类型的对象
        UnaryOperator<Integer> o = i -> i * i;
        System.out.println(o.apply(3));

        UnaryOperator<String> hello = (s) -> "hello:" + s;
        System.out.println(hello.apply("lisa"));
        //Comparator 接口抽象方法 int : compare(T o1,T o2)比较用来排序的两个参数
        //根据第一个参数< 、= 、>第二个参数分别返回 -1，0，1
        Comparator<Integer> c = Integer::compare;
        System.out.println(c.compare(1, 0));
    }
}
