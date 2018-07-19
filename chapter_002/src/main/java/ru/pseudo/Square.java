package ru.pseudo;

public class Square implements Shape  {

    public static String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("++++");
        sb.append("+  +");
        sb.append("+  +");
        sb.append("++++");
        return sb.toString();
    }

    public static void main(String[] args) {
        String square = Square.draw();
        System.out.println(square);
    }

}
