package com.chethan;
// https://google.github.io/styleguide/javaguide.html

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int noOfRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int noOfCols = sc.nextInt();
        int profit;
        if(noOfRows*noOfCols <= 60){
            profit = noOfRows*noOfCols*10;
        } else {
          if(noOfRows%2 == 0){
              profit = noOfRows*noOfCols*9;
          }else{
              profit = (noOfRows/2)*noOfCols*10;
              profit += ((noOfRows+1)/2)*noOfCols*8;
          }
        }
        System.out.println("Total income:");
        System.out.print("$"+profit);
//        int[][] rooms = new int[noOfRows][noOfCols];
//        System.out.println("Cinema:");
//        System.out.print("  ");
//        for(int i=1; i<=noOfCols; i++){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        for(int i = 1; i <= noOfRows; i++){
//            System.out.print(i+" ");
//            for(int j=1; j<=noOfCols; j++){
//                System.out.print("S ");
//            }
//            System.out.println();
//        }
    }
}
