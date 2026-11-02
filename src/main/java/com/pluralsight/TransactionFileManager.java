package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TransactionFileManager {

    // Saves the user's entered transaction to transactions.csv
    public static void saveTransaction(Transaction transaction) {

        // Try/Catch to handle validation
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("transactions.csv", true))) {

            // Write the formatted String to transactions.csv using toCsvString()
            writer.write(transaction.toCsvString());

            // Move to the next line
            writer.newLine();

        }
        catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    // ArrayList to read the users transactions and create Transaction objects
    public static ArrayList<Transaction> loadTransactions() {

        // Array of the list of transactions created
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        // Reads in the transactions.csv file and splits each section in its own variables
        try (BufferedReader reader = new BufferedReader(
                new FileReader("transactions.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {

                // Split each line into fields
                String[] fields = line.split("\\|"); // The | acts as a delimiter for splitting

                // Convert fields into their corresponding data types
                LocalDate localDate = LocalDate.parse(fields[0]);
                LocalTime localTime = LocalTime.parse(fields[1]);
                String description = fields[2];
                String vendor = fields[3];
                Double amount = Double.parseDouble(fields[4]);

                // Create a Transaction object that uses the parameterized constructor
                Transaction transaction = new Transaction(localDate, localTime, description, vendor, amount);

                // Add the object to transactionsList
                transactionsList.add(transaction);
            }

        }
        catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }

        return transactionsList;
    }
}
