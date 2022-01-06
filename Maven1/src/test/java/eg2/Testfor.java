/*
 * Copyright (c) 2018, 2022, github.com/Gudark All rights reserved.
 *
 */
package eg2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>Project: HelloWord - Testfor
 * <p>Powered by Gudark On 2022/1/4 18:57
 * <p>Created by IntelliJ IDEA
 * <p>Description : This is description of class
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Testfor {

    public static void main(String[] args) {
        List list = new LinkedList();
        for (int i = 0; i < 1000000; i++) {
            Map map = new HashMap();
            list.add(map);
        }
        //开始for循环起始时间（纳秒）
        //for (int i =0; i<list.size();i++)
        long start = System.nanoTime();
        {
        }
        //for (int i =0; i<list.size();++i) { }
        //for (int i = list.size(); i-- > 0;) { }
        //for (int i = list.size(); i > 0; i--) {}
        for (int i = list.size(); --i >= 0; ) {
        }
        //for循环结束时间（纳秒）
        long end = System.nanoTime();
        //输出循环所需时间
        System.out.println(end - start);
    }
}