package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class TransactionFileManager {

    // Saves the user's entered transaction to transactions.csv
    public static boolean saveTransaction(Transaction transaction) {

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
            return false;
        }

        return true;
    }

    // ArrayList to read the users transactions and create Transaction objects
    public static ArrayList<Transaction> loadTransactions() {

        // Array of the list of transactions created
        ArrayList<Transaction> transactionsList = new ArrayList<>();


        // Check if transactions.csv exists
        File transactionsFile = new File("transactions.csv");

        // Returns an empty ArrayList if the file doesn't exist
        if (!transactionsFile.exists()) {
            return transactionsList;
        }

        // Reads in the transactions.csv file and splits each section in its own variables
        try (BufferedReader reader = new BufferedReader(
                new FileReader(transactionsFile))) {

            String line;
            while ((line = reader.readLine()) != null) {

                // Skip empty lines in transactions.csv
                if (line.isBlank()) {
                    continue;
                }

                // Split each line into fields
                String[] fields = line.split("\\|"); // The | acts as a delimiter for splitting

                // Check if all five required fields exist
                if (fields.length != 5) {
                    System.out.println("Skipping invalid transaction: " + line);
                    continue;
                }

                // Convert fields into their corresponding data types
                LocalDate localDate = LocalDate.parse(fields[0]);
                LocalTime localTime = LocalTime.parse(fields[1]);
                String description = fields[2];
                String vendor = fields[3];
                double amount = Double.parseDouble(fields[4]);

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
