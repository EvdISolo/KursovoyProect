package ru.netology.graphics;

import ru.netology.graphics.image.TextColorSchema;

public class ImplementsTextColorSchema implements TextColorSchema {
protected final char ONE ='@';
protected final char TWO ='$';
protected final char THREE ='#';
protected final char FOUR ='%';
protected final char FIVE ='+';
protected final char SIX ='_';
protected final char SEVEN ='.';
    @Override
    public char convert(int color) {
        char [] symbols=new char[] { ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN};
        return 0;
    }
}
