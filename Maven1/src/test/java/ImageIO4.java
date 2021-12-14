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
 * <p>Project: Maven1 - ImageIO4
 * <p>Powered by Gudark On 2021/12/20 10:54
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class ImageIO4 {
    public static void main(String[] args) throws IOException, FontFormatException {
        //将 maven项目的resources/fonts/*.ttf 加载为输入流，getClassLoader()找到类加载器
        /**
         * Class.getResourceAsStream(String path):不以 / 开头时默认是从此类所在的包下取资源，以 / 开头则是从ClassPath根下获取；
         * 其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源；
         * Class.getClassLoader.getResourceAsStream(String path):默认则是从ClassPath根下获取，path不能以 / 开头，最终是由ClassLoader获取资源
         */
        var is = ImageIO4.class.getClassLoader().getResourceAsStream("fonts/筑紫A丸+Sleek（修正）.ttf");
        //取得字体，设置字体样式和字号
        Font font=Font.createFonts(is)[0].deriveFont(Font.BOLD,30f);
        int w=500;
        int h= 500;
        var bfi=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        var g=bfi.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);

        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("欲买桂花同载酒",50,50);
        g.dispose();

        ImageIO.write(bfi,"png",new File("f:font_eg1.png"));
        Runtime.getRuntime().exec("cmd /k start f:font_eg1.png");
    }
}
