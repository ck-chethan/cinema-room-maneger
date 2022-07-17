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
        int totalSeats = noOfRows * noOfCols;
        int ticketsSold = 0;
        int totalIncome = totalSeats <= 60 ? (10 * totalSeats) : (noOfRows % 2 == 0) ? (9 * totalSeats) : (((noOfRows/2) * noOfCols * 10) + (noOfRows+1)/2 * noOfCols * 8);
        int currentIncome = 0;

        while (true) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int menu = sc.nextInt();
            if (menu == 0) {
                break;
            }
            if (menu == 1) {
                printRoom(rooms, noOfRows, noOfCols);
            } else if (menu == 2) {
                while (true) {
                    System.out.println();
                    System.out.println("Enter a row number:");
                    int rowNum = sc.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int colNum = sc.nextInt();

                    if (rowNum > noOfRows || rowNum < 0 || colNum > noOfCols || colNum < 0) {
                        System.out.println();
                        System.out.println("Wrong input!");
                        continue;
                    }

                    if ("B".equals(rooms[rowNum-1][colNum-1].trim())) {
                        System.out.println();
                        System.out.println("That ticket has already been purchased!");
                        continue;
                    }
                        int ticketCost;
                        if (noOfRows * noOfCols <= 60) {
                            ticketCost = 10;
                        } else {
                            if (noOfRows % 2 == 0) {
                                if (rowNum - 1 <= noOfRows / 2) {
                                    ticketCost = 10;
                                } else {
                                    ticketCost = 8;
                                }
                            } else {
                                if (rowNum - 1 + 1 <= noOfRows / 2) { // +1 because if rows are odd we need to count extra 1 row in back.
                                    ticketCost = 10;
                                } else {
                                    ticketCost = 8;
                                }
                            }
                        }
                        System.out.println();
                        System.out.println("Ticket price: $" + ticketCost);
                        rooms[rowNum - 1][colNum - 1] = "B ";
                        ticketsSold += 1;
                        currentIncome += ticketCost;

                    break;
                }
            } else if (menu == 3) {
                System.out.println();
                System.out.println("Number of purchased tickets: " + ticketsSold);
                double percentage = (double) ticketsSold * 100 / (double) totalSeats;
                System.out.println("Percentage: " + String.format("%.2f", percentage) + '%');
                System.out.println("Current income: $" + currentIncome);
                System.out.println("Total income: $" + totalIncome);
            }
        }
    }

    public static void printRoom(String[][] rooms, int noOfRows, int noOfCols) {
        System.out.println();
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
