package eg1;/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>Project: Maven1 - eg1.TaiChi
 * <p>Powered by Gudark On 2021/12/20 19:46
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class TaiChi {
    public static void main(String[] args) {
        int canvas_w = 800;
        int canvas_h = 800;
        var bfi = new BufferedImage(canvas_w, canvas_h, 2);
        var g = bfi.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);

        //背景
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, canvas_w, canvas_h);
        //定位线
        /*g.setColor(Color.BLUE);
        g.drawLine(0, 0, canvas_w, canvas_h);
        g.drawLine(canvas_w, 0, 0, canvas_h);*/

        //主图
        int r = 200;
        int ox = canvas_w / 2;
        int oy = canvas_h / 2;
        g.setColor(Color.white);
        g.fillArc(ox - r, oy - r, 2 * r, 2 * r, 270, 180);//阳仪扇形
        g.setColor(Color.black);
        g.fillArc(ox - r, oy - r, 2 * r, 2 * r, 90, 180);//阴仪扇形
        g.fillOval(ox - r / 2, (oy - r / 2) - r / 2, r, r);//阴鱼头部圆形
        g.setColor(Color.white);
        g.fillOval(ox - r / 2, (oy + r / 2) - r / 2, r, r);//阳鱼头部圆形
        g.fillOval(ox - r / 4, (oy - r / 2) - r / 4, r / 2, r / 2);//阳仪眼
        g.setColor(Color.black);
        g.fillOval(ox - r / 4, (oy + r / 2) - r / 4, r / 2, r / 2);//阴仪眼

        //文字
        var is = TaiChi.class.getClassLoader().getResourceAsStream("fonts/筑紫A丸+Sleek（修正）.ttf");
        try {
            Font font = Font.createFonts(is)[0].deriveFont(Font.BOLD, 50f);
            g.setFont(font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        g.setColor(Color.red);
        String text = "天地无极，乾坤借法";
        //取得字体属性，返回字体宽度
        int tw = g.getFontMetrics().stringWidth(text);
        g.drawString(text, (canvas_w - tw) / 2, 700);

        g.dispose();
        try {
            ImageIO.write(bfi, "png", new File("f:/taichi.png"));
            Runtime.getRuntime().exec("cmd /k start f:/taichi.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
