/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>Project: Maven1 - Qrcode
 * <p>Powered by Gudark On 2021/12/18 11:30
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Qrcode {
    public static void main(String[] args) throws IOException, WriterException, ChecksumException, NotFoundException, FormatException {
       String  qr="f:/qr.png";

        //生成QRcode
       var bm=new QRCodeWriter().encode("https://github.com/Gudark", BarcodeFormat.QR_CODE,100,100);
       var mtir= MatrixToImageWriter.toBufferedImage(bm);
       ImageIO.write(mtir,"png",new FileOutputStream(qr));

       //读取QRcode
        var iio=ImageIO.read(new File("f:/Download/qrcode.png"));
        var bils=new BufferedImageLuminanceSource(iio);
        var binarizer=new HybridBinarizer(bils);
        var binaryBitmap=new BinaryBitmap(binarizer);
        var result=new QRCodeReader().decode(binaryBitmap);
        System.out.println(result.getText());
    }
}
