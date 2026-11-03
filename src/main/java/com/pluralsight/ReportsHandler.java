package com.pluralsight;

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
                    System.out.println("PLACEHOLDER for displayMonthToDate()");
                    break;
                case "2":
                    // displayPreviousMonth() placeholder
                    System.out.println("PLACEHOLDER for displayPreviousMonth()");
                    break;
                case "3":
                    // displayYearToDate() placeholder
                    System.out.println("PLACEHOLDER for displayYearToDate()");
                    break;
                case "4":
                    // displayPreviousYear() placeholder
                    System.out.println("PLACEHOLDER for displayPreviousYear()");
                    break;
                case "5":
                    // searchTransactionsByVendor() placeholder
                    System.out.println("PLACEHOLDER for searchTransactionsByVendor()");
                    break;
                case "6":
                    // customTransactionSearch() bonus implementation placeholder
                    System.out.println("PLACEHOLDER for customTransactionSearch()");
                case "0":
                    return; // Go back to the ledger page
                default:
                    System.out.println("Please enter 1, 2, 3, 4, 5, 6, or 0.");
            }
        }
    }

    // Display transactions from month to date method
    public static void displayMonthToDate(ArrayList<Transaction> transactions) {

    }

    // Display transactions from the previous month method
    public static void displayPreviousMonth(ArrayList<Transaction> transactions) {

    }

    // Display transactions from year to date method
    public static void displayYearToDate(ArrayList<Transaction> transactions) {

    }

    // Display transactions from the previous year method
    public static void displayPreviousYear(ArrayList<Transaction> transactions) {

    }

    // Search by vendor method
    public static void searchTransactionsByVendor(ArrayList<Transaction> transactions) {

    }

}
