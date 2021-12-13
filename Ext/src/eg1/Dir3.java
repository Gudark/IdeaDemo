/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */
package eg1;

import java.io.File;

/**
 * <p>Project: Idea Demo - Dir3
 * <p>Powered by Gudark On 2021/12/13 19:06
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Dir3 {
    public static void main(String[] args) {
        //File f = new File("f:/DDDDD/DDDD/DDD/DD/D");
        File f = new File("f:\\DDDDD");
        f.mkdirs();
        del(f);
    }

    public static void del(File file) {
        //判断 传递进来的若存在且为目录 则判断内部是否有东西
        if (file.exists() && file.isDirectory()) {
            //遍历目录下的文件和文件夹
            for (File f : file.listFiles()) {
                //判断 是文件夹，则递归调用
                if (f.isDirectory()) {
                    del(f);
                } else {
                    System.out.println("已经被删除的文件1："+f);
                    //否则 是文件，直接删除
                    f.delete();
                }
            }
        } else {
            System.out.println("已经被删除的文件2："+file);
            //否则 是文件，直接删除
            file.delete();//？此行代码可删去，未发现生效情况？
        }
        System.out.println("已经被删除的文件3："+file);
        //否则 为文件，直接删除
        file.delete();
    }
}