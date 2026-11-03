package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class LedgerHandler {

    // Display the ledger menu
    public static void displayLedgerMenu(ArrayList<Transaction> transactions, Scanner scanner) {

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

            // Read the user's entered selection
            currentChoice = scanner.nextLine().trim(); // Removes any leading or trailing spaces

            // Calls the correct method based on user's menu selection
            switch (currentChoice.toUpperCase()) {
                case "A":
                    // displayAll() placeholder
                    System.out.println("PLACEHOLDER for displayAll()");
                    break;
                case "D":
                    // displayDeposits() placeholder
                    System.out.println("PLACEHOLDER for displayDeposits()");
                    break;
                case "P":
                    // displayPayments() placeholder
                    System.out.println("PLACEHOLDER for displayPayments()");
                    break;
                case "R":
                    // displayReports() placeholder
                    System.out.println("PLACEHOLDER for displayReports()");
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Please enter A, D, P, R, or H.");
            }
        }
    }

    // Display all entries method
    public static void displayAll() {

    }

    // Display deposits method
    public static void displayDeposits() {

    }

    // Display payments method
    public static void displayPayments() {

    }

    // Display reports method
    public static void displayReports() {

    }
}
