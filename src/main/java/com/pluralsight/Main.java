package com.pluralsight;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Scanner

    }

    // Displays the main home screen
    // homeScreen passes loaded transactions from transactions.csv and scanner method
    public static void homeScreen(ArrayList<Transaction> transactions, Scanner scanner) {

        // Empty string to store the user's current choice
        String currentChoice = "";

        // While loop to keep going through the menu until X is entered
        while (!currentChoice.equalsIgnoreCase("X")) {  // Reformat later
            System.out.println();
            System.out.println("==== Welcome to the Accounting Ledger Program! ====");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Access Ledger");
            System.out.println("X) Exit the Application");

            // Read's the user's entered selection
            currentChoice = scanner.nextLine().trim(); // Removes any trailing or leading spaces

            // Calls the correct method based on the user's menu selection
            switch (currentChoice.toUpperCase()) { // Converts all user input to uppercase
                case "D":
                    // addDeposit() placeholder
                    System.out.println("PLACEHOLDER FOR addDeposit()");
                    break;
                case "P":
                    // makePayment() placeholder
                    System.out.println("PLACEHOLDER FOR makePayment()");
                case "L":
                    // displayLedgerMenu() placeholder -> call from LedgerHandler class
                    // LedgerHandler.displayLedgerMenu(transactions, scanner)
                    System.out.println("PLACEHOLDER FOR displayLedgerMenu()");
                case "X":
                    return;
                default:
                    System.out.println("Please enter D, P, L, or X.");
            }

        }


    }

    // Lets the user make a deposit
    public static void addDeposit() {

    }

    // Lets the user make a payment
    public static void makePayment() {

    }
}