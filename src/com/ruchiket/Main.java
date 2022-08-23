package com.ruchiket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principalAmount = (int)getValue("Principal : ", 1000, 1_000_000);
        float annualInterest = (float)getValue("Interest : ", 1,30);
        byte period = (byte)getValue("Period (years) : ", 0 , 30);

        double mortgage = calculateMortgage(principalAmount, annualInterest, period);

        System.out.println("Mortgage : " + mortgage);
    }
    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years){
        final byte PERCENT = 100;
        final byte MONTHS = 12;
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS;
        short noOfMonths = (short)(years * MONTHS);
        double mortgage =  principal
                * (monthlyInterest*Math.pow((1 + monthlyInterest), noOfMonths)
                / (Math.pow((1 + monthlyInterest),noOfMonths) - 1));
        return  Math.round(mortgage);
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