package ru.netology.graphics;

import ru.netology.graphics.image.BadImageSizeException;
import ru.netology.graphics.image.TextColorSchema;
import ru.netology.graphics.image.TextGraphicsConverter;
import ru.netology.graphics.server.GServer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new TextGraphicsConverter() {
            @Override
            public String convert(String url) throws IOException, BadImageSizeException {
                return "";
            }

            @Override
            public void setMaxWidth(int width) {

            }

            @Override
            public void setMaxHeight(int height) {

            }

            @Override
            public void setMaxRatio(double maxRatio) {

            }

            @Override
            public void setTextColorSchema(TextColorSchema schema) {

            }


        }; // Создаём объект конвертера




                GServer server = new GServer(converter); // Создаём объект сервера
                server.start(); // Запускаем


                String url = "https://raw.githubusercontent.com/netology-code/java-diplom/main/pics/simple-test.png";
                String imgTxt = converter.convert(url);
                System.out.println(imgTxt);
            }
        }


