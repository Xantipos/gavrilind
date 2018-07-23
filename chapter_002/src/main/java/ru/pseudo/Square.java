package ru.pseudo;

public class Square implements Shape  {

    public  String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("++++");
        sb.append("+  +");
        sb.append("+  +");
        sb.append("++++");
        return sb.toString();
    }

    public static void main(String[] args) {
        Square sw = new Square();
        String square = sw.draw();
        System.out.println(square);
    }

}
