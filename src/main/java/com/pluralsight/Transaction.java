package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    // Variables
    private LocalDate localDate;
    private LocalTime localTime;
    private String description;
    private String vendor;
    private double amount;

    // Constructors

    // Parameterless Constructor
    public Transaction() {

    }

    // Parameterized Constructor
    public Transaction(LocalDate localDate, LocalTime localTime, String description, String vendor, double amount) {
        this.localDate = localDate;
        this.localTime = localTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }


    // Getters and Setters
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // toString() method for formatting
    @Override // We have @Override here to double-check our work
    public String toString() {
        return String.format("%s | %s | %s | %s | $%.2f",
                localDate, localTime, description, vendor, amount);
    }

    // to CsvString() method formats transaction information for saving to transactions.csv
    public String toCsvString() {
        return String.format("%s|%s|%s|%s|%.2f",
                localDate, localTime, description, vendor, amount );
    }

}
