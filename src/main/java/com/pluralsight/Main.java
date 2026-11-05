package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner read = new Scanner(System.in);

        // Load all transactions from transactions.csv
        ArrayList<Transaction> transactions = TransactionFileManager.loadTransactions();

        // Start the home screen
        homeScreen(transactions, read);

        // Close the scanner
        read.close();


        // TO DOs for Wed
        // customSearchTransactions() - BONUS > Finished most, need to catch edge cases
        // Project theme = BONUS
        // Condense code and formatting
    }

    // Displays the main home screen
    // homeScreen passes loaded transactions from transactions.csv and scanner method
    public static void homeScreen(ArrayList<Transaction> transactions, Scanner read) {

        // Display loading animation
        displayLoading("Accessing the AfterPanel home screen...");

        // Display the AfterPanel logo and title once
        System.out.println("""
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣷⣶⡤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠠⣤⣤⣤⣤⣄⡀⣿⣿⣷⣳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣼⣿⣿⣿⣇⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣾⣿⣿⣿⣿⣷⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⡿⠗⠂⠀⠀⠀
        ⠀⠀⠀⠀⠀⣤⣴⣾⣟⣿⣿⠟⢀⣿⠟⢁⣟⡿⢻⣿⣷⣤⠤⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠉⠙⠛⢟⢹⣽⠙⠦⣨⣋⡴⠚⢋⣇⣾⠟⠋⠉⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠚⠓⢷⡏⠍⣴⠀⠁⠀⡶⠚⠛⠓⠂⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⣀⡀⢀⡌⡿⡤⡘⠃⢠⡊⠁⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⣠⣤⣾⡟⣿⣴⢏⡀⠓⠰⠼⣠⠑⠀⠀⢶⣼⡟⢲⣴⡀⠀⠀⠀⠀
        ⠀⠀⡖⣭⠓⣿⣾⡏⣿⣿⣦⣵⠀⠀⠀⡆⠀⢠⣶⣿⣿⢩⣼⣿⠘⣥⠒⡄⡄
        ⠀⣼⡇⣿⡰⡄⣿⡵⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⢢⢜⢣⠱⢠⠒⣱⡅
        ⣼⣿⣿⣸⡗⣷⡘⣷⢋⢶⣛⢿⣿⣿⣿⣿⣿⠿⢋⡴⢋⡌⢂⠧⣘⡣⣡⣿⣿

        ==========================================
                       AFTERPANEL
                   MANGA CAFE & LOUNGE
        ==========================================
                 Beyond the last panel.
        """);

        // Empty string to store the user's current choice
        String currentChoice = "";

        // While loop to keep going through the menu until X is entered
        while (!currentChoice.equalsIgnoreCase("X")) {  // Reformat later
            System.out.println("""
        ------------------------------------------
                       MAIN MENU
        ------------------------------------------

        D) Record Sales
        P) Record Expenses
        L) View Shop Ledger
        X) Close Shop

        ==========================================
        """);

            System.out.print("Enter your choice: ");

            // Read's the user's entered selection
            currentChoice = read.nextLine().trim(); // Removes any trailing or leading spaces

            // Calls the correct method based on the user's menu selection
            switch (currentChoice.toUpperCase()) { // Converts all user input to uppercase
                case "D":
                    // addDeposit()
                    addDeposit(transactions, read);
                    break;
                case "P":
                    // makePayment()
                    makePayment(transactions, read);
                    break;
                case "L":
                    // displayLoading() animation
                    displayLoading("Accessing the AfterPanel Ledger...");
                    // displayLedgerMenu() placeholder -> call from LedgerHandler class
                    // LedgerHandler.displayLedgerMenu(transactions, read)
                    LedgerHandler.displayLedgerMenu(transactions, read);
                    break;
                case "X":
                    displayLoading("Exiting the program...");
                    displayExitScreen();
                    return;
                default:
                    System.out.println("Please enter D, P, L, or X.");
            }
        }
    }

    // Lets the user make a deposit
    public static void addDeposit(ArrayList<Transaction> transactions, Scanner read) {
        System.out.println();
        System.out.println("==== Add Deposit ====");
        System.out.print("Enter description (Ex. Paycheck, Refund, etc): ");
        String description = read.nextLine();
        System.out.print("Enter vendor (Ex. Employer, IRS, etc) : ");
        String vendor = read.nextLine();

        // Empty amount variable to store user input and for validation
        double amount = 0;
        boolean isValid = false;

        // Added while loop and try catch for extra error handling when entering deposit amounts
        while (!isValid) {
            System.out.print("Enter deposit amount: ");
            try {
                amount = Double.parseDouble(read.nextLine());

                // If statement to make sure entered amount is a valid number and greater than 0
                if (Double.isFinite(amount) && amount > 0) {
                    isValid = true;
                }
                else  {
                    System.out.println("Entered amount must be greater than zero");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a number");
            }
        }

        // Create a new transaction object that stores the entered transactions
        Transaction enteredTransaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

        // If statement to check whether the transaction was successfully saved before add it
        if (TransactionFileManager.saveTransaction(enteredTransaction)) { // Saves the transaction to the transactions.csv file
            // Add the entered transaction to the transactions ArrayList
            transactions.add(enteredTransaction);
            System.out.println("Deposit added successfully");
        } else {
            System.out.println("Failed to save deposit.");
        }

    }

    // Lets the user make a payment
    public static void makePayment(ArrayList<Transaction> transactions, Scanner read) {
        System.out.println();
        System.out.println("==== Make a Payment ====");
        System.out.print("Enter description (Ex. Rent, Utilities, Groceries, etc): ");
        String description = read.nextLine();
        System.out.print("Enter vendor (Ex. Landlord, Xfinity, Costco, etc): ");
        String vendor = read.nextLine();

        // Empty amount variable to store user input and for validation
        double amount = 0;
        boolean isValid = false;

        // Added while loop and try catch for extra error handling when entering deposit amounts
        while (!isValid) {
            System.out.print("Enter payment amount: ");
            try {
                amount = Double.parseDouble(read.nextLine());

                // If statement to make sure entered amount is a valid number and greater than 0
                if (Double.isFinite(amount) && amount > 0) {
                    isValid = true;
                }
                else  {
                    System.out.println("Entered amount must be greater than zero");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a number");
            }
        }

        // Decrement the amount value
        amount = -amount;

        // Create a new transaction object that stores the entered transactions
        Transaction enteredTransaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

        // If statement to check whether the transaction was successfully saved before add it
        if (TransactionFileManager.saveTransaction(enteredTransaction)) { // Saves the transaction to the transactions.csv file
            // Add the entered transaction to the transactions ArrayList
            transactions.add(enteredTransaction);
            System.out.println("Payment added successfully");
        } else {
            System.out.println("Failed to save payment.");
        }
    }

    // Displays a loading animation when navigating between menus
    public static void displayLoading(String message) {

        System.out.println();
        System.out.println(message);

        // Display loading animation
        for (int i = 0; i < 10; i++) {
            System.out.print("▓▓▓");

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println();
    }

    // Displays the farewell screen when closing the shop
    public static void displayExitScreen() {

        System.out.println();
        System.out.println("""
            ⠀⠀⠀⠀⠀⢸⠓⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
            ⠀⠀⠀⠀⠀⢸⠀⠀⠑⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
            ⠀⠀⠀⠀⠀⢸⡆⠀⠀⠀⠙⢤⡷⣤⣦⣀⠤⠖⠚⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
            ⣠⡿⠢⢄⡀⠀⡇⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠸⠷⣶⠂⠀⠀⠀⣀⣀⠀⠀⠀
            ⢸⣃⠀⠀⠉⠳⣷⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⢉⡭⠋
            ⠀⠘⣆⠀⠀⠀⠁⠀⢀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀
            ⠀⠀⠘⣦⠆⠀⠀⢀⡎⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⡀⣠⠔⠋⠀⠀⠀⠀
            ⠀⠀⠀⡏⠀⠀⣆⠘⣄⠸⢧⠀⠀⠀⠀⢀⣠⠖⢻⠀⠀⠀⣿⢥⣄⣀⣀⣀⠀⠀
            ⠀⠀⢸⠁⠀⠀⡏⢣⣌⠙⠚⠀⠀⠠⣖⡛⠀⣠⠏⠀⠀⠀⠇⠀⠀⠀⠀⢙⣣⠄
            ⠀⠀⢸⡀⠀⠀⠳⡞⠈⢻⠶⠤⣄⣀⣈⣉⣉⣡⡔⠀⠀⢀⠀⠀⣀⡤⠖⠚⠀⠀
            ⠀⠀⡼⣇⠀⠀⠀⠙⠦⣞⡀⠀⢀⡏⠀⢸⣣⠞⠀⠀⠀⡼⠚⠋⠁⠀⠀⠀⠀⠀
            ⠀⢰⡇⠙⠀⠀⠀⠀⠀⠀⠉⠙⠚⠒⠚⠉⠀⠀⠀⠀⡼⠁⠀⠀⠀⠀⠀⠀⠀⠀
            ⠀⠀⢧⡀⠀⢠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
            ⠀⠀⠀⠙⣶⣶⣿⠢⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
            ⠀⠀⠀⠀⠀⠉⠀⠀⠀⠙⢿⣳⠞⠳⡄⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠹⣄⣀⡤⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀

            ==========================================
                           AFTERPANEL
                       MANGA CAFE & LOUNGE
            ==========================================

                     Thanks for stopping by!

                   See you in the next chapter.

                           またね! ✦

            ==========================================
            """);
    }
}