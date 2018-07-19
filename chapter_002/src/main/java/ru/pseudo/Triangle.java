package ru.pseudo;

public class Triangle implements Shape  {


    public static String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("   + ");
        sb.append(" +   +");
        sb.append("+     +");
        sb.append("+++++++");
        return sb.toString();
    }

    public static void main(String[] args) {
        String square = Triangle.draw();
        System.out.println(square);
    }

}
