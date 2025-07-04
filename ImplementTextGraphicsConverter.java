package ru.netology.graphics;

import ru.netology.graphics.image.BadImageSizeException;
import ru.netology.graphics.image.TextColorSchema;
import ru.netology.graphics.image.TextGraphicsConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class ImplementTextGraphicsConverter implements TextGraphicsConverter {
    private Double maxAspectRatio;
    private Integer maxWidth;
    private Integer maxHeight;
    private TextColorSchema textSchema;
    private int width;
    private double maxRatio;
    private int height;

    public String convert(String url) throws IOException, BadImageSizeException {
        BufferedImage image = ImageIO.read(new URL(url));

        int aspectRatio = image.getWidth() / image.getHeight();
        if (aspectRatio > maxAspectRatio) {
            throw new BadImageSizeException(aspectRatio, maxAspectRatio);
        }
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();

        double differenceWidth = image.getWidth() / maxWidth;
        double defferenceHeight = image.getHeight() / maxHeight;
        double defference = Math.max(differenceWidth, defferenceHeight);

        if (image.getWidth() / image.getHeight() > maxHeight) {
            if (image.getWidth() > maxWidth) {
                newWidth = (int) (image.getWidth() / defference);
                newHeight = (int) (image.getHeight() / defference);
            }
         Image scaledImage = image.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
            BufferedImage bwImg=new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

            Graphics2D Graphics=bwImg.createGraphics();

            Graphics.drawImage(scaledImage,0,0,null);

          RenderedImage imageObject=bwImg;
          ImageIO.write(imageObject,"png",new File ("out.png"));

          if (textSchema==null) {
              ImplementsTextColorSchema implementsTextColorSchema=new ImplementsTextColorSchema();
              setTextColorSchema(implementsTextColorSchema);
          }

          WritableRaster bwRaster=bwImg.getRaster();
          char [][] symbols=new char[newWidth][newHeight];
          for (int w=0;w<bwImg.getWidth();w++){
              for (int h=0;h<bwImg.getHeight();h++){
           int color=bwRaster.getPixel(w,h,new int[3])[0];
              }
          }



        }
        return url;
    }

    @Override
    public void setMaxWidth(int width) {
        this.width=width;

    }

    @Override
    public void setMaxHeight(int height) {
        this.height=height;

    }

    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio=maxRatio;

    }

    @Override
    public void setTextColorSchema(TextColorSchema schema) {
        this.textSchema=schema;

    }


}

