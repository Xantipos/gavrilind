package ru.pseudo;

public class Triangle implements Shape  {


    public  String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("   + ");
        sb.append(" +   +");
        sb.append("+     +");
        sb.append("+++++++");
        return sb.toString();
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        String square = triangle.draw();
        System.out.println(square);
    }

}
