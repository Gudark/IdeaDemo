/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * <p>Project: Maven1 - ImageIO1
 * <p>Powered by Gudark On 2021/12/17 20:23
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ImageIO1 {
    public static void main(String[] args) {
        //创建画布，尺寸及色彩格式
        //var i = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        var i = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);

        //创建画笔
        //var g = i.getGraphics();
        var g=i.createGraphics();//Graphics2D 提供对图形更复杂的控制

        g.setColor(Color.WHITE); //画笔取色
        g.setColor(new Color(100,0x33,0xff)); //给定颜色
        var rand=new Random(); //随机颜色
        g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
        g.fillRect(0,0,500,500);  //作矩形填充画布作为背景

        g.setColor(Color.cyan);
        //随机颜色 RGB+透明度
        g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

        g.setStroke(new BasicStroke(6)); //线宽
        g.drawLine(0, 0, 500, 500); //画线
        g.drawLine(500,0,0,500);

        g.setStroke(new BasicStroke(10));
        g.setColor(Color.YELLOW);
        g.fillRect(250-25,250-25,50,50);//画矩形
        g.drawRect(250-75,250-75,150,150);

        g.dispose(); //释放占用的资源

        try {
            //将图片文件保存至硬盘
            ImageIO.write(i, "png", new File("f:/eg1.png"));
            //调用系统命令打开图片文件
            Runtime.getRuntime().exec("cmd /k start f:/eg1.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
