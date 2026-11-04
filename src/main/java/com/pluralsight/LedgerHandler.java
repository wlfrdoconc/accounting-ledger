package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class LedgerHandler {

    // Display the ledger menu
    public static void displayLedgerMenu(ArrayList<Transaction> transactions, Scanner read) {

        // Empty string to store the user's current choice
        String currentChoice = "";

        // While loop to keep going through the menu until H is entered
        while (!currentChoice.equalsIgnoreCase("H")) {
            System.out.println();
            System.out.println("==== Ledger Menu ====");
            System.out.println("A) Display all entries");
            System.out.println("D) Display deposits");
            System.out.println("P) Display payments");
            System.out.println("R) Display reports");
            System.out.println("H) Return to the home screen");
            System.out.print("\nEnter your choice: ");

            // Read the user's entered selection
            currentChoice = read.nextLine().trim(); // Removes any leading or trailing spaces

            // Calls the correct method based on user's menu selection
            switch (currentChoice.toUpperCase()) {
                case "A":
                    // displayAll()
                    displayAll(transactions);
                    break;
                case "D":
                    // displayDeposits()
                    displayDeposits(transactions);
                    break;
                case "P":
                    // displayPayments()
                    displayPayments(transactions);
                    break;
                case "R":
                    // displayReports()
                    ReportsHandler.displayReportsMenu(transactions, read);
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Please enter A, D, P, R, or H.");
            }
        }
    }

    // Display all entries method
    public static void displayAll(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== All Transactions ====");

        // Checks if there are any transactions
        if (transactions.isEmpty()) {
            System.out.println("Transactions not found");
            return;
        }

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {
            System.out.println(transaction);
        }
    }

    // Display deposits method
    public static void displayDeposits(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== All Deposits ====");

        // Checks if there are any transactions
        if (transactions.isEmpty()) {
            System.out.println("Transactions not found");
            return;
        }

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {
            if (transaction.getAmount() > 0) { // Only displays transactions with positive amounts
                System.out.println(transaction);
            }
        }

    }

    // Display payments method
    public static void displayPayments(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== All Payments ====");

        // Checks if there are any transactions
        if (transactions.isEmpty()) {
            System.out.println("Transactions not found");
            return;
        }

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }
}
