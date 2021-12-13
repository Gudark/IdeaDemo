/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */
package eg1;

import java.io.File;

/**
 * <p>Project: Idea Demo - Dir1
 * <p>Powered by Gudark On 2021/12/13 16:20
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Dir1 {
    public static void main(String[] args) {

        File f1 = new File("AAAAA");
        //判断目录是否存在
        if (f1.exists()) {
            System.out.println("该目录已存在");
        } else {
            //建立一级目录，位于项目所在根目录下
            f1.mkdir();
            System.out.println("AAAAA目录建立成功");
            System.out.println(f1.exists());
        }

        //建立多级目录
        File f2 = new File("f:/BBBBB/BBBB/BBB");
        if (!f2.exists()) f2.mkdirs();

        //建立多级目录
        File f3 = new File("f:/CCCCC/CCCC");
        if (f3.mkdirs()) {
            System.out.println("目录建立成功");
        } else {
            System.out.println("此目录已存在，无需建立");
        }

        //删除目录，只能删除一级空目录
        File f4 = new File("f:DDDDD/DDDD");
        if (f4.exists() && f4.isDirectory()) {
            f4.delete();//删除文件或删除一级空目录
        }
        File f5 = new File("f:/EEEEE");
        f5.delete();
    }
}

