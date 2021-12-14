/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>Project: Maven1 - ImageIO3
 * <p>Powered by Gudark On 2021/12/18 16:03
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ImageIO3 {
    public static void main(String[] args) {
        var bfi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        var g = bfi.getGraphics();
        g.setColor(Color.cyan);
        //猫猫头
        g.fillRect(250 - 50, 250 - 50, 100, 100);
        //擦除某一区域，擦除后显示背景色
        g.clearRect(250 - 37, 250 - 37, 74, 74);

        //根据给定的多个点绘制折线:点（200，200），点（215，175），点（230，200）...
        int[] xPoints = new int[]{200, 215, 230, 270, 285, 299};
        int[] yPoints = new int[]{200, 175, 200, 200, 175, 200};
        int nPoints = 6;
        g.drawPolyline(xPoints, yPoints, nPoints);
        //绘制一个圆角矩形,起始坐标,长宽,弧宽弧高
        g.drawRoundRect(220,230,20,10,5,5);
        //填充一个圆角矩形
        g.fillRoundRect(260,230,20,10,5,5);
        //绘制一个3D矩形,最后一个boolean参数为突起或凹陷
        g.draw3DRect(230,255,40,30,true);
        //填充一个3D矩形
        g.fill3DRect(235,260,30,20,true);
        g.dispose();
        try {
            ImageIO.write(bfi, "png", new File("f:/eg3.png"));
            Runtime.getRuntime().exec("cmd /k start f:/eg3.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
