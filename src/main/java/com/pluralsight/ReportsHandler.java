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

            System.out.println("""
        

        ⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⡄⠀⠀
        ⢰⠒⠒⢻⣿⣶⡒⠒⠒⠒⠒⠒⠒⠒⠒⠒⡶⠊⣰⣓⡒⡆
        ⢸⢸⢻⣭⡙⢿⣿⣍⡉⠉⡇⣯⠉⠉⣩⠋⢀⣔⠕⢫⡇⡇
        ⢸⢸⣈⡻⣿⣶⣽⡸⣿⣦⡇⣧⠠⠊⣸⢶⠋⢁⡤⠧⡧⡇
        ⢸⢸⠻⣿⣶⣝⠛⣿⣮⢻⠟⣏⣠⠞⠁⣼⡶⠋⢀⣴⡇⡇
        ⢸⢸⣿⣶⣍⠻⠼⣮⡕⢁⡤⢿⢁⡴⠊⣸⣵⠞⠋⢠⡇⡇
        ⢸⢘⣛⡻⣿⣧⢳⣿⣧⠎⢀⣾⠋⡠⠞⢱⢇⣠⡴⠟⡇⡇
        ⢸⢸⠹⣿⣷⣎⣉⣻⢁⡔⢁⢿⡏⢀⣤⢾⡟⠁⣀⣎⡇⡇
        ⢸⢸⠲⣶⣭⡛⠚⢿⢋⡔⢁⣼⠟⢋⣠⣼⠖⠋⢁⠎⡇⡇
        ⢸⢸⢤⣬⣛⠿⠞⣿⢋⠔⣉⣾⠖⠋⢁⣯⡴⠞⢃⠂⡇⡇
        ⢸⢸⠀⢙⣻⢿⣧⣾⡵⠚⣉⣯⠶⠛⣹⣧⠤⢮⠁⠀⡇⡇
        ⠸⣘⠢⣄⠙⠿⢷⡡⠖⣋⣽⠥⠒⣩⣟⣤⣔⣁⡤⠖⣃⠇
        ⠀⠀⠙⠢⢍⣻⡿⠒⢉⣴⣗⣚⣽⣋⣀⣤⣊⠥⠒⠉⠀⠀
        ⠀⠀⠀⢀⣔⠥⠒⢮⣙⠾⠀⠷⣚⡭⠞⠉⠛⠦⣀⠀⠀⠀
        ⠀⠀⠀⠉⠀⠀⠀⠀⠈⠑⠒⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀

        ==========================================
                      AFTERPANEL
                     SHOP REPORTS
        ==========================================
                 Every page tells a story.

        1) Month to Date Transactions
        2) Previous Month Transactions
        3) Year to Date Transactions
        4) Previous Year Transactions
        5) Search Transactions by Vendor
        6) Custom Search
        0) Go back to Ledger

        ==========================================
        """);

            System.out.print("Enter your choice: ");


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
                    System.out.print("Enter vendor name: ");
                    String vendor = read.nextLine().trim();
                    searchTransactionsByVendor(transactions, vendor);
                    break;
                case "6":
                    // customTransactionSearch() bonus implementation placeholder
                    customTransactionSearch(transactions, read);
                case "0":
                    return; // Go back to the ledger page
                default:
                    System.out.println("Please enter choice from 0-6.");
            }
        }
    }

    // Display transactions from month to date method
    public static void displayMonthToDate(ArrayList<Transaction> transactions) {
        System.out.println();
        System.out.println("==== Display Month to Date's Transactions ====");

        // Get today's date
        LocalDate today = LocalDate.now();

        // Tracks whether any transactions are found
        boolean found = false;

        // Loops through the list of transactions
        for (Transaction transaction: transactions) {

            // Gets the date of the current transaction
            LocalDate transactionDate = transaction.getLocalDate();

            // Check if the transaction is within the current month and year, excluding future dates
            if (transactionDate.getMonthValue() == today.getMonthValue()
                    && transactionDate.getYear() == today.getYear()
                    && !transactionDate.isAfter(today)) {

                System.out.println(transaction);
                found = true;
            }
        }

        // Display a message if no matching transactions were found
        if (!found) {
            System.out.println("No transactions found for this month.");
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

        // Track whether a matching transaction was found
        boolean found = false;

        // Loops through all transactions
        for (Transaction transaction: transactions) {

            // Gets the vendor name
            String transactionVendorName = transaction.getVendor();

            // Compare vendor names
            if (transactionVendorName.equalsIgnoreCase(vendor.trim())) {
                System.out.println(transaction);
                found = true;
            }
        }

        // Display a message if no matching transactions were found
        if (!found) {
            System.out.println("No transactions found for vendor: " + vendor);
        }
    }

    // Custom search - BONUS
    public static void customTransactionSearch(ArrayList<Transaction> transactions, Scanner read) {

        // Program should let users enter what they want to filter results
        // Also should give users the ability to skip a condition

        System.out.println();
        System.out.println("==== Custom Search (Press Space to Skip Filter) ====");
        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDate = read.nextLine().trim(); // Pressing space be skipped because of the .trim() method
        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDate = read.nextLine().trim();
        System.out.print("Enter description: ");
        String description = read.nextLine().trim();
        System.out.print("Enter vendor: ");
        String vendor = read.nextLine().trim();
        System.out.print("Enter amount: ");
        String amount = read.nextLine().trim();


        // Boolean variable to handle cases where there are no matching custom results
        boolean found = false;

        double totalRevenue = 0; // Stores total revenue
        double totalExpenses = 0; // Stores total expenses

        // Loops through all transactions
        for (Transaction transaction: transactions) {

            // Checks if the transaction is on or after the start date (skips if blank)
            if (!startDate.isEmpty()) {

                // Convert the entered start date to LocalDate
                LocalDate enteredStartDate = LocalDate.parse(startDate);

                // Get the transaction's date
                LocalDate transactionDate = transaction.getLocalDate();

                // Skips transactions before the entered start date
                if (transactionDate.isBefore(enteredStartDate)) {
                    continue;
                }
            }

            // Checks if the transaction is on or before the end date (skips if blank)
            if (!endDate.isEmpty()) {

                // Convert the entered end date to LocalDate
                LocalDate enteredEndDate = LocalDate.parse(endDate);

                // Get the transaction's date
                LocalDate transactionDate = transaction.getLocalDate();

                // Skips the transactions after the entered end date
                if (transactionDate.isAfter(enteredEndDate)) {
                    continue;
                }
                // FOR LATER - HANDLE INVALID DATE INPUTS
            }

            // Checks if the description matches (skips if blank)
            if (!description.isEmpty()) {
                if (!transaction.getDescription().equalsIgnoreCase(description)) {
                    continue;
                }
            }

            // Checks if the vendor matches (skips if blank)
            if (!vendor.isEmpty()) {
                if (!transaction.getVendor().equalsIgnoreCase(vendor)) {
                    continue;
                }
            }

            // Checks if the transaction amount matches (skips if blank)
            if (!amount.isEmpty()) {

                // Convert the entered amount to double
                double enteredAmount = Double.parseDouble(amount);

                // Skips transactions that don't match the entered amount
                if (Double.compare(transaction.getAmount(), enteredAmount) != 0) {
                    continue;
                }
            }

            // Calculate the total revenue and expenses after all custom searches passed through
            if (transaction.getAmount() > 0) {
                totalRevenue += transaction.getAmount();
            } else {
                totalExpenses += Math.abs(transaction.getAmount());
            }

            // Display matching transactions
            System.out.println(transaction);
            found = true;
        }

        // Display results and financial summary
        if (!found) {
            System.out.println("No matching transactions found.");
        } else {
            double netIncome = totalRevenue - totalExpenses;
            displayFinancialSummary(totalRevenue, totalExpenses, netIncome);
        }
    }

    public static void displayFinancialSummary(
            double revenue,
            double expenses,
            double netIncome) {

        System.out.println("----------------------------------------");
        System.out.printf("Total Revenue: $%,.2f%n", revenue);
        System.out.printf("Total Expenses: $%,.2f%n", expenses);
        System.out.printf("Net Income: $%,.2f%n", netIncome);
        System.out.println("----------------------------------------");
    }

}
