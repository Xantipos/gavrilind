package ru.job4j.tictactoe;

import java.util.Arrays;

public class Logic3T {
    private final Figure3T[][] table;


    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {

        boolean[][] cells = new boolean[table.length][table.length];

        for (int i = 0; i<table.length; i++){
            for (int j = 0; j<table.length; j++){
                cells[i][j] = table[i][j].markX();
            }
        }



        if (cells[0][0]==true & cells[1][1]==true & cells[2][2]==true) {
            return true;
        }
        if (cells[0][0] == true & cells[1][0] == true & cells[2][0] == true){
            return true;
        }
        if (cells[1][0] == true & cells[1][1] == true & cells[1][2] == true){
            return true;
        }
        if (cells[2][0] == true & cells[2][1] == true & cells[2][2] == true){
            return true;
        }
        return false;
    }

    public boolean isWinnerO() {
        boolean[][] cells = new boolean[table.length][table.length];

        for (int i = 0; i<table.length; i++){
            for (int j = 0; j<table.length; j++){
                cells[i][j] = table[i][j].markX();
            }
        }
        if (cells[0][0] == false & cells[0][1]==false & cells[0][2]==false) {

            return true;
        }

        return false;
    }

    public boolean hasGap() {

        boolean[][] cells = new boolean[table.length][table.length];
        int ind=0;
        for (int i = 0; i<table.length; i++){
            for (int j = 0; j<table.length; j++){
                if (table[i][j].hasMarkO() && table[i][j].markX()==false){ind++;}
            }
        }
        if(ind==0){return false;}
        return true;
    }
}