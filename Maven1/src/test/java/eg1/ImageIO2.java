package eg1;
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
 * <p>Project: Maven1 - eg1.ImageIO2
 * <p>Powered by Gudark On 2021/12/18 14:37
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ImageIO2 {
    public static void main(String[] args) {

        int w = 618;
        int h = 382;
        var bfi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        var g = bfi.createGraphics();

        //消除锯齿，平滑度
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);

        //for循环作随机大小和透明度圆形
        var rand = new Random();
        for (int i = 0; i <= 120; i++) {
            int x = rand.nextInt(w - 100);//圆心横坐标，减 防止圆超出显示范围
            int y = rand.nextInt(h - 100);//圆心纵坐标
            int d = rand.nextInt(90) + 10;//圆的长宽设定（相等即为正圆直径），加 防止直径为零（补偿值）
            //var c = new Color(0xff, 0, 0, rand.nextInt(128));//红色+透明度范围，显示粉红色
            //随机RGB三色和透明度圆形
            int rgb = rand.nextInt(3);
            var c = switch (rgb) {
                case 0 -> new Color(0xff, 0, 0, rand.nextInt(128));
                case 1 -> new Color(0, 0xff, 0, rand.nextInt(128));
                default -> new Color(0, 0, 0xff, rand.nextInt(128));
            };
            g.setColor(c);
            //fill 填充圆（实心圆），圆心坐标+长宽
            g.fillOval(x, y, d, d);
        }
        g.dispose();
        try {
            ImageIO.write(bfi, "png", new File("f:/eg2.png"));
            Runtime.getRuntime().exec("cmd /k start f:/eg2.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
