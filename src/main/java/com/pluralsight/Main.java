package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Scanner

    }

    // Displays the main home screen
    // homeScreen passes loaded transactions from transactions.csv and scanner method
    public static void homeScreen(ArrayList<Transaction> transactions, Scanner read) {

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
            currentChoice = read.nextLine().trim(); // Removes any trailing or leading spaces

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
                    // LedgerHandler.displayLedgerMenu(transactions, read)
                    System.out.println("PLACEHOLDER FOR displayLedgerMenu()");
                case "X":
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
        System.out.print("Enter description: ");
        String description = read.nextLine();
        System.out.print("Enter vendor: ");
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
        System.out.print("Enter description: ");
        String description = read.nextLine();
        System.out.print("Enter vendor: ");
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
}