# AfterPanel Manga Cafe & Lounge

## Description
AfterPanel Manga Cafe & Lounge is a Java command-line accounting ledger built around a fictional manga café. The application allows users to record sales and expenses, track financial activity, and review transactions through a simple menu-driven interface. Every transaction includes a date, time, description, vendor, and amount, and is saved to `transactions.csv` so records can be loaded again when the program starts.

The project also includes separate ledger views for deposits and payments, date-based reports, and a custom search that filters transactions by multiple fields. To fit the café theme, I customized the menus with ASCII artwork, loading animations, and formatted transaction tables.

## Interesting Piece of Code
One part of the project I found interesting was **sorting transactions from newest to oldest** in `TransactionFileManager.java`. When transactions are loaded from the CSV file, I use Java's `Comparator.comparing()` to sort by date and `thenComparing()` to sort by time when two transactions share the same date. By default, this sorts from oldest to newest, so I added `reversed()` to display the most recent transactions first.

```java
// Sort transactions by date and time, newest first.
transactionsList.sort(Comparator.comparing(Transaction::getLocalDate)
        .thenComparing(Transaction::getLocalTime)
        .reversed());
```

This keeps the ledger organized without requiring users to manually sort entries. It also gave me practice using method references and chaining comparators to control how objects are ordered.

## UML Diagram
```

```

## File Structure
```text
src/main/java/com/pluralsight/
├── Main.java
├── Transaction.java
├── TransactionFileManager.java
├── LedgerHandler.java
├── ReportsHandler.java
└── DisplayHelper.java
transactions.csv
README.md
```


## Screenshots

### Home Screen
![AfterPanel home screen](screenshots/home-screen.png)

### Shop Ledger
![AfterPanel transaction ledger](screenshots/ledger.png)

### Reports & Custom Search
![AfterPanel reports and custom search](screenshots/reports.png)
