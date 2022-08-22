package com.ruchiket;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte PERCENT = 100;
        final byte MONTHS = 12;

        Scanner scanner = new Scanner(System.in);

        // input for Principal Amount
        System.out.print("Enter Principal Amount : ");
        int principalAmount = scanner.nextInt();

        // input for Interest Rate
        System.out.print("Enter Interest Rate on Principal Amount : ");
        float annualInterestRate = scanner.nextFloat(); // for 1 month
        float monthlyInterest = annualInterestRate / PERCENT /MONTHS;

        // input for Period
        System.out.print("Enter Period in years : ");
        byte period = scanner.nextByte() ;
        int noOfMonths = period * MONTHS;

    // find Mortgage
        double mortgage = principalAmount
                * (monthlyInterest*Math.pow((1 + monthlyInterest), noOfMonths)
                / (Math.pow((1 + monthlyInterest),noOfMonths) - 1));

    // show Mortgage
        System.out.println("Mortgage : " + Math.round(mortgage));
    }
}