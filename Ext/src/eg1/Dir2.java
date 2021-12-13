/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */
package eg1;

import java.io.IOException;

/**
 * <p>Project: Idea Demo - Dir2
 * <p>Powered by Gudark On 2021/12/13 16:55
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Dir2 {
    public static void main(String[] args) throws IOException {
        //windows 系统下删除非空目录
        Runtime run = Runtime.getRuntime();
        //路径或文件名中含有空格时，可使用 \"  \" 双引号包含（反斜杠转译），注意此时路径中需全部使用 \ 保持一致
        run.exec("cmd /k rd /S /Q f:\\\"Idea Demo\"\\AAAAA");

        //根据系统使用相应方法删除非空目录
        //Runtime run = Runtime.getRuntime();
        //String dir="f:DDDDD";
        String dir = "f:\\CCCCC";//？左斜杠无法识别，双右斜杠可行？
        String os = System.getProperty("os.name");
        System.out.println(os);
        //判断系统
        if (os.contains("Windows")) {
            run.exec(String.format("cmd /k rd /S /Q %s", dir));
            //run.exec("cmd /k rd /S /Q f:\\CCCCC");
            System.out.println("执行Windows");
        } else if (os.contains("Linux")) {
            run.exec(String.format("rm -rf %s", dir));
            System.out.println("执行Linux");
            System.out.println("delete CCCCC");
        }
    }
}
