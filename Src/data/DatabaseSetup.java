package Src.data;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {
    public static void initializeDatabase() {
        // SQL queries to create our tables
        String createSupplierTable = "CREATE TABLE IF NOT EXISTS suppliers (" +
                "supplierId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "contactPerson TEXT, " +
                "phone TEXT, " +
                "email TEXT);";

        String createProductTable = "CREATE TABLE IF NOT EXISTS products (" +
                "productId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "unitPrice REAL NOT NULL, " +
                "quantityInStock INTEGER NOT NULL);";

        String createStockMovementTable = "CREATE TABLE IF NOT EXISTS stock_movements (" +
                "movementId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "productId INTEGER, " +
                "movementType TEXT NOT NULL, " +
                "quantityChanged INTEGER NOT NULL, " +
                "timestamp TEXT NOT NULL, " +
                "FOREIGN KEY (productId) REFERENCES products(productId));";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            // Execute the table creation queries
            stmt.execute(createSupplierTable);
            stmt.execute(createProductTable);
            stmt.execute(createStockMovementTable);
            
            System.out.println("Database tables created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}