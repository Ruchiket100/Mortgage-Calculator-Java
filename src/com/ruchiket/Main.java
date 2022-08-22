package com.ruchiket;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    // get PrincipalAmount, Interest Rate, Period(years)
        Scanner scanner = new Scanner(System.in);
        // input for Principal Amount\
        System.out.print("Enter Principal Amount : ");
        int principalAmount = scanner.nextInt();
        // input for Interest Rate
        System.out.print("Enter Interest Rate on Principal Amount : ");
        double interestRate = scanner.nextDouble()/1200;
        // input for Period
        System.out.print("Enter Period in years : ");
        int period = scanner.nextByte() * 12;

    // find Mortgage
        double mortgage = principalAmount*(interestRate*Math.pow((1 + interestRate), period)/(Math.pow((1 + interestRate),period) - 1));

    // show Mortgage
        System.out.println("Mortgage : " + Math.floor(mortgage));
    }
}