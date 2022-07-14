package com.chethan;
// https://google.github.io/styleguide/javaguide.html

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int noOfRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int noOfCols = sc.nextInt();


        String[][] rooms = new String[noOfRows][noOfCols];
        for (int i=0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                rooms[i][j] = "S ";
            }
        }

        printRoom(rooms, noOfRows, noOfCols);

        System.out.println("Enter a row number:");
        int rowNum = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int colNum = sc.nextInt();

        int ticketCost;
        if(noOfRows*noOfCols <= 60) {
            ticketCost = 10;
        } else {
          if (noOfRows%2 == 0) {
              if (rowNum - 1 <= noOfRows/2) {
                  ticketCost = 10;
              } else {
                  ticketCost = 8;
              }
          }else {
              if (rowNum - 1 + 1 <= noOfRows/2) { // +1 because if rows are odd we need to count extra 1 row in back.
                  ticketCost = 10;
              } else {
                  ticketCost = 8;
              }
          }
        }
        System.out.println("Ticket price: $"+ticketCost);
        rooms[rowNum-1][colNum-1] = "B ";

        printRoom(rooms, noOfRows, noOfCols);
    }

    public static void printRoom(String[][] rooms, int noOfRows, int noOfCols) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i=1; i <= noOfCols; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 1; i <= noOfRows; i++) {
            System.out.print(i+" ");
            for(int j = 1; j <= noOfCols; j++) {
                System.out.print(rooms[i-1][j-1]);
            }
            System.out.println();
        }
    }
}
