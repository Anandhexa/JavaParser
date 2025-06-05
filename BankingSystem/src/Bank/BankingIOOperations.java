import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

public class BankingIOOperations {
    public static void main(String[] args) {
        try {
            // Create necessary directories
            createDirectories();

            // Write customer data to a file
            writeCustomerData();

            // Read and display customer data
            readCustomerData();

            // Demonstrate console input/output
            handleUserInput();

            // Demonstrate binary file operations (transaction log)
            writeBinaryTransactionLog();
            readBinaryTransactionLog();

            // Demonstrate file copying and backup
            createBackup();

            // Demonstrate file properties and management
            displayFileProperties();

        } catch (IOException e) {
            System.err.println("An error occurred during I/O operations: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createDirectories() throws IOException {
        // Create directories for banking operations
        Path bankingDir = Paths.get("banking_data");
        Path backupDir = Paths.get("banking_data/backup");
        
        Files.createDirectories(bankingDir);
        Files.createDirectories(backupDir);
        System.out.println("Created necessary directories.");
    }

    private static void writeCustomerData() throws IOException {
        // Using BufferedWriter for efficient writing
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("banking_data/customers.txt"))) {
            
            writer.write("Customer ID,Name,Balance,Account Type\n");
            writer.write("1001,John Doe,5000.00,Savings\n");
            writer.write("1002,Jane Smith,7500.50,Checking\n");
            writer.write("1003,Robert Johnson,12000.75,Premium\n");
            
            System.out.println("Customer data written successfully.");
        }
    }

    private static void readCustomerData() throws IOException {
        System.out.println("\nReading customer data:");
        // Using BufferedReader for efficient reading
        try (BufferedReader reader = new BufferedReader(
                new FileReader("banking_data/customers.txt"))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void handleUserInput() {
        // Using Scanner for console input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nTransaction Entry System");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        
        // Write transaction to a file
        try (PrintWriter writer = new PrintWriter(
                new FileWriter("banking_data/transactions.txt", true))) {
            
            writer.printf("Account: %s, Amount: $%.2f%n", accountNumber, amount);
            System.out.println("Transaction recorded successfully.");
        } catch (IOException e) {
            System.err.println("Error recording transaction: " + e.getMessage());
        }
    }

    private static void writeBinaryTransactionLog() throws IOException {
        // Demonstrate binary file writing using DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("banking_data/transactions.dat"))) {
            
            // Write some sample transactions
            dos.writeInt(1001); // Account number
            dos.writeDouble(500.50); // Transaction amount
            dos.writeLong(System.currentTimeMillis()); // Timestamp
            
            dos.writeInt(1002);
            dos.writeDouble(750.25);
            dos.writeLong(System.currentTimeMillis());
            
            System.out.println("\nBinary transaction log created.");
        }
    }

    private static void readBinaryTransactionLog() throws IOException {
        System.out.println("\nReading binary transaction log:");
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("banking_data/transactions.dat"))) {
            
            while (dis.available() > 0) {
                int accountNumber = dis.readInt();
                double amount = dis.readDouble();
                long timestamp = dis.readLong();
                
                System.out.printf("Account: %d, Amount: $%.2f, Time: %d%n",
                        accountNumber, amount, timestamp);
            }
        }
    }

    private static void createBackup() throws IOException {
        // Demonstrate file copying using NIO
        Path sourcePath = Paths.get("banking_data/customers.txt");
        Path backupPath = Paths.get("banking_data/backup/customers_backup.txt");
        
        Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("\nBackup created successfully.");
    }

    private static void displayFileProperties() throws IOException {
        Path filePath = Paths.get("banking_data/customers.txt");
        System.out.println("\nFile Properties:");
        System.out.println("Exists: " + Files.exists(filePath));
        System.out.println("Size: " + Files.size(filePath) + " bytes");
        System.out.println("Last Modified: " + Files.getLastModifiedTime(filePath));
        System.out.println("Is Readable: " + Files.isReadable(filePath));
        System.out.println("Is Writable: " + Files.isWritable(filePath));
    }
}