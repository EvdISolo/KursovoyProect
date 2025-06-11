package ru.netology.graphics.image;

public class ColorSchema implements TextColorSchema{

    public String ColorSchema(int g) {
        if (g == -1) {
            return " ";
    }
        String color = " ";
        if (g >= 240) {
            color = " ";
        } else if (g >= 210) {
            color = ".";
        } else if (g >= 190) {
            color = "*";
        } else if (g >= 170) {
            color = "+";
        } else if (g >= 120) {
            color = "^";
        } else if (g >= 110) {
            color = "&";
        } else if (g >= 80) {
            color = "8";
        } else if (g >= 60) {
            color = "#";
        } else {
            color = "@";
        }
        return color;
    }

    @Override
    public char convert(int color) {
        return 0;
    }
}

