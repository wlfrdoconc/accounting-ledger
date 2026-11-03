package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportsHandler {

    // Reports menu method
    public static void displayReportsMenu(ArrayList<Transaction> transactions, Scanner read) {

        // Empty string to store the user's current choice
        String currentChoice = "";

        // While loop to keep the menu running until 0 is entered by the user
        while (!currentChoice.equals("0")) {
            System.out.println();
            System.out.println("==== Reports Menu ====");
            System.out.println("1) Display month to date transactions");
            System.out.println("2) Display previous month transactions");
            System.out.println("3) Display year to date transactions");
            System.out.println("4) Display previous year transactions");
            System.out.println("5) Search transactions by vendor");
            System.out.println("6) Custom search"); // BONUS DO LATER

            // Reads the user's entered selection
            currentChoice = read.nextLine().trim(); // Removes any leading or trailing spaces

            // Calls the corresponding method based on the user's menu selection

            switch (currentChoice) {
                case "1":
                    // displayMonthToDate() placeholder
                    displayMonthToDate(transactions);
                    break;
                case "2":
                    // displayPreviousMonth() placeholder
                    displayPreviousMonth(transactions);
                    break;
                case "3":
                    // displayYearToDate() placeholder
                    displayYearToDate(transactions);
                    break;
                case "4":
                    // displayPreviousYear() placeholder
                    displayPreviousYear(transactions);
                    break;
                case "5":
                    // searchTransactionsByVendor() placeholder
                    String vendor = read.nextLine().trim();
                    searchTransactionsByVendor(transactions, vendor);
                    break;
                case "6":
                    // customTransactionSearch() bonus implementation placeholder
                    System.out.println("PLACEHOLDER for customTransactionSearch()"); // BONUS TO DO
                case "0":
                    return; // Go back to the ledger page
                default:
                    System.out.println("Please enter 1, 2, 3, 4, 5, 6, or 0.");
            }
        }
    }

    // Display transactions from month to date method
    public static void displayMonthToDate(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== Display Month to Date's Transactions ====");

        // Get today's date
        LocalDate today = LocalDate.now();

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {

            // Gets the date of the current transaction
            LocalDate transactionDate = transaction.getLocalDate();

            // Check if the transaction is within the current month and year, excluding future dates
            if (transactionDate.getDayOfMonth() == today.getMonthValue() && transactionDate.getYear() == today.getYear() && !transactionDate.isAfter(today)) {
                System.out.println(transaction);
            }
        }
    }

    // Display transactions from the previous month method
    public static void displayPreviousMonth(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== Display Previous Month's Transactions ====");

        // Get the previous month's transactions
        LocalDate previousMonth = LocalDate.now().minusMonths(1);

        // Loops through the list of transactions
        for (Transaction transaction : transactions) {

            // Gets a transactions date
            LocalDate transactionDate = transaction.getLocalDate();

            if (transactionDate.getMonthValue() == previousMonth.getMonthValue() // Print transactions from the previous month and year
                    && transactionDate.getYear() == previousMonth.getYear()) {
                System.out.println(transaction);
            }

        }
    }

    // Display transactions from year to date method
    public static void displayYearToDate(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== Display Year to Date's Transactions ====");

        // Get today's date
        LocalDate todayDate = LocalDate.now();

        // Gets the first day of the current year
        LocalDate startOfYear = LocalDate.now().withDayOfYear(1);

        // Loops through all transactions
        for (Transaction transaction: transactions) {

            // Gets that transactions date
            LocalDate transactionsDate = transaction.getLocalDate();

            // If statement to check if the transaction happened between January 1 and today
            if (!transactionsDate.isBefore(startOfYear)
                    && !transactionsDate.isAfter(todayDate)) {
                System.out.println(transaction);
            }
        }
    }

    // Display transactions from the previous year method
    public static void displayPreviousYear(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== Display the Previous Year's Transactions ====");

        // Get the previous year's transactions
        LocalDate previousYear = LocalDate.now().minusYears(1);

        // Loops through all transactions
        for (Transaction transaction: transactions) {

            // Gets transactions date
            LocalDate transactionsDate = transaction.getLocalDate();

            // Check if the transaction occurred in the previous year
            if (transactionsDate.getYear() == previousYear.getYear()) {
                System.out.println(transaction);
            }
        }
    }

    // Search by vendor method
    public static void searchTransactionsByVendor(ArrayList<Transaction> transactions, String vendor) {
        System.out.println();
        System.out.println("==== Search Transactions By Vendor ====");

        // Loops through all transactions
        for (Transaction transaction: transactions) {

            // Gets the vendor name
            String transactionVendorName = transaction.getVendor();

            // Compare vendor names
            if (transactionVendorName.equalsIgnoreCase(vendor)) {
                System.out.println(transaction);
            }
        }
    }

}
