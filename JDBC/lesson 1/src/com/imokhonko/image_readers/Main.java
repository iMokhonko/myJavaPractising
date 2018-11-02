package com.imokhonko.image_readers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File imageFile = new File("saved.jpg");
        BufferedImage image = ImageIO.read (imageFile);
        ImageIO.write (image, "png", new File("image.png"));

    }

}