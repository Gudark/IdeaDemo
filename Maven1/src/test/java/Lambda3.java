/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.*;

/**
 * <p>Project: Maven1 - Lambda3
 * <p>Powered by Gudark On 2021/12/23 20:05
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Lambda3 {
    public static void main(String... args) {
        Integer[] num = new Integer[]{1, 4, 2, 7, 23, 5, 9};
        System.out.println(Arrays.toString(num));
        //升序
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));

        //Arrays.sort(num,(a,b) -> a - b)
        //Arrays.sort(num, Comparator.comparingInt(a -> a));
        Arrays.sort(num, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        System.out.println(Arrays.toString(num));
        //降序
        Arrays.sort(num, (a, b) -> b - a);
        /*
        Arrays.sort(num,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        }.reversed());
        */
        System.out.println(Arrays.toString(num));
        //乱序
        var rand = new Random();
        Arrays.sort(num, (a, b) -> rand.nextBoolean() ? -1 : 1);
        Arrays.sort(num, (a, b) -> rand.nextBoolean() ? -1 : 1);
        Arrays.sort(num, (a, b) -> rand.nextBoolean() ? -1 : 1);
        Arrays.sort(num, (a, b) -> rand.nextBoolean() ? -1 : 1);
        System.out.println(Arrays.toString(num));

        //Array 转换为 List 使用 shuffle 打乱顺序，并转换为 Array
        var list = new ArrayList<>(Arrays.stream(num).toList());
        Collections.shuffle(list);
        list.toArray(num);
        System.out.println(Arrays.toString(num));
    }
}
