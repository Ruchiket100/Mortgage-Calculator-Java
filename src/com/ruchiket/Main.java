package com.ruchiket;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final byte PERCENT = 100;
    static final byte MONTHS = 12;
    public static void main(String[] args) {
        int principalAmount = (int)getValue("Principal : ", 1000, 1_000_000);
        float annualInterest = (float)getValue("Interest : ", 1,30);
        byte period = (byte)getValue("Period (years) : ", 0 , 30);

        double mortgage = calculateMortgage(principalAmount, annualInterest, period);
        double[] paymentSchedule = calculatePaymentSchedule( principalAmount, annualInterest, period);

        printCalculations(mortgage, paymentSchedule);
    }
    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years){

        float monthlyInterest = getMonthlyInterest(annualInterestRate);
        short noOfMonths = getNoOfMonths(years);
        double mortgage =  principal
                * (monthlyInterest*Math.pow((1 + monthlyInterest), noOfMonths)
                / (Math.pow((1 + monthlyInterest),noOfMonths) - 1));
        return  Math.round(mortgage);
    }

    public static double[] calculatePaymentSchedule(
            int principal,
            float annualInterestRate,
            byte years
    ){
        float monthlyInterest = getMonthlyInterest(annualInterestRate);
        short noOfMonths = getNoOfMonths(years);
        double[]  remainingLoan = new double[noOfMonths];
        for(short p = 1; p <= noOfMonths; p++){
            remainingLoan[p - 1] = (principal*((Math.pow((1 + monthlyInterest), noOfMonths)
                    - Math.pow((1 + monthlyInterest), p))
                    /(Math.pow((1 + monthlyInterest), noOfMonths) -1)));

        }
        return remainingLoan;
    }

    public static void printCalculations (double mortgage, double[] paymentSchedules){
        System.out.println("\nMORTGAGE \n------------");
        System.out.println("Monthly Payments : " + covertToCurrency(mortgage));
        System.out.println("\nPAYMENT SCHEDULE \n-----------------------");
        for (double payment : paymentSchedules){
            System.out.println(covertToCurrency(payment));
        }
    }
    public static String covertToCurrency(double value){
        return NumberFormat.getCurrencyInstance().format(value);
    }


    public static float getMonthlyInterest(float annualInterestRate){
        return annualInterestRate / PERCENT / MONTHS;
    }

    public static short getNoOfMonths (byte period){
        return (short)(period * MONTHS);
    }

    public static double getValue (String prompt, int min , int max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max )
                break;
            System.out.println("Enter the amount between" + min + " and " + max);

        }
        return value;
    }
}

// Comparison Operators  - == , !=
// Logical Operators - && (and) , || (or), ! (not)
// If Statements if(temp > 30){}else if(){}else{}
// Ternary Operator  String highTemp = temp > 40 ? true : false;
// Switch Statement  switch (variable){ case "declaration" : __ ; break; }
// For Loop
// While Loop - use when you don't know how many times you want to repeat something
// Do While Loop - do{} while(); - this loop at least run ones although the condition is false
// Break and Continue break; continue;
// ForEach  for (String fruit : fruits){}


// Clean Coding :
/* Creating Methods
*  Refactoring
* */