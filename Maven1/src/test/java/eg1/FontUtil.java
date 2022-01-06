package eg1;
/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.awt.*;
import java.io.IOException;

/**
 * <p>Project: Maven1 - eg1.FontUtil
 * <p>Powered by Gudark On 2021/12/21 16:27
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class FontUtil {
    /**
     * @Description: 根据给定的ttf文件，设置字体格式
     * @Author     : Gudark
     * @Date       : 2021/12/21  19:58
     * @Param url
     * @param style
     * @param size
     * @return java.awt.Font
     */
    public static Font getFont(String url, int style, int size) {
        //通过线程读取流
        /*currentThread() 只是Thread 的一个静态方法，返回的是一个实例（执行当前代码指令的线程引用），一般都是在没有线程对象又需要获得线程信息时使用
         * getContextClassLoader 是当前线程的类加载器（避开双亲委派模型）
         * getResourceAsStream(String name) 相对当前项目的 classpath 的相对路径来查找资源*/
        var is = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
        Font font = new Font("微软雅黑", style, size);
        try {
            font = Font.createFont(0, is).deriveFont(Font.BOLD, (float) size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return font;
    }
}
