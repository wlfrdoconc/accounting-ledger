package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.Main.displayLoading;

public class LedgerHandler {

    // Display the ledger menu
    public static void displayLedgerMenu(ArrayList<Transaction> transactions, Scanner read) {

        // Empty string to store the user's current choice
        String currentChoice = "";

        // While loop to keep going through the menu until H is entered
        while (!currentChoice.equalsIgnoreCase("H")) {

            System.out.println("""
        

        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠤⠒⠒⠒⠒⠒⠤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⢀⡲⢋⠝⠋⣛⣳⡄⠀⠀⠀⠀⠀⠀⠉⠓⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⢀⠠⣴⠗⢀⠥⠂⢁⠤⠤⠤⠁⠀⠀⠀⠀⠀⠀⠀⠀⣛⠛⠉⠗⠒⠲⢤⣀⠀
        ⠰⠃⠐⠀⠋⡠⠀⠮⠤⠤⠤⠤⡤⡄⠀⠀⠀⠀⠀⠀⢠⣽⠄⠀⠀⠀⠀⠀⢸⡆
        ⠀⠜⠀⠀⠈⠀⢠⣤⣔⣒⡒⠒⠂⠁⠀⡀⢀⣀⣤⣶⣿⡟⠀⠀⠀⠀⠀⢀⡼⠀
        ⠈⠀⠀⠀⠀⣰⡿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠉⠁⠀⠀⠀⢄⡴⠋⠀⠀
        ⠀⠀⠀⠀⣰⠋⠀⠀⠀⠈⠙⠛⠛⠛⠛⠋⠉⠀⠀⠀⠀⢀⣠⣴⡊⠁⠀⠀⠀⠀
        ⠀⡠⠐⠉⢸⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⣤⣶⣿⣿⣿⡻⡄⠀⠀⠀⠀
        ⠀⠁⠀⠀⣿⢹⣿⣿⣿⣶⣦⣶⣶⣶⣶⣶⣙⠋⠴⠛⣿⢛⡿⠬⠃⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠈⠘⠹⣿⣿⠛⠛⠛⢿⡇⠀⠉⠀⠘⠉⢰⣯⡊⠙⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠈⠱⡄⠀⠀⠘⠃⠀⠀⠀⠀⠠⠛⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⢲⣄⠀⠒⠂⠀⣀⢴⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⣀⣀⣀⣀⣈⠀⢻⣿⣶⣴⣾⡟⢸⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⢀⡎⠀⢀⣠⡤⠂⢠⠈⢿⣿⡿⣿⠃⠀⠙⣀⣀⣀⡀⠀⠙⣄⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⢠⠉⠉⢇⠀⠈⡇⠘⣏⠀⡿⡰⠀⠀⢀⠛⠛⠻⣆⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⢸⠉⠉⠉⠗⠒⢿⡀⠸⡈⣠⠧⠞⠉⡏⠉⠉⠉⢹⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠁⠀⠉⠉⠀⠀⠈⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀

        ==========================================
                      AFTERPANEL
                     SHOP LEDGER
        ==========================================
                   Every yen counts.

        A) All Transactions
        D) Deposits
        P) Payments
        R) Reports
        H) Back to Home

        ==========================================
        """);

            System.out.print("Enter your choice (A, D, P, R, H): ");


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
                    // displayLoading() animation
                    displayLoading("Accessing the AfterPanel Ledger...");

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

        displayTableHeader();

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

        displayTableHeader();

        // Variable to store the total deposit amount
        double depositTotal = 0;

        // Checks if there are any transactions
        if (transactions.isEmpty()) {
            System.out.println("Transactions not found");
            return;
        }

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {
            if (transaction.getAmount() > 0) { // Only displays transactions with positive amounts
                System.out.println(transaction);

                // Add deposit amount to the total
                depositTotal += transaction.getAmount();
            }
        }

        // Display the total deposits
        System.out.printf("%nTotal Deposits: $%.2f%n", depositTotal);
        System.out.println("-".repeat(93));

    }

    // Display payments method
    public static void displayPayments(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== All Payments ====");

        displayTableHeader();

        // Variable to store the total payment amount
        double paymentTotal = 0;

        // Checks if there are any transactions
        if (transactions.isEmpty()) {
            System.out.println("Transactions not found");
            return;
        }

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);

                // Add payment amount to the total
                paymentTotal += transaction.getAmount();
            }
        }

        // Display the total payments
        System.out.printf("%nTotal Payments: -$%.2f%n", Math.abs(paymentTotal));
        System.out.println("-".repeat(93));
    }

    // Reusable table header display for transactions
    public static void displayTableHeader() {

        System.out.println("-".repeat(93));

        System.out.printf("%-12s %-10s %-30s %-25s %12s%n",
                "Date", "Time", "Description", "Vendor", "Amount");

        System.out.println("-".repeat(93));
    }
}
