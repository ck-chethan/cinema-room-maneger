package com.chethan;
// https://google.github.io/styleguide/javaguide.html
public class Main {
    static int NO_OF_ROWS = 7;
    static int NO_OF_COLS = 8;
    public static void main(String[] args) {
        int[][] rooms = new int[NO_OF_ROWS][NO_OF_COLS];
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int i=1; i<=NO_OF_COLS; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 1; i <= NO_OF_ROWS; i++){
            System.out.print(i+" ");
            for(int j=1; j<=NO_OF_COLS; j++){
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}
