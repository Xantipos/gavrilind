package ru.job4j.loop;
public class Board {
    public String paint(int width, int height) {
        int i;
        int j;
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {

                if (i + j == 0 || i + j == 2 || i + j == 4) {
                 
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // ????????? ??????? ?? ????? ??????.
            screen.append(ln);
        }
        return screen.toString();
    }
}

